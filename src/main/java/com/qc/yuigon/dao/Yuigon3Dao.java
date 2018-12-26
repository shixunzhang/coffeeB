package com.qc.yuigon.dao;

import java.util.List;

import com.qc.yuigon.entity.LastWill;
import com.qc.yuigon.entity.LivingWill;
import com.qc.yuigon.entity.LoginUpdateHistory;
import com.qc.yuigon.entity.Member;
import com.qc.yuigon.yuigon3vo.MemberHistory;


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
