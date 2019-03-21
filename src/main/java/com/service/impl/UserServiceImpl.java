package com.service.impl;

import com.common.ServerResponse;
import com.dao.UserDao;
import com.entity.CoffeeUser;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements UserService {
	
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

	/**
	 * 查询详细信息
	 * @param userId
	 * @return
	 */
	@Override
	public ServerResponse<CoffeeUser> findUserById(int userId) {
		CoffeeUser coffeeUser = userDao.findUserById(userId);

		if(coffeeUser==null){
			return ServerResponse.createByErrorMessage("用户不存在");
		}
		else{
			return ServerResponse.createBySuccess(coffeeUser);
		}

	}


	/**
	 * 更换头像
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public int changeAvatar(CoffeeUser coffeeUser) {
		int result =userDao.changeAvatar(coffeeUser);

		return result;
	}


}
