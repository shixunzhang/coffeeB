package com.dao;

import com.entity.CoffeeShopping;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShoppingDao {

    List<CoffeeShopping> selectList(int userId);


    int insertInt(CoffeeShopping coffeeShopping);


    int updateShopping(CoffeeShopping coffeeShopping);

    int deleteShopping(CoffeeShopping coffeeShopping);
}
