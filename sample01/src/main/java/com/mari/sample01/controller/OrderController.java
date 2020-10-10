package com.mari.sample01.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.config.AccessUser;
import com.mari.sample01.data.CmError;
import com.mari.sample01.data.SampleCmCode;
import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.req.CommonReqDto;
import com.mari.sample01.data.req.OrderReqDto.NewOrderParam;
import com.mari.sample01.facade.OrderFacade;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
	
	@Autowired
	private OrderFacade orderFacade;
	
	/**
	 * @apiNote 모든 주문내역 조회 API(관리자)
	 */
	@GetMapping("")
	@Secured("ROLE_ADMIN")
	public SampleCmCode<List<Order>> getAllOrderList(
			@RequestParam(required = false) LocalDate startDate
			, @RequestParam(required = false) LocalDate endDate
			, @RequestParam(required = false, defaultValue = "id") List<String> sortList
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "50") int size
			, @AuthenticationPrincipal AccessUser user){
		
		CommonReqDto common = CommonReqDto.builder()
								.startDate(startDate)
								.endDate(endDate)
								.page(page)
								.size(size)
								.sortList(sortList)
								.build();
		List<Order> orderList = orderFacade.getList(common);
		return new SampleCmCode<List<Order>>(HttpStatus.OK, CmError.CM_Success.getCmCode(), orderList);
	}
	
	/**
	 * @apiNote 회원 자신의 주문내역 조회 API
	 */
	@GetMapping("/user/list")
	@Secured("ROLE_USER")
	public SampleCmCode<List<Order>> getUserOrderList(
			@RequestParam(required = false) LocalDate startDate
			, @RequestParam(required = false) LocalDate endDate
			, @RequestParam(required = false) List<String> sortList
			, @RequestParam(required = false) int page
			, @RequestParam(required = false) int size
			, @AuthenticationPrincipal AccessUser user){
		CommonReqDto common = CommonReqDto.builder()
				.id(user.getId())
				.startDate(startDate)
				.endDate(endDate)
				.page(page)
				.size(size)
				.sortList(sortList)
				.build();
		List<Order> orderList = orderFacade.getList(common);
		return new SampleCmCode<List<Order>>(HttpStatus.OK, CmError.CM_Success.getCmCode(), orderList);
	}
	
	@GetMapping("/user")
	
	/**
	 * @apiNote 회원 주문 API
	 */
	@PostMapping("/user")
	@Secured("ROLE_USER")
	public Page<Order> postOrder(@RequestBody @Valid NewOrderParam newOrder, @AuthenticationPrincipal AccessUser user){
		
		return null;
	}
	
	
	
	
}
