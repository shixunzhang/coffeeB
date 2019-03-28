package com.service.impl;

import com.common.ServerResponse;
import com.dao.OrderDao;
import com.entity.CoffeeOrder;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 查询订单列表
     * @param userId
     * @param finishFlag
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeOrder>> findOrderList(int userId, int finishFlag) {

        List<CoffeeOrder> list = orderDao.selectList(userId,finishFlag);

        if(list == null){
            return ServerResponse.createByErrorMessage("查询订单信息为空");
        }
        else{
            return ServerResponse.createBySuccess(list);
        }
    }

    /**
     * 批量加入订单
     * @param coffeeOrders
     * @return
     */
    @Override
    public int insertOrder(ArrayList<CoffeeOrder> coffeeOrders) {
        System.out.println(coffeeOrders);
        int result = orderDao.insertOrder(coffeeOrders);
        return result;
    }
}
