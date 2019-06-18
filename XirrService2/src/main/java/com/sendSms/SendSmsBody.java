package com.sendSms;

public class SendSmsBody {
	
	public String to;
	public String from;
	public	 String text;
	public String username;
	public	 String password;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SmsBody [to=" + to + ", from=" + from + ", text=" + text + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
