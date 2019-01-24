package com.controller;


import com.common.ServerResponse;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
