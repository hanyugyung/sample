package com.mari.sample01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;
import com.mari.sample01.repository.OrderRepository;
import com.mari.sample01.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getList(CommonReqDto common) {
		return orderRepository.getOrderList(common);
	}

}
