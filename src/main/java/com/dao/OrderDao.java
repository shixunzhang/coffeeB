package com.dao;

import com.entity.CoffeeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {

    /**
     * 查询订单列表
     * @param userId
     * @param finishFlag
     * @return
     */
    List<CoffeeOrder> selectList(@Param("userId") int userId,@Param("finishFlag") int finishFlag);

    /**
     * 批量插入订单
     * @param coffeeOrders
     * @return
     */
    int insertOrder(ArrayList<CoffeeOrder> coffeeOrders);

    /**
     * 查询用户不重复的no
     * @param coffeeOrder
     * @return
     */
    List<String> selectDistinctList(CoffeeOrder coffeeOrder);

    /**
     * 根据orderNo查询订单
     * @param orderNo
     * @return
     */
    List<CoffeeOrder> selectListByOrderNo(@Param("orderNo") String orderNo);
}
