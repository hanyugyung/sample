package com.mari.sample01.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mari.sample01.data.CmError;
import com.mari.sample01.data.SampleCmCode;
import com.mari.sample01.data.dao.Goods;
import com.mari.sample01.data.req.GoodsReqDto.NewGoodsParam;
import com.mari.sample01.service.GoodsService;

@RequestMapping("/api/goods")
@RestController
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * @apiNote 상품 등록 API
	 */
	@PostMapping("")
	@Secured("ROLE_ADMIN")
	public SampleCmCode<Goods> postGoods(@RequestBody @Valid NewGoodsParam param){
		 return new SampleCmCode<Goods>(
				 HttpStatus.OK, CmError.CM_Success.getCmCode(), goodsService.registerGoods(param));
	}
	
	
}
