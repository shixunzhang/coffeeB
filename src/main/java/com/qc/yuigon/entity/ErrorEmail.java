package com.qc.yuigon.entity;

import java.util.Date;

public class ErrorEmail {

	private Date sendDate;
	private String sendTo;
	private String subject;
	private String memberName;
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String toString() {
		return "ErrorEmail [sendDate=" + sendDate + ", sendTo=" + sendTo + ", subject=" + subject + ", memberName="
				+ memberName + "]";
	}
	
	public ErrorEmail(Date sendDate, String sendTo, String subject, String memberName) {
		super();
		this.sendDate = sendDate;
		this.sendTo = sendTo;
		this.subject = subject;
		this.memberName = memberName;
	}
	
	public ErrorEmail() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
