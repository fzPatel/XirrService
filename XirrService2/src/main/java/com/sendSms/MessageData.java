package com.sendSms;

public class MessageData {

	private String expires;
	private String url;
	
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "MessageData [expires=" + expires + ", url=" + url + "]";
	}
	
}
