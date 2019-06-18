package com.GetBank.Bean;

import java.util.ArrayList;

public class GetBankImpl
{
	public ArrayList<Data> takeData() 
	{
		ArrayList<Data> data = new ArrayList<Data>();
		Data dataObj=new Data();
		dataObj.setBankId("101");
		dataObj.setBankName("ICICI");

		Data dataObj2=new Data();
		dataObj2.setBankId("102");
		dataObj2.setBankName("HDFC");
		data.add(dataObj);
		data.add(dataObj2);
		return data;
		}
	
	
	
public DataAr getData() 
	{
		ArrayList<Data> data = new ArrayList<Data>();
		Data dataObj=new Data();
		DataAr dataAr=new DataAr();
		dataObj.setBankId("101");
		dataObj.setBankName("ICICI");

		Data dataObj2=new Data();
		dataObj2.setBankId("102");
		dataObj2.setBankName("HDFC");
		data.add(dataObj);
		data.add(dataObj2);
		dataAr.setData(data);
		
		return dataAr;
		}
}
