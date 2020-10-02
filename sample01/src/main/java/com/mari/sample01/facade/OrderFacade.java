package com.mari.sample01.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mari.sample01.data.dao.Order;

public interface OrderFacade {

	Page<Order> getList(Pageable pageable);

}
