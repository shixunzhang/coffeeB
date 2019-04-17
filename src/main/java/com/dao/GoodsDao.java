package com.dao;

import com.entity.CoffeeGoods;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface GoodsDao {

    List<CoffeeGoods> findGoodsList(int goodsCategory);

    List<CoffeeGoods> goodsList(CoffeeGoods coffeeGoods, RowBounds rowBounds);

    List<CoffeeGoods> goodsListHelper(CoffeeGoods coffeeGoods);
}
