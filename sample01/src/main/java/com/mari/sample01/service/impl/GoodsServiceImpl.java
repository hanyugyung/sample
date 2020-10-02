package com.mari.sample01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mari.sample01.data.CmError;
import com.mari.sample01.data.dao.Goods;
import com.mari.sample01.data.req.GoodsReqDto.NewGoodsParam;
import com.mari.sample01.exception.SampleException;
import com.mari.sample01.repository.GoodsRepository;
import com.mari.sample01.service.GoodsService;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsRepository goodsRepository;
	
	@Override
	public Goods registerGoods(NewGoodsParam param) {
		Goods goods = Goods.of(param);
		try {
			goods = goodsRepository.save(goods);
		}catch(Exception e) {
			throw new SampleException(CmError.CM_Internal_ServerError);
		}
		return goods;
	}

}
