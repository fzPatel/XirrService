package com.GetBank.Bean;
public class Data
{
    private String bankId;

    private String bankName;

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Data [bankId=" + bankId + ", bankName=" + bankName + "]";
	}

}