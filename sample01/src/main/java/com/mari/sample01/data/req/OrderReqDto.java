package com.mari.sample01.data.req;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mari.sample01.data.enums.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderReqDto {
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
    @Builder
	public static class NewOrderParam {
		private String recipient; //수령인
		private Long addessId;	//배송지 FK
		private String extra;	//배송요청사항 등 extra 값
		private Integer regularPrice;
		private Integer totalPrice;
	}
}
