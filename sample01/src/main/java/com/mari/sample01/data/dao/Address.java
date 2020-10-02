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
public class Address extends Base {
	
	@Column
	private Long userId;	//회원 FK
	
	@Column
	private String zipcode;	//우편번호
	
	@Column
	private String address;	//주소
	
	@Column
	private String detailAddess; //상세주소
	
	@Column
	private String alias;	//배송지 별칭
	
}
