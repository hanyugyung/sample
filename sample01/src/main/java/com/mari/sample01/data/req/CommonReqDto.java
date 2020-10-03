package com.mari.sample01.data.req;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//필요시 추가하도록 한다
public class CommonReqDto {
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
    @Builder
	public static class CommonListReqDto {
		private Long id;
		private LocalDate startDate;
		private LocalDate endDate;
	}
}
