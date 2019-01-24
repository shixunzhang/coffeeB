package com.service.impl;

import com.common.ServerResponse;
import com.dao.Yuigon3Dao;
import com.entity.LastWill;
import com.entity.LivingWill;
import com.entity.LoginUpdateHistory;
import com.entity.Member;
import com.service.Yuigon3Service;
import com.yuigon3vo.MemberHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("Yuigon3Service")
public class Yuigon3ServiceImpl implements Yuigon3Service {


	@Autowired
	private Yuigon3Dao yuigon3Dao;
	
	public ServerResponse<LastWill> findLastWord(int memberNo) {
		
		 
		LastWill lastWill = yuigon3Dao.findLastWord(memberNo);
		
		if(lastWill == null){
			return ServerResponse.createByErrorMessage("用户未编写遗言");
		}
		else{
			System.out.println(lastWill.getLastUpdateDate());
			return ServerResponse.createBySuccess(lastWill);
		}
		
		
	}

	public ServerResponse<LivingWill> findLivingWill(int memberNo) {
	
		LivingWill livingWill = yuigon3Dao.findLivingWill(memberNo);
		
		if(livingWill == null){
			return ServerResponse.createByErrorMessage("用户未编写遗言");
		}
		else{
			System.out.println(livingWill.getLastUpdateDate());
			return ServerResponse.createBySuccess(livingWill);
		}
	}




	public ServerResponse<Member> logincheck(int memberNo, String password) {
		Member member = yuigon3Dao.findmemberbyid(memberNo);
		if(member == null){
			 return ServerResponse.createByErrorMessage("用户不存在");
		}
		else if(!member.getPassword().equals(password)){	
			return ServerResponse.createByErrorMessage("密码不正确");
		}
		else{
			int result = yuigon3Dao.inserthistorybyId(memberNo);
			if(result != 1){
				return ServerResponse.createByErrorMessage("系统内出错");
			}else{
			return ServerResponse.createBySuccess(member);
			}
		}
	
		
	}


	public ServerResponse<List<LoginUpdateHistory>> findHistory(int memberNo) {
		List<LoginUpdateHistory> list = yuigon3Dao.findhistory(memberNo);
		if(list == null){
			return ServerResponse.createByErrorMessage("登录信息为空");
		}
		else{	
			return ServerResponse.createBySuccess(list);
		}
	}


	public ServerResponse<Member> findmemberbyId(int memberNo) {
		Member member = yuigon3Dao.findmemberbyid(memberNo);
		if(member == null){
			 return ServerResponse.createByErrorMessage("用户不存在");
		}
		else{	
			return ServerResponse.createBySuccess(member);
		}
	}


	public ServerResponse<List<MemberHistory>> findmembermessage(int memberNo) {
		List<MemberHistory> list = yuigon3Dao.findmembermessage(memberNo);
		if(list == null){
			 return ServerResponse.createByErrorMessage("用户不存在");
		}
		else{	
			return ServerResponse.createBySuccess(list);
		}
	}
	
	
	

}
