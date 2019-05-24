package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeOrder;
import com.entity.IdsDto;

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

    /**
     * 查询订单（按照嵌套数组形式）
     * @param coffeeOrder
     * @return
     */
    ServerResponse<List<IdsDto>> selectOrderList(CoffeeOrder coffeeOrder);

    /**
     * 管理端查询订单列表
     * @param coffeeOrder
     * @return
     */
    ServerResponse<List<CoffeeOrder>> ConsoleOrderList(CoffeeOrder coffeeOrder);

    /**
     * 查询订单 进行制作
     * @param coffeeOrder
     * @return
     */
    ServerResponse<List<CoffeeOrder>> ConsoleOrder(CoffeeOrder coffeeOrder);

    /**
     * 完成订单
     * @param coffeeOrder
     * @return
     */
    int FinishOrder(CoffeeOrder coffeeOrder);
}
