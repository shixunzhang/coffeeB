package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeOrder;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

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

}
