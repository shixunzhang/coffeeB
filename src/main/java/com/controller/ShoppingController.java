package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeGoods;
import com.entity.CoffeeShopping;
import com.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    /**
     * 查询购物车列表
     * @param coffeeShoping
     * @return
     */
    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeShopping>> selectList(@RequestBody CoffeeShopping coffeeShoping) {
        ServerResponse<List<CoffeeShopping>> result = shoppingService.selectList(coffeeShoping.getUserId());
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

    /**
     * 将商品加入购物车
     * @param coffeeShopping
     * @return
     */
    @RequestMapping(value = "/addShopping.do",method = RequestMethod.POST)
    public ServerResponse<Integer>addShopping(@RequestBody CoffeeShopping coffeeShopping){
        System.out.println(coffeeShopping.getUserId());
        System.out.println(coffeeShopping.getGoodId());
        System.out.println(coffeeShopping.getGoodSize());
        System.out.println(coffeeShopping.getGoodSugar());
        System.out.println(coffeeShopping.getTotalPrice());
        CoffeeShopping shoppingGoods = shoppingService.findShoppingByGoods(coffeeShopping);
        if(shoppingGoods!=null){
            double price=shoppingGoods.getTotalPrice()+coffeeShopping.getTotalPrice();
            System.out.println(price);
            int number = shoppingGoods.getShoppingNumber()+coffeeShopping.getShoppingNumber();
            shoppingGoods.setTotalPrice(price);
            shoppingGoods.setShoppingNumber(number);
            int result = shoppingService.updateShopping(shoppingGoods);
            if(result==1){
                return ServerResponse.createBySuccessMessage("加入购物车成功");
            }
            else{
                return ServerResponse.createByErrorMessage("加入购物车失败");
            }
        }else{
            int result = shoppingService.addShopping(coffeeShopping);
            if(result==1){
                return ServerResponse.createBySuccessMessage("加入购物车成功");
            }
            else{
                return ServerResponse.createByErrorMessage("加入购物车失败");
            }
        }
    }


    /**
     * 更新购物车中商品信息
     * @param coffeeShopping
     * @return
     */
    @RequestMapping(value = "/updateShopping.do",method = RequestMethod.POST)
    public ServerResponse<Integer> updateShopping(@RequestBody CoffeeShopping coffeeShopping){
        int result = 0;
        if(coffeeShopping.getShoppingNumber()==0){
            result = shoppingService.deleteShopping(coffeeShopping);
        }else{
            result = shoppingService.updateShopping(coffeeShopping);
        }
        if(result==1){
            return ServerResponse.createBySuccessMessage("更改购物车中商品成功");
        }
        else{
            return ServerResponse.createByErrorMessage("更新商品信息失败");
        }
    }


}


