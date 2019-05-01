package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeAddress;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/increase.do",method = RequestMethod.POST)
    public ServerResponse<Integer> addFeedBack(@RequestBody CoffeeAddress coffeeAddress){
        int result = addressService.addAddress(coffeeAddress);
        if(result==1){
            return ServerResponse.createBySuccessMessage("加入收货地址成功");
        }
        else{
            return ServerResponse.createByErrorMessage("加入收货地址失败");
        }
    }

}
