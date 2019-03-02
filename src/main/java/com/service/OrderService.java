package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeOrder;

import java.util.List;

public interface OrderService {

    /**
     * 查询订单列表
     * @param userId
     * @param finishFlag
     * @return
     */
    ServerResponse<List<CoffeeOrder>> findOrderList(int userId, int finishFlag);
}
