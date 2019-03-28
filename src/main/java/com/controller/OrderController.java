package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeOrder;
import com.entity.CoffeeShopping;
import com.entity.CoffeeUser;
import com.entity.IdsDto;
import com.service.OrderService;
import com.service.ShoppingService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * 查询订单列表
     * @param coffeeOrder
     * @return
     */
    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeOrder>> selectList(@RequestBody CoffeeOrder coffeeOrder) {
        ServerResponse<List<CoffeeOrder>> result = orderService.findOrderList(coffeeOrder.getUserId(),coffeeOrder.getFinishFlag());
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

//    @RequestMapping(value = "/insertList.do",method = RequestMethod.POST)
////    public ServerResponse<Integer> insertOrder(@RequestBody ArrayList<CoffeeOrder> coffeeOrders) {
//    public ServerResponse<Integer> insertOrder(@RequestBody ArrayList<CoffeeOrder> coffeeOrders) {
//        int result = orderService.insertOrder(coffeeOrders);
//        if(result>0){
//            return ServerResponse.createBySuccessMessage("加入订单成功");
//        }
//        else{
//            return ServerResponse.createByErrorMessage("加入订单失败");
//        }
//    }

    @RequestMapping(value = "/insertList.do",method = RequestMethod.POST)
    public ServerResponse<Integer> insert(@RequestBody IdsDto idsDto) {
        System.out.println(idsDto.getShoppingList());
        ArrayList<CoffeeOrder> coffeeOrders = new ArrayList<>();
        ServerResponse<CoffeeUser> coffeeUser = userService.findUserById(idsDto.getIdInt());
        System.out.println(coffeeUser.getData());
        for (CoffeeShopping  coffeeShopping: idsDto.getShoppingList()) {
            CoffeeOrder coffeeOrder = new CoffeeOrder();
            coffeeOrder.setOrderAddress(coffeeUser.getData().getUserAddress());
            coffeeOrder.setTakeOut(coffeeUser.getData().getTakeOut());
            coffeeOrder.setOrderNo("123456789");
            coffeeOrder.setGoodName(coffeeShopping.getGoodName());
            coffeeOrder.setUserId(coffeeShopping.getUserId());
            coffeeOrder.setOrderNumber(coffeeShopping.getShoppingNumber());
            coffeeOrder.setTotalPrice(coffeeShopping.getTotalPrice());
            coffeeOrder.setGoodsId(coffeeShopping.getGoodsId());
            coffeeOrder.setGoodsSize(coffeeShopping.getGoodSize());
            coffeeOrder.setGoodsSugar(coffeeShopping.getGoodSugar());
            coffeeOrders.add(coffeeOrder);
        }
        System.out.println(coffeeOrders);
        int result = orderService.insertOrder(coffeeOrders);
        if(result>0){
            return ServerResponse.createBySuccessMessage("加入订单成功");
        }
        else{
            return ServerResponse.createByErrorMessage("加入订单失败");
        }
    }

}
