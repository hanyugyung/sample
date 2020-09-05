package com.mari.sample01.data.dao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mari.sample01.data.enums.UserRole;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User extends Base {
	
	@Column 
	private String loginId;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String name;
	
	@Column
	private String phoneNumber;
	
	@Column
	private LocalDate birth;
	
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
