package com.yuigon3vo;

import java.util.Date;

public class MemberHistory {
	
	private int memberNo;
	private String loginId;
	private String password;
	private String lastName;
	private String firstName;
	private Date loginUpdateDate;
	private int member;
	private String updateSbt;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getLoginUpdateDate() {
		return loginUpdateDate;
	}
	public void setLoginUpdateDate(Date loginUpdateDate) {
		this.loginUpdateDate = loginUpdateDate;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public String getUpdateSbt() {
		return updateSbt;
	}
	public void setUpdateSbt(String updateSbt) {
		this.updateSbt = updateSbt;
	}
	public MemberHistory(int memberNo, String loginId, String password, String lastName, String firstName,
			Date loginUpdateDate, int member, String updateSbt) {
		super();
		this.memberNo = memberNo;
		this.loginId = loginId;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.loginUpdateDate = loginUpdateDate;
		this.member = member;
		this.updateSbt = updateSbt;
	}
	public MemberHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "memberhistory [memberNo=" + memberNo + ", loginId=" + loginId + ", password=" + password + ", lastName="
				+ lastName + ", firstName=" + firstName + ", loginUpdateDate=" + loginUpdateDate + ", member=" + member
				+ ", updateSbt=" + updateSbt + "]";
	}
	
	
	

}
