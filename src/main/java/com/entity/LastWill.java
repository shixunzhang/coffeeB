package com.entity;

import java.util.Date;

public class LastWill {

	private int memberNo;
	private String title;
	private String willBody;
	private String sign;
	private String upMode;
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
	public String getWillBody() {
		return willBody;
	}
	public void setWillBody(String willBody) {
		this.willBody = willBody;
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
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public LastWill() {
		super();
	}

	public LastWill(int memberNo, String title, String willBody, String sign, String upMode, Date lastUpdateDate) {
		super();
		this.memberNo = memberNo;
		this.title = title;
		this.willBody = willBody;
		this.sign = sign;
		this.upMode = upMode;
		this.lastUpdateDate = lastUpdateDate;
	}
	@Override
	public String toString() {
		return "LastWill [memberNo=" + memberNo + ", title=" + title + ", willBody=" + willBody + ", sign=" + sign
				+ ", upMode=" + upMode + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
}
