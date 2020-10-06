package com.mari.sample01.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;
import com.mari.sample01.facade.OrderFacade;
import com.mari.sample01.service.OrderService;

@Component
public class OrderFacadeImpl implements OrderFacade {

	@Autowired
	private OrderService orderService;
	
	@Override
	public List<Order> getList(CommonReqDto common) {
		return orderService.getList(common);
	}

}
