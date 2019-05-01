package com.service.impl;

import com.dao.AddressDao;
import com.entity.CoffeeAddress;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressDao addressDao;
    /**
     * 新增收货地址
     * @param coffeeAddress
     * @return
     */
    @Override
    public int addAddress(CoffeeAddress coffeeAddress) {
        int result = addressDao.insertAddress(coffeeAddress);
        return result;
    }

    /**
     * 查询用户的收货地址
     * @param addressId
     * @return
     */
    @Override
    public String getAddressById(int addressId) {
        String address = addressDao.getAddressById(addressId);
        return address;
    }
}
