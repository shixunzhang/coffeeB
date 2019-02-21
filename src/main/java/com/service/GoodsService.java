package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeGoods;

import java.util.List;

public interface GoodsService {

//    查询商品列表
    ServerResponse<List<CoffeeGoods>> findGoodsList(int type);
}
