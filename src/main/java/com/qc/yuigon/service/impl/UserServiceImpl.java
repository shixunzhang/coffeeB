package com.qc.yuigon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qc.yuigon.common.ServerResponse;
import com.qc.yuigon.dao.UserDao;
import com.qc.yuigon.entity.User;
import com.qc.yuigon.service.UserService;

@Service("iUserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public ServerResponse<User> findUserByPhone(String userId, String password) {
		User user = userDao.findUserByPhone(userId);
		if(user==null){
			return ServerResponse.createByErrorMessage("用户名不存在");
		}
        if (user != null && user.getPassWord().equals(password)) {
            return ServerResponse.createBySuccess(user);
        }

        return ServerResponse.createByErrorMessage("查询失败");
	}

}
