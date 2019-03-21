package com.dao;

import com.entity.CoffeeUser;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	//登录
	User findUserByPhone(String userId);

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
}
