package com.entity;

public class SystemConfig {
	
	private int tax;
	private String bankAccount;
	private String willTextFile;
	private String willHtmlFile;
	private String smHtmlFile;
	private String lwTextFile;
	private String lwHtmlFile;
	private String secEmail;
	
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getWillTextFile() {
		return willTextFile;
	}
	public void setWillTextFile(String willTextFile) {
		this.willTextFile = willTextFile;
	}
	public String getWillHtmlFile() {
		return willHtmlFile;
	}
	public void setWillHtmlFile(String willHtmlFile) {
		this.willHtmlFile = willHtmlFile;
	}
	public String getSmHtmlFile() {
		return smHtmlFile;
	}
	public void setSmHtmlFile(String smHtmlFile) {
		this.smHtmlFile = smHtmlFile;
	}
	public String getLwTextFile() {
		return lwTextFile;
	}
	public void setLwTextFile(String lwTextFile) {
		this.lwTextFile = lwTextFile;
	}
	public String getLwHtmlFile() {
		return lwHtmlFile;
	}
	public void setLwHtmlFile(String lwHtmlFile) {
		this.lwHtmlFile = lwHtmlFile;
	}
	public String getSecEmail() {
		return secEmail;
	}
	public void setSecEmail(String secEmail) {
		this.secEmail = secEmail;
	}


	public String toString() {
		return "SystemConfig [tax=" + tax + ", bankAccount=" + bankAccount + ", willTextFile=" + willTextFile
				+ ", willHtmlFile=" + willHtmlFile + ", smHtmlFile=" + smHtmlFile + ", lwTextFile=" + lwTextFile
				+ ", lwHtmlFile=" + lwHtmlFile + ", secEmail=" + secEmail + "]";
	}
	
	public SystemConfig(int tax, String bankAccount, String willTextFile, String willHtmlFile, String smHtmlFile,
			String lwTextFile, String lwHtmlFile, String secEmail) {
		super();
		this.tax = tax;
		this.bankAccount = bankAccount;
		this.willTextFile = willTextFile;
		this.willHtmlFile = willHtmlFile;
		this.smHtmlFile = smHtmlFile;
		this.lwTextFile = lwTextFile;
		this.lwHtmlFile = lwHtmlFile;
		this.secEmail = secEmail;
	}
	
	public SystemConfig() {
		super();
	}
	
	
	

}
