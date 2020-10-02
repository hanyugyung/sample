package com.mari.sample01.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mari.sample01.data.dao.Order;

public interface OrderService {

	Page<Order> getList(Pageable pageable);

}
