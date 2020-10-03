package com.mari.sample01.repository.impl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.repository.custom.OrderCustomRepository;

public class OrderCustomRepositoryImpl extends QuerydslRepositorySupport implements OrderCustomRepository {

	public OrderCustomRepositoryImpl() {
		super(Order.class);
		// TODO Auto-generated constructor stub
	}

}
