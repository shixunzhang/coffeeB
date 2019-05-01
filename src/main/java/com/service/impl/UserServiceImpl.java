package com.service.impl;

import com.common.ServerResponse;
import com.dao.AddressDao;
import com.dao.UserDao;
import com.entity.CoffeeAddress;
import com.entity.CoffeeUser;
import com.entity.PhoneDto;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iUserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	private AddressDao addressDao;

//	public ServerResponse<User> findUserByPhone(String userId, String password) {
//		User user = userDao.findUserByPhone(userId);
//		if(user==null){
//			return ServerResponse.createByErrorMessage("用户名不存在");
//		}
//        if (user != null && user.getPassWord().equals(password)) {
//            return ServerResponse.createBySuccess(user);
//        }
//        return ServerResponse.createByErrorMessage("查询失败");
//	}

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

	/**
	 * 更新外卖 自提状态
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public int changeTakeOut(CoffeeUser coffeeUser) {
		int result = userDao.changeTakeOut(coffeeUser);

		return result;
	}

	/**
	 * 手机号 密码登录
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public ServerResponse<CoffeeUser> loginByPhone(CoffeeUser coffeeUser) {
		System.out.println(coffeeUser);
		CoffeeUser userResult = userDao.findUserByPhone(coffeeUser.getUserPhone());
		if(userResult==null){
			return ServerResponse.createByErrorMessage("用户不存在");
		}
		else if (userResult != null && userResult.getUserPassword().equals(coffeeUser.getUserPassword())) {
			return ServerResponse.createBySuccess(userResult);
		}
		else{
			return ServerResponse.createByErrorMessage("账号密码错误");
		}
	}

	/**
	 * 更改用户基本信息
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public int updateUserMsg(CoffeeUser coffeeUser) {
		int result = userDao.updateUserMsg(coffeeUser);
		return result;
	}

	/**
	 * 更新用户性别信息
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public int changeSex(CoffeeUser coffeeUser) {
		int result = userDao.changeSex(coffeeUser);
		return result;
	}


	/**
	 * 注册新用户
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public ServerResponse<CoffeeUser> register(CoffeeUser coffeeUser) {
		CoffeeUser user = userDao.findUserByPhone(coffeeUser.getUserPhone());
		if(user!=null){
			return ServerResponse.createByErrorMessage("用户已存在");
		}else{
			coffeeUser.setUserName("用户");
			coffeeUser.setUserPortrait("/static/images/touxiang/touxiang1.jpg");
			coffeeUser.setUserNick("用户");
//			coffeeUser.setUserAddress(-1);
			System.out.println(coffeeUser);
			int result = userDao.createUser(coffeeUser);
			if(result==1){
				return ServerResponse.createBySuccessMessage("创建新用户成功");
			}else{
				return  ServerResponse.createByErrorMessage("新建用户时发生错误");
			}
		}
	}

	@Override
	public ServerResponse<CoffeeUser> loginByValidate(PhoneDto phoneDto) {
		CoffeeUser userResult = userDao.findUserByPhone(phoneDto.getPhone());
		if(userResult==null){
			return ServerResponse.createByErrorMessage("用户不存在,请先注册");
		}
		else{
			return ServerResponse.createBySuccess(userResult);
		}
	}
}
