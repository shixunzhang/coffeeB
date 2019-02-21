package com.service.impl;

import com.common.ServerResponse;
import com.dao.GoodsDao;
import com.entity.CoffeeGoods;
import com.entity.LastWill;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public ServerResponse<List<CoffeeGoods>> findGoodsList(int type) {

        List<CoffeeGoods> list = goodsDao.findGoodsList(type);

        if(list == null){
            return ServerResponse.createByErrorMessage("查询商品信息为空");
        }
        else{
            return ServerResponse.createBySuccess(list);
        }


    }
}
