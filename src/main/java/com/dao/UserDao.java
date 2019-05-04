package com.dao;

import com.entity.CoffeeUser;

public interface UserDao {


	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
    CoffeeUser findUserById(int userId);

	/**
	 * 更换头像
	 * @param coffeeUser
	 * @return
	 */
	int changeAvatar(CoffeeUser coffeeUser);

	/**
	 * 更新外卖、自提状态
	 * @param coffeeUser
	 * @return
	 */
    int changeTakeOut(CoffeeUser coffeeUser);

	/**
	 * 根据手机号码查询用户信息
	 * @param userPhone
	 * @return
	 */
	CoffeeUser findUserByPhone(String userPhone);

	/**
	 * 更改用户基本信息
	 * @param coffeeUser
	 * @return
	 */
	int updateUserMsg(CoffeeUser coffeeUser);

	/**
	 * 更新用户性别信息
	 * @param coffeeUser
	 * @return
	 */
	int changeSex(CoffeeUser coffeeUser);

    /**
     * 创建新用户
     * @param coffeeUser
     * @return
     */
    int createUser(CoffeeUser coffeeUser);

	/**
	 * 修改用户收货地址
	 * @param coffeeUser
	 * @return
	 */
	int changeAddress(CoffeeUser coffeeUser);
}
