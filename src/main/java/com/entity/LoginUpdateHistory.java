package com.entity;

import java.util.Date;

public class LoginUpdateHistory {
	
	private Date loginUpdateDate;
	private int member;
	private String updateSbt;
	
	
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


	public String toString() {
		return "LoginUpdateHistory [loginUpdateDate=" + loginUpdateDate + ", member=" + member + ", updateSbt="
				+ updateSbt + "]";
	}
	
	public LoginUpdateHistory(Date loginUpdateDate, int member, String updateSbt) {
		super();
		this.loginUpdateDate = loginUpdateDate;
		this.member = member;
		this.updateSbt = updateSbt;
	}
	
	public LoginUpdateHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
