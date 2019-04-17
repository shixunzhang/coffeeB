package com.dao;

import com.entity.CoffeeShopping;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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

    /**
     * 批量更新购物车
     * @param shoppingList
     * @return
     */
    int updateShoppingList(@Param("shoppingList") ArrayList<CoffeeShopping> shoppingList);

    /**
     * 添加前查询是否已经添加
     * @param coffeeShopping
     * @return
     */
    CoffeeShopping findShoppingByGoods(CoffeeShopping coffeeShopping);
}
