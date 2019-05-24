package com.controller;

import com.common.HttpRequest;
import com.common.ServerResponse;
import com.common.Uuid;
import com.entity.CoffeeOrder;
import com.entity.CoffeeShopping;
import com.entity.CoffeeUser;
import com.entity.IdsDto;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.AddressService;
import com.service.OrderService;
import com.service.ShoppingService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private AddressService addressService;

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

    /**
     * 查询订单列表（分数组查询）
     * @param coffeeOrder
     * @return
     */
    @RequestMapping(value = "/listOrder.do",method = RequestMethod.POST)
    public ServerResponse<List<IdsDto>> selectOrderList(@RequestBody CoffeeOrder coffeeOrder) {
        ServerResponse<List<IdsDto>> result = orderService.selectOrderList(coffeeOrder);
        if(result.isSuccess()){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }


    /**
     * 下单（购物车加入订单）
     * @param idsDto
     * @return
     */
    @RequestMapping(value = "/insertList.do",method = RequestMethod.POST)
    public ServerResponse<Integer> insert(@RequestBody IdsDto idsDto) {
        ArrayList<CoffeeOrder> coffeeOrders = new ArrayList<>();
//        查询用户信息
        ServerResponse<CoffeeUser> coffeeUser = userService.findUserById(idsDto.getIdInt());
//        查询是否添加收货地址
        if(coffeeUser.getData().getTakeOut()==1 && coffeeUser.getData().getUserAddress()==-1){
            return ServerResponse.createByErrorMessage("外卖状态请先添加收货地址");
        }
        String address = "";
//        查询用户收货地址
        if(coffeeUser.getData().getTakeOut()==0){
            address = "-1";
        }else {
            address = addressService.getAddressById(coffeeUser.getData().getUserAddress());
        }
//        生成uuid
        String orderNo = Uuid.getUUID32();
//        设置order信息
        for (CoffeeShopping  coffeeShopping: idsDto.getShoppingList()) {
            CoffeeOrder coffeeOrder = new CoffeeOrder();
            coffeeOrder.setOrderAddress(address);
            coffeeOrder.setTakeOut(coffeeUser.getData().getTakeOut());
            coffeeOrder.setOrderNo(orderNo);
            coffeeOrder.setGoodName(coffeeShopping.getGoodName());
            coffeeOrder.setUserId(coffeeShopping.getUserId());
            coffeeOrder.setOrderNumber(coffeeShopping.getShoppingNumber());
            coffeeOrder.setTotalPrice(coffeeShopping.getTotalPrice());
            coffeeOrder.setGoodsId(coffeeShopping.getGoodId());
            coffeeOrder.setGoodsSize(coffeeShopping.getGoodSize());
            coffeeOrder.setGoodsSugar(coffeeShopping.getGoodSugar());
            coffeeOrder.setGoodsCategory(coffeeShopping.getGoodCategory());
            coffeeOrders.add(coffeeOrder);
        }
        int result = orderService.insertOrder(coffeeOrders);
        if(result>0){
            System.out.println(idsDto.getShoppingList());
            int insert = shoppingService.updateShoppingList(idsDto.getShoppingList());
            System.out.println(insert);
            if(insert>0){
                return ServerResponse.createBySuccessMessage("加入订单成功");
            }
            else{
                return ServerResponse.createByErrorMessage("加入订单失败");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("加入订单失败");
        }
    }





    /**
     * 查询订单列表
     * @param coffeeOrder
     * @return
     */
    @RequestMapping(value = "/ConsoleList.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeOrder>> ConsoleOrderList(@RequestBody CoffeeOrder coffeeOrder) {
        ServerResponse<List<CoffeeOrder>> result = orderService.ConsoleOrderList(coffeeOrder);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

    /**
     * 查询为完成的单个订单
     * @param coffeeOrder
     * @return
     */
    @RequestMapping(value = "/ConsoleOrder.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeOrder>> ConsoleOrder(@RequestBody CoffeeOrder coffeeOrder) {
        ServerResponse<List<CoffeeOrder>> result = orderService.ConsoleOrder(coffeeOrder);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }


    /**
     * 订单完成
     * @param coffeeOrder
     * @return
     */
    @RequestMapping(value = "/FinishOrder.do",method = RequestMethod.POST)
    public ServerResponse<Integer> FinishOrder(@RequestBody CoffeeOrder coffeeOrder) throws UnsupportedEncodingException {
        int result = orderService.FinishOrder(coffeeOrder);
        if(result>0){

            String phones = userService.findUserById(coffeeOrder.getUserId()).getData().getUserPhone();
            System.out.println(phones);
            String content = URLEncoder.encode("【咖啡预定App】您的订单已完成，请注意查收。订单号："+coffeeOrder.getOrderNo(),"UTF-8");
            String postData = "type=send&username=18242094436&password=DA53683DCC2BC2F42A238F1B2F3DBB1A&gwid=dceb8cfa&rece=json&mobile="+phones+"&message="+content+"";
            String url="http://jk.106api.cn/smsUTF8.aspx";
            String sendResult= HttpRequest.sendPost(url,postData);
            JsonObject userJsonObj = new JsonParser().parse(sendResult).getAsJsonObject();
            String status = userJsonObj .get("returnstatus").toString().replaceAll("\"", "");

            System.out.println(status);

            return ServerResponse.createBySuccessMessage("订单完成成功");
        }
        else{
            return ServerResponse.createByErrorMessage("订单完成失败");
        }
    }

}
