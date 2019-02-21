package com.dao;

import com.entity.CoffeeGoods;

import java.util.List;

public interface GoodsDao {

    List<CoffeeGoods> findGoodsList(int goodsCategory);
}
