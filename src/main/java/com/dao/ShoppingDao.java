package com.dao;

import com.entity.CoffeeShopping;
import java.util.List;

public interface ShoppingDao {

    List<CoffeeShopping> selectList(int userId);


    int insertInt(CoffeeShopping coffeeShopping);


    int updateShopping(CoffeeShopping coffeeShopping);

    int deleteShopping(CoffeeShopping coffeeShopping);

    /**
     * 查找购物车信息
     * @param shoppingId
     * @return
     */
    CoffeeShopping findShoppingById(Integer shoppingId);
}
