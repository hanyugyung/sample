package com.mari.sample01.service;

import com.mari.sample01.data.dao.Goods;
import com.mari.sample01.data.req.GoodsReqDto.NewGoodsParam;

public interface GoodsService {
	Goods registerGoods(NewGoodsParam param);
}
