package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeAddress;
import com.entity.CoffeeUser;
import com.service.AddressService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    /**
     * 新增收货地址
     * @param coffeeAddress
     * @return
     */
    @RequestMapping(value = "/increase.do",method = RequestMethod.POST)
    public ServerResponse<Integer> addAddress(@RequestBody CoffeeAddress coffeeAddress){
        int result = addressService.addAddress(coffeeAddress);
        if(result>0){
            ServerResponse<CoffeeUser> user = userService.findUserById(coffeeAddress.getUserId());
//            用户第一次设置地址时候直接设置为默认
            if(user.getData().getUserAddress()==-1){
                CoffeeUser coffeeUser = new CoffeeUser();
                coffeeUser.setUserId(coffeeAddress.getUserId());
                coffeeUser.setUserAddress(result);
                int addressResult = userService.updateUserMsg(coffeeUser);
                if(addressResult>0){
                    return ServerResponse.createBySuccessMessage("加入收货地址成功");
                }else{
                    return ServerResponse.createByErrorMessage("加入收货地址成功,但未设置为默认");
                }
            }else{
                return ServerResponse.createBySuccessMessage("加入收货地址成功");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("加入收货地址失败");
        }
    }

    /**
     * 查找地址列表
     * @param coffeeUser
     * @return
     */
    @RequestMapping(value = "/addressList.do",method = RequestMethod.POST)
    public ServerResponse<List<CoffeeAddress>> addressList(@RequestBody CoffeeUser coffeeUser){
        ServerResponse<List<CoffeeAddress>> result = addressService.findAddressList(coffeeUser.getUserId());
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("查询商品列表失败");
        }
    }

    /**
     * 刪除收货地址
     * @param coffeeAddress
     * @return
     */
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    public ServerResponse<Integer> deleteAddress(@RequestBody CoffeeAddress coffeeAddress){
        int result = addressService.deleteAddress(coffeeAddress);
        ServerResponse<CoffeeUser> userResult=userService.findUserById(coffeeAddress.getUserId());
//        删除地址成功
        if(result>0){
            ServerResponse<List<CoffeeAddress>> addressList = addressService.findAddressList(coffeeAddress.getUserId());
//            删除后无地址
            if(addressList.getData().isEmpty()){
                CoffeeUser coffeeUser = new CoffeeUser();
                coffeeUser.setUserId(coffeeAddress.getUserId());
                coffeeUser.setUserAddress(-1);
                int addressResult = userService.changeAddress(coffeeUser);
                if(addressResult>0){
                    return ServerResponse.createBySuccessMessage("删除收货地址成功");
                }else{
                    return ServerResponse.createByErrorMessage("删除收货地址成功,但未设置为空");
                }
            }else{
//                把默认地址删除了
                if(userResult.getData().getUserAddress()==coffeeAddress.getAddressId()){
                    CoffeeUser coffeeUser = new CoffeeUser();
                    coffeeUser.setUserId(coffeeAddress.getUserId());
                    coffeeUser.setUserAddress(addressList.getData().get(0).getAddressId());
                    int addressResult = userService.changeAddress(coffeeUser);
                    if(addressResult>0){
                        return ServerResponse.createBySuccessMessage("删除收货地址成功");
                    }else{
                        return ServerResponse.createByErrorMessage("删除收货地址成功,但未修改默认");
                    }
                }else{
                    return ServerResponse.createBySuccessMessage("删除收货地址成功");
                }
            }
        }
        else{
            return ServerResponse.createByErrorMessage("删除收货地址失败");
        }
    }

    /**
     * 修改收货地址
     * @param coffeeAddress
     * @return
     */
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    public ServerResponse<Integer> updateAddress(@RequestBody CoffeeAddress coffeeAddress){
        System.out.println(coffeeAddress.getMajor());
        int result = addressService.updateAddress(coffeeAddress);
        if(result>0){
//            修改为默认地址
            if(coffeeAddress.getMajor()==1){
                CoffeeUser coffeeUser = new CoffeeUser();
                coffeeUser.setUserId(coffeeAddress.getUserId());
                coffeeUser.setUserAddress(coffeeAddress.getAddressId());
                int addressResult = userService.changeAddress(coffeeUser);
                if(addressResult>0){
                    return ServerResponse.createBySuccessMessage("修改收货地址成功");
                }else{
                    return ServerResponse.createByErrorMessage("修改收货地址成功，但是未设置为默认");
                }
            }else{
                return ServerResponse.createBySuccessMessage("修改收货地址成功");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("修改收货地址失败");
        }
    }

}
