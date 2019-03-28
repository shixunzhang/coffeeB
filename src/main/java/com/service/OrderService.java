package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeOrder;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {

    /**
     * 查询订单列表
     * @param userId
     * @param finishFlag
     * @return
     */
    ServerResponse<List<CoffeeOrder>> findOrderList(int userId, int finishFlag);

    /**
     * 批量加入订单（下单）
     * @param coffeeOrders
     * @return
     */
    int insertOrder(ArrayList<CoffeeOrder> coffeeOrders);
}
