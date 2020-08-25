package com.mari.sample01.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mari.sample01.common.token.JwtUtil;

import io.jsonwebtoken.Claims;

/**
 * @see UserDetails :: Spring security 에서 사용자의 정보를 담아두는 인터페이스 
 * @AuthenticationPrincipal User user 이런식으로 컨트롤러 파라미터 안에 넣으면 해당 요청을 한 user 정보를 가져올 수 있음
 */
public class User implements UserDetails{

	private final String prefix = "ROLE_";
	
	private Long id;
	private String email;
	private List<GrantedAuthority> authorities;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public User(String token) {
		Claims tokenBody = jwtUtil.getBodyFromToken(token);
		this.id = Long.parseLong((String) tokenBody.get("id"));
		this.email = (String) tokenBody.get("email");
		this.authorities.add(new SimpleGrantedAuthority(prefix + (String) tokenBody.get("role")));
	}
	
	public User(Long id, String email, String role) {
		
		this.authorities.add(new SimpleGrantedAuthority(prefix + role));
		this.id = id;
		this.email = email;
		
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;	//체크할 필요가 없으면 return true
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return null;
	}

}
