package com.qc.yuigon.entity;

import java.util.Date;

public class Notify {

	private int memberNo;
	private String notifySbt;
	private int notifyNo;
	private String lastName;
	private String firstName;
	private String lastNameKaNa;
	private String firstNameKaNa;
	private int zipCode;
	private String address;
	private String telHome;
	private String faxHome;
	private String telKeiTai;
	private String email;	
	private String preCardFlg;
	private String preEmailFlg;
	private String willPostFlg;
	private String willEmailFlg;	
	private String secMeMo;
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
	public String getLastNameKaNa() {
		return lastNameKaNa;
	}
	public void setLastNameKaNa(String lastNameKaNa) {
		this.lastNameKaNa = lastNameKaNa;
	}
	public String getFirstNameKaNa() {
		return firstNameKaNa;
	}
	public void setFirstNameKaNa(String firstNameKaNa) {
		this.firstNameKaNa = firstNameKaNa;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelHome() {
		return telHome;
	}
	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}
	public String getFaxHome() {
		return faxHome;
	}
	public void setFaxHome(String faxHome) {
		this.faxHome = faxHome;
	}
	public String getTelKeiTai() {
		return telKeiTai;
	}
	public void setTelKeiTai(String telKeiTai) {
		this.telKeiTai = telKeiTai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreCardFlg() {
		return preCardFlg;
	}
	public void setPreCardFlg(String preCardFlg) {
		this.preCardFlg = preCardFlg;
	}
	public String getPreEmailFlg() {
		return preEmailFlg;
	}
	public void setPreEmailFlg(String preEmailFlg) {
		this.preEmailFlg = preEmailFlg;
	}
	public String getWillPostFlg() {
		return willPostFlg;
	}
	public void setWillPostFlg(String willPostFlg) {
		this.willPostFlg = willPostFlg;
	}
	public String getWillEmailFlg() {
		return willEmailFlg;
	}
	public void setWillEmailFlg(String willEmailFlg) {
		this.willEmailFlg = willEmailFlg;
	}
	public String getSecMeMo() {
		return secMeMo;
	}
	public void setSecMeMo(String secMeMo) {
		this.secMeMo = secMeMo;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public Notify() {
		super();
	}

	public Notify(int memberNo, String notifySbt, int notifyNo, String lastName, String firstName, String lastNameKaNa,
			String firstNameKaNa, int zipCode, String address, String telHome, String faxHome, String telKeiTai,
			String email, String preCardFlg, String preEmailFlg, String willPostFlg, String willEmailFlg,
			String secMeMo, Date lastUpdateDate) {
		super();
		this.memberNo = memberNo;
		this.notifySbt = notifySbt;
		this.notifyNo = notifyNo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.lastNameKaNa = lastNameKaNa;
		this.firstNameKaNa = firstNameKaNa;
		this.zipCode = zipCode;
		this.address = address;
		this.telHome = telHome;
		this.faxHome = faxHome;
		this.telKeiTai = telKeiTai;
		this.email = email;
		this.preCardFlg = preCardFlg;
		this.preEmailFlg = preEmailFlg;
		this.willPostFlg = willPostFlg;
		this.willEmailFlg = willEmailFlg;
		this.secMeMo = secMeMo;
		this.lastUpdateDate = lastUpdateDate;
	}
	@Override
	public String toString() {
		return "Notify [memberNo=" + memberNo + ", notifySbt=" + notifySbt + ", notifyNo=" + notifyNo + ", lastName="
				+ lastName + ", firstName=" + firstName + ", lastNameKaNa=" + lastNameKaNa + ", firstNameKaNa="
				+ firstNameKaNa + ", zipCode=" + zipCode + ", address=" + address + ", telHome=" + telHome
				+ ", faxHome=" + faxHome + ", telKeiTai=" + telKeiTai + ", email=" + email + ", preCardFlg="
				+ preCardFlg + ", preEmailFlg=" + preEmailFlg + ", willPostFlg=" + willPostFlg + ", willEmailFlg="
				+ willEmailFlg + ", secMeMo=" + secMeMo + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
}
