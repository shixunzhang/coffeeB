package com.qc.yuigon.entity;

import java.util.Date;

public class LivingWill {
	
	private int memberNo;
	private String title;
	private String livingWillBody;
	private String sign;
	private Date lastUpdateDate;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLivingWillBody() {
		return livingWillBody;
	}
	public void setLivingWillBody(String livingWillBody) {
		this.livingWillBody = livingWillBody;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


	public String toString() {
		return "LivingWill [memberNo=" + memberNo + ", title=" + title + ", livingWillBody=" + livingWillBody
				+ ", sign=" + sign + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	public LivingWill(int memberNo, String title, String livingWillBody, String sign, Date lastUpdateDate) {
		super();
		this.memberNo = memberNo;
		this.title = title;
		this.livingWillBody = livingWillBody;
		this.sign = sign;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public LivingWill() {
		super();
	}
	
	
	
	

}
