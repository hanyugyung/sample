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


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "USER")
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
				.password(param.getPassword())
				.email(param.getEmail())
				.name(param.getName())
				.phoneNumber(param.getPhoneNumber())
				.birth(param.getBirth())
				.build();
	}
	
}
