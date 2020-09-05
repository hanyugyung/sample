package com.mari.sample01.data.res;

import java.time.LocalDateTime;

import com.mari.sample01.data.dao.User;
import com.mari.sample01.data.res.UserResDto.UserSignUpDto.UserSignUpDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResDto {
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class UserLoginDto {
		private String token;
		private String userId;
	}
	
	@Getter
    @AllArgsConstructor
    @Builder
	public static class UserSignUpDto {
		private String loginId;
		private String regDate;
		private String modDate;
		private String name;
		
		public static UserSignUpDto ofEntity(User user) {
			return UserSignUpDto.builder()
					.loginId(user.getLoginId())
					.name(user.getName())
					.regDate(user.getRegDate().toString())
					.modDate(user.getModDate().toString())
					.build();
		}
	}
}
