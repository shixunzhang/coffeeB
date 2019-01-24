package com.entity;

import java.util.Date;

public class Order {

	private int orderNo;
	private int memberNo;
	private Date orderDate;
	private String settlementWay;
	private String typeId;
	private int amount;
	private int priceTax;
	private int price;
	private int paymentConfirmationDay;
	private Date nextTime;
	private Date lastUpdateDate;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getSettlementWay() {
		return settlementWay;
	}
	public void setSettlementWay(String settlementWay) {
		this.settlementWay = settlementWay;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPriceTax() {
		return priceTax;
	}
	public void setPriceTax(int priceTax) {
		this.priceTax = priceTax;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPaymentConfirmationDay() {
		return paymentConfirmationDay;
	}
	public void setPaymentConfirmationDay(int paymentConfirmationDay) {
		this.paymentConfirmationDay = paymentConfirmationDay;
	}
	public Date getNextTime() {
		return nextTime;
	}
	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


	public String toString() {
		return "Order [orderNo=" + orderNo + ", memberNo=" + memberNo + ", orderDate=" + orderDate + ", settlementWay="
				+ settlementWay + ", typeId=" + typeId + ", amount=" + amount + ", priceTax=" + priceTax + ", price="
				+ price + ", paymentConfirmationDay=" + paymentConfirmationDay + ", nextTime=" + nextTime
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	public Order(int orderNo, int memberNo, Date orderDate, String settlementWay, String typeId, int amount,
			int priceTax, int price, int paymentConfirmationDay, Date nextTime, Date lastUpdateDate) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.orderDate = orderDate;
		this.settlementWay = settlementWay;
		this.typeId = typeId;
		this.amount = amount;
		this.priceTax = priceTax;
		this.price = price;
		this.paymentConfirmationDay = paymentConfirmationDay;
		this.nextTime = nextTime;
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public Order() {
		super();
	
	}
	
	
}
