package com.service;

import com.entity.CoffeeAddress;

public interface AddressService {

    /**
     * 新增收货地址
     * @param coffeeAddress
     * @return
     */
    int addAddress(CoffeeAddress coffeeAddress);
}
