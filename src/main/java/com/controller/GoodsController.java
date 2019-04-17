package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeGoods;
import com.service.GoodsService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询商品列表
     * @param coffeeGoods
     * @return
     */
    @RequestMapping(value = "/list.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeGoods>> selectList(@RequestBody CoffeeGoods coffeeGoods) {
        ServerResponse<List<CoffeeGoods>> result = goodsService.findGoodsList(coffeeGoods.getGoodsCategory());
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

    /**
     * RowBounds 方式分页测试
     * @param coffeeGoods
     * @return
     */
    @RequestMapping(value = "/goodsList.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeGoods>> goodsList(@RequestBody CoffeeGoods coffeeGoods) {
        ServerResponse<List<CoffeeGoods>> result = goodsService.goodsList(coffeeGoods,new RowBounds(coffeeGoods.getPageNum(), coffeeGoods.getPageSize()));
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

    /**
     * helper 方式分页测试
     * @param coffeeGoods
     * @return
     */
    @RequestMapping(value = "/goodsListHelper.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeGoods>> goodsListHelper(@RequestBody CoffeeGoods coffeeGoods) {
        ServerResponse<List<CoffeeGoods>> result = goodsService.goodsListHelper(coffeeGoods);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

}
