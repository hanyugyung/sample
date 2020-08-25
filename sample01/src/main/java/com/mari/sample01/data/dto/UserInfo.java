package com.mari.sample01.data.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfo {
	private Long id;
	private String email;
	private String role;
}
