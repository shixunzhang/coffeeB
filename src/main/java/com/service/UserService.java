package com.service;

import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.entity.PhoneDto;

import java.util.List;

public interface UserService {

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

	/**
	 * 手机号 密码登录
	 * @param coffeeUser
	 * @return
	 */
	ServerResponse<CoffeeUser> loginByPhone(CoffeeUser coffeeUser);

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
	 * 更新用户性别信息
	 * @param coffeeUser
	 * @return
	 */
	int changeAddress(CoffeeUser coffeeUser);

	/**
	 * 注册新用户
 	 * @param coffeeUser
	 * @return
	 */
    ServerResponse<CoffeeUser> register(CoffeeUser coffeeUser);

	/**
	 * 验证码登录
	 * @param phoneDto
	 * @return
	 */
	ServerResponse<CoffeeUser> loginByValidate(PhoneDto phoneDto);

	/**
	 * 查找用户列表
	 * @param coffeeUser
	 * @return
	 */
    ServerResponse<List<CoffeeUser>> findUserList(CoffeeUser coffeeUser);
}
