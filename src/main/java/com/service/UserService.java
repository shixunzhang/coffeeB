package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.entity.User;

public interface UserService {
	/**
	 * 账号密码登录
	 * @param userPhone
	 * @param password
	 * @return
	 */
	ServerResponse<User> findUserByPhone(String userId, String password);

	/**
	 * 查询用户信息
	 * @param coffeeUser
	 * @return
	 */
    ServerResponse<CoffeeUser> findUserById(int userId);
}
