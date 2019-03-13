package com.service;


import com.common.ServerResponse;
import com.entity.CoffeeShopping;

import java.util.List;

public interface ShoppingService {

    /**
     * 查询购物车列表
     * @param userId
     * @return
     */
    ServerResponse<List<CoffeeShopping>> selectList(int userId);

    /**
     * 商品加入购物车
     * @param coffeeShopping
     * @return
     */
    int addShopping(CoffeeShopping coffeeShopping);

    /**
     * 更新购物车中商品
     * @param coffeeShopping
     * @return
     */
    int updateShopping(CoffeeShopping coffeeShopping);

    /**
     * 逻辑删除购物车中商品
     * @param coffeeShopping
     * @return
     */
    int deleteShopping(CoffeeShopping coffeeShopping);
}
