package com.mari.sample01.data.req;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

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
		private String loginId;
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
		@JsonFormat(pattern = "yyyy-MM-dd")	//post 는 jsonformat, get 은 datetimeformat, @notEmpty 와 같이 쓰면 오류남
		private LocalDate birth;
	}
}

/**
 * @NotEmpty 와 @JsonFormat 을 같이 쓸 때 다음과 같은 오류가 남
 * no validator could be found for constraint 'javax.validation.constraints.notempty' validating type 'java.time.localdate'. check configuration for
 * 
 * 
 * 
 * 
 */

