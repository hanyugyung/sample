package com.mari.sample01.data.dao;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.mari.sample01.data.req.GoodsReqDto.NewGoodsParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Goods extends Base {
	
	@Column
	private String name;

	public static Goods of(NewGoodsParam param) {
		return Goods.builder()
				.name(param.getName())
				.build();
	}
}
