package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeAddress;

import java.util.List;

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

    /**
     * 查询收货地址列表
     * @param userId
     * @return
     */
    ServerResponse<List<CoffeeAddress>> findAddressList(int userId);

    /**
     * 删除收货地址
     * @param coffeeAddress
     * @return
     */
    int deleteAddress(CoffeeAddress coffeeAddress);

    /**
     * 修改收货地址
     * @param coffeeAddress
     * @return
     */
    int updateAddress(CoffeeAddress coffeeAddress);
}
