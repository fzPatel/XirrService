package com.xirr.XirrController;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class XirrData 
{

String[] dates;
double[] payments;


public String[] getDates() {
	return dates;
}
public void setDates(String[] dates) {
	this.dates = dates;
}
public double[] getPayments() {
	return payments;
}
public void setPayments(double[] payments) {
	this.payments = payments;
}
	


	
}
