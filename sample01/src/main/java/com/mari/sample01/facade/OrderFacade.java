package com.mari.sample01.facade;

import java.util.List;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;

public interface OrderFacade {

	List<Order> getList(CommonReqDto common);

}
