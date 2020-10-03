package com.mari.sample01.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto.CommonListReqDto;
import com.mari.sample01.facade.OrderFacade;
import com.mari.sample01.service.OrderService;

@Component
public class OrderFacadeImpl implements OrderFacade {

	@Autowired
	private OrderService orderService;
	
	@Override
	public Page<Order> getList(CommonListReqDto common, Pageable pageable) {
		return orderService.getList(common, pageable);
	}

}
