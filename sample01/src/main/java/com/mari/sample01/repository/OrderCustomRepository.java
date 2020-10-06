package com.mari.sample01.repository;

import java.util.List;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;

public interface OrderCustomRepository {
	List<Order> getOrderList(CommonReqDto common);
}
