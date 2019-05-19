package com.service.impl;

import com.common.ServerResponse;
import com.dao.OrderDao;
import com.entity.CoffeeOrder;
import com.entity.IdsDto;
import com.service.OrderService;
import org.apache.ibatis.annotations.Param;
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
        int result = orderDao.insertOrder(coffeeOrders);
        return result;
    }

    /**
     * 查询订单列表（嵌套数组形式）
     * @param coffeeOrder
     * @return
     */
    @Override
    public ServerResponse<List<IdsDto>> selectOrderList(CoffeeOrder coffeeOrder) {
        System.out.println(coffeeOrder);
        List<String> noList = orderDao.selectDistinctList(coffeeOrder);
        System.out.println(noList);
        List<IdsDto> orderListResult = new ArrayList<>();
//        orderListResult.setData(new ArrayList<>());
        for (String orderNo : noList) {
            System.out.println(orderNo);
            IdsDto ids = new IdsDto();
            ids.setOrderList(orderDao.selectListByOrderNo(orderNo));
//            List<CoffeeOrder> listOrder = orderDao.selectListByOrderNo(orderNo);
////            if(!listOrder.isEmpty()){
////                orderListResult.add(listOrder);
////            }
            orderListResult.add(ids);
        }
        System.out.println(orderListResult);
        if(!orderListResult.isEmpty()){
            return ServerResponse.createBySuccess(orderListResult);
        }else{
            return ServerResponse.createBySuccess(null);
        }
    }
}
