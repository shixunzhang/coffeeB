package com.service;

import com.common.ServerResponse;
import com.entity.LastWill;
import com.entity.LivingWill;
import com.entity.LoginUpdateHistory;
import com.entity.Member;
import com.yuigon3vo.MemberHistory;

import java.util.List;

public interface Yuigon3Service {

	ServerResponse<LastWill> findLastWord(int userIDint);

	ServerResponse<LivingWill> findLivingWill(int memberNo);

	ServerResponse<Member> logincheck(int memberNo, String password);

	ServerResponse<List<LoginUpdateHistory>> findHistory(int memberNo);

	ServerResponse<Member> findmemberbyId(int memberNo);

	ServerResponse<List<MemberHistory>> findmembermessage(int memberNo);

}
