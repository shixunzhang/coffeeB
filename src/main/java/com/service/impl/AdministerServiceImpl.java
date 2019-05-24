package com.service.impl;

import com.common.ServerResponse;
import com.dao.AdministerDao;
import com.entity.CoffeeAdminister;
import com.service.AdministerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdministerService")
public class AdministerServiceImpl implements AdministerService {

    @Autowired
    private AdministerDao administerDao;

    /**
     * 管理员登录
     * @param coffeeAdminister
     * @return
     */
    @Override
    public ServerResponse<CoffeeAdminister> administerLogin(CoffeeAdminister coffeeAdminister) {

        CoffeeAdminister administerResult = administerDao.findAdministerByName(coffeeAdminister.getAdministerName());
        if(administerResult==null){
            return ServerResponse.createByErrorMessage("此账号对应管理员不存在");
        }
        else if (administerResult != null && administerResult.getAdministerPassword().equals(coffeeAdminister.getAdministerPassword())) {
            return ServerResponse.createBySuccess(administerResult);
        }
        else{
            return ServerResponse.createByErrorMessage("账号或密码错误");
        }
    }


}
