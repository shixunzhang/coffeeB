package com.controller;

import com.common.ServerResponse;
import com.entity.CoffeeAdminister;
import com.service.AdministerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/administer")
public class AdministerController {

    @Autowired
    private AdministerService administerService;


    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public ServerResponse<CoffeeAdminister> login(@RequestBody CoffeeAdminister coffeeAdminister) {
        ServerResponse<CoffeeAdminister> result=administerService.administerLogin(coffeeAdminister);
        if(result != null){
            return result;
        }
        else{
            return ServerResponse.createByErrorMessage("登录失败");
        }
    }

}
