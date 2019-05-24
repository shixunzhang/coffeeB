package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeGoods;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface GoodsService {

    /**
     * 查询商品列表
     * @param type
     * @return
     */
    ServerResponse<List<CoffeeGoods>> findGoodsList(int type);

    ServerResponse<List<CoffeeGoods>> goodsList(CoffeeGoods coffeeGoods, RowBounds rowBounds);

    ServerResponse<List<CoffeeGoods>> goodsListHelper(CoffeeGoods coffeeGoods);
}
