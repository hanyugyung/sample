package com.mari.sample01.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto.CommonListReqDto;

public interface OrderFacade {

	Page<Order> getList(CommonListReqDto common, Pageable pageable);

}
