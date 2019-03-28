package com.service.impl;

import com.common.ServerResponse;
import com.dao.ShoppingDao;
import com.entity.CoffeeOrder;
import com.entity.CoffeeShopping;
import com.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShoppingService")
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingDao shoppingDao;

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

    @Override
    public int addShopping(CoffeeShopping coffeeShopping) {
        int result = shoppingDao.insertInt(coffeeShopping);

        return result;
    }

    @Override
    public int updateShopping(CoffeeShopping coffeeShopping) {
//        Date day = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = df.format(day);
//        coffeeShopping.setUpdatedTime(new Date());
//        int result = shoppingDao.updateShopping(coffeeShopping,time);
        int result = shoppingDao.updateShopping(coffeeShopping);

        return result;
    }

    @Override
    public int deleteShopping(CoffeeShopping coffeeShopping) {
        int result =shoppingDao.deleteShopping(coffeeShopping);
        return result;
    }

    /**
     * 查找购物查信息
     * @param id
     * @return
     */
    @Override
    public CoffeeShopping findShoppingById(Integer id) {
        CoffeeShopping coffeeShopping = shoppingDao.findShoppingById(id);

        return coffeeShopping;
    }
}
