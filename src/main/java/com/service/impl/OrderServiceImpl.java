package com.service.impl;

import com.common.ServerResponse;
import com.dao.OrderDao;
import com.entity.CoffeeOrder;
import com.entity.IdsDto;
import com.github.pagehelper.PageHelper;
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
        if(coffeeOrder.getPageNum()==null){
            coffeeOrder.setPageNum(0);
        }
        if(coffeeOrder.getPageSize()==null){
            coffeeOrder.setPageSize(0);
        }
        System.out.println(coffeeOrder);
        PageHelper.startPage(coffeeOrder.getPageNum(),coffeeOrder.getPageSize());
        List<String> noList = orderDao.selectDistinctList(coffeeOrder);

        System.out.println(noList.size());
        List<IdsDto> orderListResult = new ArrayList<>();
        for (String orderNo : noList) {
            IdsDto ids = new IdsDto();
            ids.setOrderList(orderDao.selectListByOrderNo(orderNo));
//            List<CoffeeOrder> listOrder = orderDao.selectListByOrderNo(orderNo);
////            if(!listOrder.isEmpty()){
////                orderListResult.add(listOrder);
////            }
            orderListResult.add(ids);
        }
        if(!orderListResult.isEmpty()){
            return ServerResponse.createBySuccess(orderListResult);
        }else{
            return ServerResponse.createBySuccess(null);
        }
    }


    /**
     * 管理端查询订单列表
     * @param coffeeOrder
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeOrder>> ConsoleOrderList(CoffeeOrder coffeeOrder) {

        Integer count = orderDao.selectCount(coffeeOrder);
        PageHelper.startPage(coffeeOrder.getPageNum(),coffeeOrder.getPageSize());
        List<CoffeeOrder> list = orderDao.ConsoleOrderList(coffeeOrder);
        if(list == null){
            return ServerResponse.createByErrorMessage("查询订单信息为空");
        }
        else{
            return ServerResponse.createBySuccess(count.toString(),list);
        }
    }

    /**
     * 管理端查询单个订单
     * @param coffeeOrder
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeOrder>> ConsoleOrder(CoffeeOrder coffeeOrder) {

        String orderNo = orderDao.selectOrderNo();
        System.out.println(orderNo);
        if(orderNo!=null){
            List<CoffeeOrder> listOrder = orderDao.selectListByOrderNo(orderNo);
            if(!listOrder.isEmpty()){
                return ServerResponse.createBySuccess(listOrder);
            }else{
                return ServerResponse.createByErrorMessage("查询订单信息失败");
            }
        }else{
            return ServerResponse.createBySuccess(null);
        }

    }

    /**
     * 订单制作完成
     * @param coffeeOrder
     * @return
     */
    @Override
    public int FinishOrder(CoffeeOrder coffeeOrder) {
        int result = orderDao.FinishOrder(coffeeOrder);

        return result;
    }
}
