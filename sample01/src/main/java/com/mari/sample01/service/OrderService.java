package com.mari.sample01.service;

import java.util.List;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;

public interface OrderService {
	List<Order> getList(CommonReqDto common);

}
