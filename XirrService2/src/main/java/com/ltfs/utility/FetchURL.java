package com.ltfs.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.ltfs.log.PerfiosLogger;

public class FetchURL {

	public String getUrl(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("baseurl")+prop.getProperty(contentType);			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	
	
	public String getChangedUrl(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("baseurl3")+prop.getProperty(contentType);			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	
	public String getUrlVerfiyPAN(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("baseUrlVerfiyPAN")+prop.getProperty(contentType);			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	public String getUrlDMSDownloadDoc(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("baseurlDMSDownloadDoc")+prop.getProperty(contentType);			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	public String getUrl2(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("baseurl2")+prop.getProperty(contentType);			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	public String getCCAvenueUrl()
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("ccavenueUrl");			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	
	
	public String getUrlekyc(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));
			
			 url=prop.getProperty("baseUrlEkyc")+prop.getProperty(contentType);
			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
		}
		return url;
		}
	
	
	
	public String getUrlekycOTP(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));
			
			 url=prop.getProperty("baseUrlEkyc")+prop.getProperty(contentType);
			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
		}
		return url;
		}
	
	
	
	
	public String getverifiedOTP(String contentType)
	
	{
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));
			
			 url=prop.getProperty("baseUrlEkyc")+prop.getProperty(contentType);
			 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
		}
		return url;
		}


	public String getCallbackUrl() {
		
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("callBackUrlPublicIP");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
	public String getIDENUrl() {

		String url = "";
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));
			url = prop.getProperty("IDENUrl");
		} catch (Exception e) {
			PerfiosLogger.error(e.getMessage(), e);

		}
		return url;
	}


	public String getSendSmsUrl() {
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("SendSmsUrl");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}

	public String getUserName() {
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("user-sms");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	public String getUserPassword() {
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("password-sms");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	public String getUserText() {
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("text");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	public String getFrom() {
		String url="";
		Properties prop=new Properties();
		try
		{
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));			
			 url=prop.getProperty("from");		 
		}
		catch(Exception e)
		{
			PerfiosLogger.error(e.getMessage(), e);
			
		}
		return url;
	}
	
}
