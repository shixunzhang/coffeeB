package com.qc.yuigon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qc.yuigon.common.ServerResponse;
import com.qc.yuigon.entity.LastWill;
import com.qc.yuigon.entity.LivingWill;
import com.qc.yuigon.entity.LoginUpdateHistory;
import com.qc.yuigon.entity.Member;
import com.qc.yuigon.service.Yuigon3Service;
import com.qc.yuigon.yuigon3vo.MemberHistory;

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
