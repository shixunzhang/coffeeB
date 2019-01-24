package com.entity;

public class Message {
	
	private String messageNo;
	private String messageBody;
	
	public String getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(String messageNo) {
		this.messageNo = messageNo;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}


	public String toString() {
		return "Message [messageNo=" + messageNo + ", messageBody=" + messageBody + "]";
	}
	
	public Message(String messageNo, String messageBody) {
		super();
		this.messageNo = messageNo;
		this.messageBody = messageBody;
	}
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
