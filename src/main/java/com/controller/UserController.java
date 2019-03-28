package com.controller;


import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired  
	private UserService userService;
		
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public ServerResponse<User> login(@RequestBody User user) {
		System.out.println(user.getUserId());
		System.out.println(user.getPassWord());
		ServerResponse<User> result=userService.findUserByPhone(user.getUserId(),user.getPassWord());
		
		if(result != null){
			return result;
		}
		else{
			return ServerResponse.createByErrorMessage("查询失败");
		}			
	}

	/**
	 * 查询用户详细信息
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/detail.do",method = RequestMethod.POST)
	public ServerResponse<CoffeeUser> detail(@RequestBody CoffeeUser coffeeUser) {

		ServerResponse<CoffeeUser> result=userService.findUserById(coffeeUser.getUserId());

		if(result != null){
			return result;
		}
		else{
			return ServerResponse.createByErrorMessage("查询用户信息失败");
		}
	}


	/**
	 * 更改用户头像
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/change-avatar.do",method = RequestMethod.POST)
	public ServerResponse<Integer> changeAvatar(@RequestBody CoffeeUser coffeeUser) {
		int result = userService.changeAvatar(coffeeUser);
		if(result==1){
			return ServerResponse.createBySuccessMessage("更换头像成功");
		}
		else{
			return ServerResponse.createByErrorMessage("更换头像失败");
		}
	}

	/**
	 * 更换外卖、自提状态
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/change-take-out.do",method = RequestMethod.POST)
	public ServerResponse<Integer> changeTakeOut(@RequestBody CoffeeUser coffeeUser) {
		int result = userService.changeTakeOut(coffeeUser);
		if(result==1){
			return ServerResponse.createBySuccessMessage("更换状态成功");
		}
		else{
			return ServerResponse.createByErrorMessage("更换状态失败");
		}
	}

}
