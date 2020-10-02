package com.mari.sample01.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class OrderItem extends Base{
	
	@Column
	private Long orderId;	//주문 FK
	
	@Column
	private Long goodsId;	//상품 FK
	
	@Column
	private Integer count;	//수량
	
	@Column
	private Boolean canceled;	//취소되었나?
	
	@Column
	private Boolean refunded;	//환불되었나?
	
	@Column 
	private Boolean exchanged;	//교환되었나?
	
}
