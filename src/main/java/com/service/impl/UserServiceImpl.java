package com.service.impl;

import com.common.ServerResponse;
import com.dao.AddressDao;
import com.dao.UserDao;
import com.entity.CoffeeUser;
import com.entity.PhoneDto;
import com.github.pagehelper.PageHelper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iUserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
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
	 * 设置用户收货地址
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public int changeAddress(CoffeeUser coffeeUser) {
		int result = userDao.changeAddress(coffeeUser);
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

	/**
	 * 用户列表
	 * @param coffeeUser
	 * @return
	 */
	@Override
	public ServerResponse<List<CoffeeUser>> findUserList(CoffeeUser coffeeUser) {

		Integer count = userDao.selectCount(coffeeUser);
		PageHelper.startPage(coffeeUser.getPageNum(),coffeeUser.getPageSize());
		List<CoffeeUser> list = userDao.findUserList(coffeeUser);
		if(list == null){
			return ServerResponse.createByErrorMessage("查询用户列表为空");
		}
		else{
			for (CoffeeUser coffeeUser1 : list) {
				if(coffeeUser1.getUserAddress()==-1){
					coffeeUser1.setAddressString("未设置收货地址");
				}else{
					coffeeUser1.setAddressString(addressDao.getAddressById(coffeeUser1.getUserAddress()));
				}
			}
			return ServerResponse.createBySuccess(count.toString(),list);
		}
	}
}
