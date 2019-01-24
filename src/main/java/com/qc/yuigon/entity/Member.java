package com.qc.yuigon.entity;

import java.util.Date;

public class Member {
	
	private int memberNo;
	private String loginId;
	private String password;
	private String lastName;
	private String firstName;
	private String lastNameKaNa;
	private String firstNameKaNa;
	private Date birthday;
	private int zipCode;
	private String address;
	private String telHome;
	private String faxHome;
	private String telKeiTai;
	private String email1;
	private String email2;
	private Date admissionDate;
	private Date lapseDate;
	private String memberStatus;
	private Date deathDay;
	private String secMeMo;
	private Date cancelDate;
	private Date lastUpdateDate;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getLapseDate() {
		return lapseDate;
	}
	public void setLapseDate(Date lapseDate) {
		this.lapseDate = lapseDate;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Date getDeathDay() {
		return deathDay;
	}
	public void setDeathDay(Date deathDay) {
		this.deathDay = deathDay;
	}
	public String getSecMeMo() {
		return secMeMo;
	}
	public void setSecMeMo(String secMeMo) {
		this.secMeMo = secMeMo;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public Member() {
		super();
	}
	
	public Member(int memberNo, String loginId, String password, String lastName, String firstName, String lastNameKaNa,
			String firstNameKaNa, Date birthday, int zipCode, String address, String telHome, String faxHome,
			String telKeiTai, String email1, String email2, Date admissionDate, Date lapseDate, String memberStatus,
			Date deathDay, String secMeMo, Date cancelDate, Date lastUpdateDate) {
		super();
		this.memberNo = memberNo;
		this.loginId = loginId;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.lastNameKaNa = lastNameKaNa;
		this.firstNameKaNa = firstNameKaNa;
		this.birthday = birthday;
		this.zipCode = zipCode;
		this.address = address;
		this.telHome = telHome;
		this.faxHome = faxHome;
		this.telKeiTai = telKeiTai;
		this.email1 = email1;
		this.email2 = email2;
		this.admissionDate = admissionDate;
		this.lapseDate = lapseDate;
		this.memberStatus = memberStatus;
		this.deathDay = deathDay;
		this.secMeMo = secMeMo;
		this.cancelDate = cancelDate;
		this.lastUpdateDate = lastUpdateDate;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", loginId=" + loginId + ", password=" + password + ", lastName="
				+ lastName + ", firstName=" + firstName + ", lastNameKaNa=" + lastNameKaNa + ", firstNameKaNa="
				+ firstNameKaNa + ", birthday=" + birthday + ", zipCode=" + zipCode + ", address=" + address
				+ ", telHome=" + telHome + ", faxHome=" + faxHome + ", telKeiTai=" + telKeiTai + ", email1=" + email1
				+ ", email2=" + email2 + ", admissionDate=" + admissionDate + ", lapseDate=" + lapseDate
				+ ", memberStatus=" + memberStatus + ", deathDay=" + deathDay + ", secMeMo=" + secMeMo + ", cancelDate="
				+ cancelDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	
}
