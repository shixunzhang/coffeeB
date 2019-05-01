package com.service.impl;

import com.entity.CoffeeAddress;
import com.service.AddressService;
import org.springframework.stereotype.Service;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

    /**
     * 新增收货地址
     * @param coffeeAddress
     * @return
     */
    @Override
    public int addAddress(CoffeeAddress coffeeAddress) {
        return 0;
    }
}
