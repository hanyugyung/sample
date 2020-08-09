package com.mari.sample01.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @see UserDetails :: Spring security 에서 사용자의 정보를 담아두는 인터페이스 
 * @AuthenticationPrincipal User user 이런식으로 컨트롤러 파라미터 안에 넣으면 해당 요청을 한 user 정보를 가져올 수 있음
 */
public class User implements UserDetails{

	private final String prefix = "ROLE_";
	
	private String id;
	private String username;
	private String email;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public User(String username, String password, List<String> roles) {
		
		roles.stream().forEach(role -> this.authorities.add(
					 new SimpleGrantedAuthority(prefix + role)));
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = null;
		
	}
	
	public String getUid() {
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
	public String getUsername() {
		return this.username;
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

}
