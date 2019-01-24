package com.dao;

import com.entity.User;

public interface UserDao {
	//登录
	User findUserByPhone(String userId);
}
