package com.xirr.XirrController;

public class SMSBody {

	MessageData Success;

	public MessageData getSuccess() {
		return Success;
	}

	public void setSuccess(MessageData success) {
		Success = success;
	}

	@Override
	public String toString() {
		return "SMSBody [Success=" + Success + "]";
	}
	
	
}
