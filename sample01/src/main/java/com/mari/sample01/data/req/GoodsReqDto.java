package com.mari.sample01.data.req;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GoodsReqDto {
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
    @Builder
	public static class NewGoodsParam {
		
		@NotBlank
		private String name;
	}
}
