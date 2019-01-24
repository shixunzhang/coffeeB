package com.qc.yuigon.service;

import com.qc.yuigon.common.ServerResponse;
import com.qc.yuigon.entity.User;

public interface UserService {
	/**
	 * 账号密码登录
	 * @param userPhone
	 * @param password
	 * @return
	 */
	ServerResponse<User> findUserByPhone(String userId,String password);
}
