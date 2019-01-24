package com.entity;

public class Type {

	private String typeId;
	private int listNo;
	private String typeName;
	private String typeDescription;
	private int price;
	private int tax;
	private int period;
	private String abolitionFlg;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public int getListNo() {
		return listNo;
	}
	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getAbolitionFlg() {
		return abolitionFlg;
	}
	public void setAbolitionFlg(String abolitionFlg) {
		this.abolitionFlg = abolitionFlg;
	}
	/**
	 * 
	 */
	public Type() {
		super();
	}

	public Type(String typeId, int listNo, String typeName, String typeDescription, int price, int tax, int period,
			String abolitionFlg) {
		super();
		this.typeId = typeId;
		this.listNo = listNo;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
		this.price = price;
		this.tax = tax;
		this.period = period;
		this.abolitionFlg = abolitionFlg;
	}
	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", listNo=" + listNo + ", typeName=" + typeName + ", typeDescription="
				+ typeDescription + ", price=" + price + ", tax=" + tax + ", period=" + period + ", abolitionFlg="
				+ abolitionFlg + "]";
	}
	
	
}
