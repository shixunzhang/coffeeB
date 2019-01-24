package com.qc.yuigon.entity;

import java.util.Date;

public class SinpleMessage {
	
	private int memberNo;
	private String notifySbt;
	private int notifyNo;
	private String title;
	private String messageBody;
	private String sign;
	private String upMode;
	private String secMemo;
	private Date lastUpdateDate;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getNotifySbt() {
		return notifySbt;
	}
	public void setNotifySbt(String notifySbt) {
		this.notifySbt = notifySbt;
	}
	public int getNotifyNo() {
		return notifyNo;
	}
	public void setNotifyNo(int notifyNo) {
		this.notifyNo = notifyNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getUpMode() {
		return upMode;
	}
	public void setUpMode(String upMode) {
		this.upMode = upMode;
	}
	public String getSecMemo() {
		return secMemo;
	}
	public void setSecMemo(String secMemo) {
		this.secMemo = secMemo;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


	public String toString() {
		return "SinpleMessage [memberNo=" + memberNo + ", notifySbt=" + notifySbt + ", notifyNo=" + notifyNo
				+ ", title=" + title + ", messageBody=" + messageBody + ", sign=" + sign + ", upMode=" + upMode
				+ ", secMemo=" + secMemo + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	public SinpleMessage(int memberNo, String notifySbt, int notifyNo, String title, String messageBody, String sign,
			String upMode, String secMemo, Date lastUpdateDate) {
		super();
		this.memberNo = memberNo;
		this.notifySbt = notifySbt;
		this.notifyNo = notifyNo;
		this.title = title;
		this.messageBody = messageBody;
		this.sign = sign;
		this.upMode = upMode;
		this.secMemo = secMemo;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public SinpleMessage() {
		super();
	
	}
	
	
	
	

}
