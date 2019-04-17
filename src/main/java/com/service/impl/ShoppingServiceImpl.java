package com.service.impl;

import com.common.ServerResponse;
import com.dao.ShoppingDao;
import com.entity.CoffeeShopping;
import com.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ShoppingService")
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingDao shoppingDao;

    /**
     * 查找购物车商品信息
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeShopping>> selectList(int userId) {
        List<CoffeeShopping> list = shoppingDao.selectList(userId);

        if(list == null){
            return ServerResponse.createByErrorMessage("查询购物车信息为空");
        }
        else{
            return ServerResponse.createBySuccess(list);
        }
    }

    /**
     * 添加商品到购物车
     * @param coffeeShopping
     * @return
     */
    @Override
    public int addShopping(CoffeeShopping coffeeShopping) {
        int result = shoppingDao.insertInt(coffeeShopping);

        return result;
    }

    /**
     * 更新购物车信息
     * @param coffeeShopping
     * @return
     */
    @Override
    public int updateShopping(CoffeeShopping coffeeShopping) {
        int result = shoppingDao.updateShopping(coffeeShopping);

        return result;
    }

    @Override
    public int deleteShopping(CoffeeShopping coffeeShopping) {
        int result =shoppingDao.deleteShopping(coffeeShopping);
        return result;
    }

    /**
     * 查找购物车信息
     * @param id
     * @return
     */
    @Override
    public CoffeeShopping findShoppingById(Integer id) {
        CoffeeShopping coffeeShopping = shoppingDao.findShoppingById(id);

        return coffeeShopping;
    }

    /**
     * 加入订单后批量更新
     * @param shoppingList
     * @return
     */
    @Override
    public int updateShoppingList(ArrayList<CoffeeShopping> shoppingList) {
        int result = shoppingDao.updateShoppingList(shoppingList);
        return result;
    }

    /**
     * 通过shoppingModel 查询数据（添加前查询是否已经添加）
     * @param coffeeShopping
     * @return
     */
    @Override
    public CoffeeShopping findShoppingByGoods(CoffeeShopping coffeeShopping) {
        CoffeeShopping coffeeShopping1 = shoppingDao.findShoppingByGoods(coffeeShopping);
        return coffeeShopping1;
    }
}
