package com.mari.sample01.data.req;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserReqDto {
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
    @Builder
	public static class UserLoginParam {
		@NotEmpty
		private String email;
		@NotEmpty
		private String password;
	}
	
	@Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	public static class UserSignUpParam {
		@NotEmpty
		private String loginId;
		@NotEmpty
		private String password;
		@NotEmpty @Email
		private String email;
		@NotEmpty
		private String name;
		@NotEmpty @Pattern(regexp = "^010[-](\\d{3}|\\d{4})[-](\\d{3}|\\d{4})$")	// 010-XXXX-XXXX
		private String phoneNumber;
		@NotEmpty
		private LocalDate birth;
	}
}
