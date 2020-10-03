package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto.CommonListReqDto;
import com.mari.sample01.repository.OrderRepository;
import com.mari.sample01.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Page<Order> getList(CommonListReqDto common, Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

}
