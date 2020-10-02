package com.mari.sample01.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mari.sample01.data.enums.OrderStatus;
import com.mari.sample01.data.enums.UserRole;
import com.mari.sample01.data.req.OrderReqDto.NewOrderParam;
import com.mari.sample01.data.req.UserReqDto.UserSignUpParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "orders")
public class Order extends Base {
	
	@Column
	private Long userId;	//구매자 회원 FK
	
	@Column
	private String recipient; //수령인
	
	@Column
	private Long addessId;	//배송지 FK
	
	@Column @Enumerated(EnumType.STRING)
	private OrderStatus status;	//주문상태
	
	@Column
	private String extra;	//배송요청사항 등 extra 값
	
	@Column
	private Integer regularPrice;	//정가
	
	@Column
	private Integer totalPrice; //할인 포함 가
	
	public static Order of(NewOrderParam param, Long userId) {
		return Order.builder()
				.userId(userId)
				.recipient(param.getRecipient())
				.addessId(param.getAddessId())
				.status(OrderStatus.WAITING)
				.extra(param.getExtra())
				.regularPrice(param.getRegularPrice())
				.totalPrice(param.getTotalPrice())
				.build();
	}
}
