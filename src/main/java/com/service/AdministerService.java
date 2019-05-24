package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeAdminister;

public interface AdministerService {

    /**
     * 管理员登录
     * @param coffeeAdminister
     * @return
     */
    ServerResponse<CoffeeAdminister> administerLogin(CoffeeAdminister coffeeAdminister);
}
