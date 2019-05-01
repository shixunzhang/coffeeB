package com.controller;


import com.common.ServerResponse;
import com.entity.CoffeeUser;
import com.service.UserService;
import javafx.scene.paint.PhongMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired  
	private UserService userService;

	/**
	 * 用户手机号、密码登录
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public ServerResponse<CoffeeUser> login(@RequestBody CoffeeUser coffeeUser) {
		ServerResponse<CoffeeUser> result=userService.loginByPhone(coffeeUser);
		if(result != null){
			return result;
		}
		else{
			return ServerResponse.createByErrorMessage("登录失败");
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

	/**
	 * 更改用户基本信息
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/updateUserMsg.do",method = RequestMethod.POST)
	public ServerResponse<CoffeeUser> updateUserMsg(@RequestBody CoffeeUser coffeeUser) {
		int result= userService.updateUserMsg(coffeeUser);
		if(result==1){
			return ServerResponse.createBySuccessMessage("更新成功");
		}
		else{
			return ServerResponse.createByErrorMessage("更新失败");
		}
	}

	/**
	 * 更新用户性别
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/change-sex.do",method = RequestMethod.POST)
	public ServerResponse<Integer> changeSex(@RequestBody CoffeeUser coffeeUser) {
		int result = userService.changeSex(coffeeUser);
		if(result==1){
			return ServerResponse.createBySuccessMessage("更新性别成功");
		}
		else{
			return ServerResponse.createByErrorMessage("更新性别失败");
		}
	}

	/**
	 * 注册新用户
	 * @param coffeeUser
	 * @return
	 */
	@RequestMapping(value = "/register.do",method = RequestMethod.POST)
	public ServerResponse<CoffeeUser> register(@RequestBody CoffeeUser coffeeUser) {
		ServerResponse<CoffeeUser> result = userService.register(coffeeUser);
		if(result!=null){
		    return result;
		}
		else{
			return ServerResponse.createByErrorMessage("注册用户失败");
		}
	}




}
