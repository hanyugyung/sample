package com.mari.sample01.data.dto;

import com.mari.sample01.data.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private Long id;
	private String loginId;
	private String name;
	private UserRole role;
}
