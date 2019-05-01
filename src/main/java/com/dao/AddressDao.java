package com.dao;

import com.entity.CoffeeAddress;

public interface AddressDao {

    /**
     * 查询用户收货地址
     * @param addressId
     * @return
     */
    String getAddressById(int addressId);

    /**
     * 新增用户收货地址
     * @param coffeeAddress
     * @return
     */
    int insertAddress(CoffeeAddress coffeeAddress);
}
