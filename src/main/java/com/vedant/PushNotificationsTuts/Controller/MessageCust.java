package com.vedant.PushNotificationsTuts.Controller;

public class MessageCust {
	private String text;
	private String to;
	
	public String getText() {
		return text;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "MessageCust [text=" + text + ", to=" + to + "]";
	}
	
	
}
