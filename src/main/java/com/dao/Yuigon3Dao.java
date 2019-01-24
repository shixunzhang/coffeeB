package com.dao;

import com.entity.LastWill;
import com.entity.LivingWill;
import com.entity.LoginUpdateHistory;
import com.entity.Member;
import com.yuigon3vo.MemberHistory;

import java.util.List;


public interface Yuigon3Dao {
	
	/**
	 * 
	 * @param userIDint
	 * @return lastword
	 */
	LastWill findLastWord(int memberNo);

	LivingWill findLivingWill(int memberNo);

	Member findmemberbyid(int memberNo);

	List<LoginUpdateHistory> findhistory(int memberNo);

	List<MemberHistory> findmembermessage(int memberNo);

	int inserthistorybyId(int memberNo);

}
