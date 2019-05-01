package com.service;

import com.entity.CoffeeAddress;

public interface AddressService {

    /**
     * 新增收货地址
     * @param coffeeAddress
     * @return
     */
    int addAddress(CoffeeAddress coffeeAddress);

    /**
     * 查询收货地址
     * @param addressId
     * @return
     */
    String getAddressById(int addressId);
}
