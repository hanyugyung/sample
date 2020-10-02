package com.mari.sample01.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.config.AccessUser;
import com.mari.sample01.data.dao.Order;
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
	public Page<Order> getAllOrderList(
			@RequestParam(required = false) LocalDate startDate
			, @RequestParam(required = false) LocalDate endDate
			, Pageable pageable
			, @AuthenticationPrincipal AccessUser user){
		
		return orderFacade.getList(pageable);
	}
	
	/**
	 * @apiNote 회원 자신의 주문내역 조회 API
	 */
	@GetMapping("/user/list")
	@Secured("ROLE_USER")
	public Page<Order> getUserOrderList(@AuthenticationPrincipal AccessUser user){
		
		return null;
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
