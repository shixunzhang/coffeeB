package com.controller;

import com.common.ServerResponse;
import com.entity.LastWill;
import com.entity.LivingWill;
import com.entity.LoginUpdateHistory;
import com.entity.Member;
import com.service.Yuigon3Service;
import com.yuigon3vo.MemberHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class yuigon3controller {
	
	@Autowired
	private Yuigon3Service yuigon3Service;
	
	@RequestMapping(value="/printlastword.do" , method = RequestMethod.POST)
	public ServerResponse<LastWill> printlastword(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 

			ServerResponse<LastWill> result = yuigon3Service.findLastWord(memberNo);
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("查询失败");
			}	
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	
	@RequestMapping(value="/printlivingwill.do" , method = RequestMethod.POST)
	public ServerResponse<LivingWill> printlivingwill(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 

			ServerResponse<LivingWill> result = yuigon3Service.findLivingWill(memberNo);
		
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("查询失败");
			}	
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	@RequestMapping(value="/memberlogin.do" , method = RequestMethod.POST)
	public ServerResponse<Member> memberlogin(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 
			ServerResponse<Member> result = yuigon3Service.logincheck(memberNo,member.getPassword());
		
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("没有记录");
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	
	@RequestMapping(value="/findhistory.do" , method = RequestMethod.POST)
	public ServerResponse<List<LoginUpdateHistory>> findhistory(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 
			System.out.println(memberNo);
			ServerResponse<List<LoginUpdateHistory>> result = yuigon3Service.findHistory(memberNo);
		
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("没有记录");
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	@RequestMapping(value="/findmember.do" , method = RequestMethod.POST)
	public ServerResponse<Member> findmember(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 
			ServerResponse<Member> result = yuigon3Service.findmemberbyId(memberNo);
		
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("没有记录");
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	@RequestMapping(value="/findmembermessage.do" , method = RequestMethod.POST)
	public ServerResponse<List<MemberHistory>> findmembermessage(@RequestBody Member member) {
		try{
			
			int memberNo = Integer.valueOf(member.getMemberNo()); 
			ServerResponse<List<MemberHistory>> result = yuigon3Service.findmembermessage(memberNo);
		
			if(result != null){
				return result;
			}
			else{
				return ServerResponse.createByErrorMessage("没有记录");
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败(TRY)");
		}	
	}
	
	
	
	
	

}
