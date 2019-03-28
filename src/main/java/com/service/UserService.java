package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.entity.User;

public interface UserService {
	/**
	 * 账号密码登录
	 * @param userId
	 * @param password
	 * @return
	 */
	ServerResponse<User> findUserByPhone(String userId, String password);

	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
    ServerResponse<CoffeeUser> findUserById(int userId);

	/**
	 * 更换头像
	 * @param coffeeUser
	 * @return
	 */
	int changeAvatar(CoffeeUser coffeeUser);

	/**
	 * 更换外卖、自提状态
	 * @param coffeeUser
	 * @return
	 */
    int changeTakeOut(CoffeeUser coffeeUser);
}
