package com.qc.yuigon.service;

import java.util.List;

import com.qc.yuigon.common.ServerResponse;
import com.qc.yuigon.entity.LastWill;
import com.qc.yuigon.entity.LivingWill;
import com.qc.yuigon.entity.LoginUpdateHistory;
import com.qc.yuigon.entity.Member;
import com.qc.yuigon.yuigon3vo.MemberHistory;

public interface Yuigon3Service {

	ServerResponse<LastWill> findLastWord(int userIDint);

	ServerResponse<LivingWill> findLivingWill(int memberNo);

	ServerResponse<Member> logincheck(int memberNo,String password);

	ServerResponse<List<LoginUpdateHistory>> findHistory(int memberNo);

	ServerResponse<Member> findmemberbyId(int memberNo);

	ServerResponse<List<MemberHistory>> findmembermessage(int memberNo);

}
