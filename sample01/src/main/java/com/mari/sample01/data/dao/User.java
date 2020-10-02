package com.mari.sample01.data.dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mari.sample01.data.enums.UserRole;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User extends Base {
	
	@Column 
	private String loginId;		//로그인 id
	
	@Column
	private String password;	//암호
	
	@Column
	private String email;		//이메일
	
	@Column
	private String name;		//이름
	
	@Column
	private String phoneNumber;	//연락처
	
	@Column
	private LocalDate birth;	//생일
	
	@Column @Enumerated(EnumType.STRING)
	private UserRole role;
	
	public static User of(UserSignUpParam param) {
		return User.builder()
				.loginId(param.getLoginId())
				.password(new BCryptPasswordEncoder().encode(param.getPassword()))
				.email(param.getEmail())
				.name(param.getName())
				.phoneNumber(param.getPhoneNumber())
				.birth(param.getBirth())
				.role(UserRole.USER)
				.build();
	}
	
}
