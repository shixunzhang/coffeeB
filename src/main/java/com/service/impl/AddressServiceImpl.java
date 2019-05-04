package com.service.impl;

import com.common.ServerResponse;
import com.dao.AddressDao;
import com.entity.CoffeeAddress;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        System.out.println(coffeeAddress.getAddressId());
        if(coffeeAddress.getAddressId()>0){
            return coffeeAddress.getAddressId();
        }else{
            return result;
        }
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

    /**
     * 查询用户的收货地址
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<List<CoffeeAddress>> findAddressList(int userId) {
        List<CoffeeAddress> list = addressDao.findAddressList(userId);

        if(list == null){
            return ServerResponse.createByErrorMessage("查询收货地址列表为空");
        }
        else{
            return ServerResponse.createBySuccess(list);
        }
    }

    /**
     * 删除收货地址
      * @param coffeeAddress
     * @return
     */
    @Override
    public int deleteAddress(CoffeeAddress coffeeAddress) {
        int result = addressDao.deleteAddress(coffeeAddress.getAddressId());
        return result;
    }

    /**
     * 修改收货地址
     * @param coffeeAddress
     * @return
     */
    @Override
    public int updateAddress(CoffeeAddress coffeeAddress) {
        int result = addressDao.updateAddress(coffeeAddress);
        return result;
    }

}
