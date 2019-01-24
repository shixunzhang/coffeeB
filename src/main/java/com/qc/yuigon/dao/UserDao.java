package com.qc.yuigon.dao;

import com.qc.yuigon.entity.User;

public interface UserDao {
	//登录
	User findUserByPhone(String userId);
}
