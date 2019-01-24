package com.qc.yuigon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qc.yuigon.common.ServerResponse;
import com.qc.yuigon.entity.User;
import com.qc.yuigon.service.UserService;


@RestController
@CrossOrigin
public class UserController {
	
	@Autowired  
	private UserService iUserService;
		
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public ServerResponse<User> login(@RequestBody User user) {
		System.out.println(user.getUserId());
		System.out.println(user.getPassWord());
		ServerResponse<User> result=iUserService.findUserByPhone(user.getUserId(),user.getPassWord());
		
		if(result != null){
			return result;
		}
		else{
			return ServerResponse.createByErrorMessage("查询失败");
		}			
	}
}
