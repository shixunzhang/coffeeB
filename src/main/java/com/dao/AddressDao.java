package com.dao;

import com.entity.CoffeeAddress;

import java.util.List;

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

    /**
     * 查询收货地址列表
     * @param userId
     * @return
     */
    List<CoffeeAddress> findAddressList(int userId);

    /**
     * 删除收货地址
     * @param addressId
     * @return
     */
    int deleteAddress(int addressId);

    /**
     * 修改收货地址
     * @param coffeeAddress
     * @return
     */
    int updateAddress(CoffeeAddress coffeeAddress);
}
