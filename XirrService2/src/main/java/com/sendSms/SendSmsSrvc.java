package com.sendSms;
import 	java.io.BufferedReader;
import  java.io.InputStream;
import  java.io.InputStreamReader;
import  java.net.HttpURLConnection;
import  java.net.URL;
import  java.net.URLEncoder;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.util.Properties;
import  javax.ws.rs.Consumes;
import  javax.ws.rs.POST;
import  javax.ws.rs.Path;
import  javax.ws.rs.Produces;
import  javax.ws.rs.core.MediaType;

import com.Rest.DataBase.DBConn;
import  com.google.gson.Gson;
import com.ltfs.log.ErrorCodeLog;
import com.ltfs.request.ErrorTokenRes;
import  com.ltfs.utility.FetchURL;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Path("/ToSendSingleMessage/")
public class SendSmsSrvc {
	
@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes("application/json")
public static void getCheckFlag(String payload) throws Exception
	{	
	MessageData messageData =new MessageData();
		
		messageData.setExpires("today");
		messageData.setUrl("http://");
		
		
		System.out.println("aya");
		SMSBody smsBody1= new SMSBody();
		
		smsBody1.setSuccess(messageData);

		Gson gson = new Gson();
		SendSmsBody smsBody=new SendSmsBody();
		smsBody = (SendSmsBody)gson.fromJson( payload, smsBody.getClass());
		
		System.out.println(" sms Body "+smsBody+" sms Body1 "+smsBody1);

		System.out.println(" myvaluefirst Service: "+SendSmsSrvc.getCheckUp(smsBody.getTo(), smsBody));
		System.out.println(" smsgupshup Service: "+SendSmsSrvc.sendOTP("9752165945", smsBody1));

		
		try {
		
		DBConn dBConn = new DBConn();
		PreparedStatement prepareStatement;

		Connection con = dBConn.getDBConnectionForPro();
		prepareStatement = con.prepareStatement(
				"SELECT VALUE FROM TBL_MASCONFIGTTB WHERE SERVICE_NAME=GUPSHUP");
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.getString("VALUE").contains("TRUE")) {
			System.out.println(SendSmsSrvc.getCheckUp(smsBody.getTo(), smsBody));
		}else {
			System.out.println(SendSmsSrvc.sendOTP(smsBody.getTo(), smsBody1));

		}
		
	
	}	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
public static Object getCheckUp(String to,SendSmsBody smsBody){
		
	Gson gson = new Gson();
	//	System.out.println("Payload: "+payload);
		String responseJson = "";
	
		//String username = "sangamltfs";
		//String password = "ltfnce89";
		
// Payload: { "to":"9752165945", "from":"LNTFIN", "text":"DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS 123456", "username":"sangamltfs", "password":"ltfnce89" }
	 
//SmsBody [to=9752165945, from=LNTFIN, text=DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS 123456, username=sangamltfs, password=ltfnce89]

		Properties properties = new Properties();
/*		Gson gson = new Gson();
		SendSmsBody smsBody=new SendSmsBody();
		smsBody = (SendSmsBody)gson.fromJson( payload, smsBody.getClass());
		
		System.out.println(smsBody);
*/		
		  String requestUrl;
		  FetchURL fetchUrl = new FetchURL();
		try {
		/*	 requestUrl = fetchUrl.getSendSmsUrl() + "?username="
			  + URLEncoder.encode(properties.getProperty("user-sms"), "UTF-8") + "&password=" +
			  URLEncoder.encode(properties.getProperty("password-sms"), "UTF-8") + "&to=" +
			  URLEncoder.encode(smsBody.getTo(), "UTF-8") + "&from=" +
			  URLEncoder.encode(smsBody.getFrom(), "UTF-8") + "&messagetype=SMS:TEXT" +
			  "&text=" + URLEncoder.encode(smsBody.getText(), "UTF-8") + "&dlr-mask=19" +
			  "&dlr-url";*/
			 
			// requestUrl="http://www.myvaluefirst.com/smpp/sendsms?username=sangamltfs&password=ltfnce89&to=9752165945&from=LNTFIN&text=DEAR%20CUSTOMER,%20YOUR%20ONE-TIME%20PASSWORD%20FOR%20THE%20APPLICATION%20IS%20123456&dlr-mask=19&dlr-url";
			 
			System.out.println(" ");
			
				requestUrl = fetchUrl.getSendSmsUrl() + "?username="
						  + URLEncoder.encode(smsBody.getUsername(), "UTF-8") + "&password=" +
						  URLEncoder.encode(smsBody.getPassword(), "UTF-8") + "&to=" +
						  URLEncoder.encode(smsBody.getTo(), "UTF-8") + "&from=" +
						  URLEncoder.encode(smsBody.getFrom(), "UTF-8") + "&messagetype=SMS:TEXT" +
						  "&text=" + URLEncoder.encode(smsBody.getText(), "UTF-8") + "&dlr-mask=19" +
						  "&dlr-url";
			 
				System.out.println(" url after "+requestUrl);
			 
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();

			System.out.println(uc.getResponseMessage());
			if(uc.getResponseMessage().equalsIgnoreCase("OK"))
			{
				return "SENT";
			}else {
				return "NOT SENT";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("VeriPAN Error : "+e.getMessage());
			ErrorTokenRes errorTokenRes = new ErrorTokenRes();
			errorTokenRes.setErrorCode("5010");
			errorTokenRes.setErrorDesc("PAN VERIFICATION FAIL");
			responseJson = gson.toJson(errorTokenRes);
			
			return responseJson;
		}

	
	}
		
		
		public static String sendOTP(String mobileNumber, SMSBody data) throws Exception {
			
			
			System.out.println("SMS Body "+data);
			
			
			OkHttpClient client = new OkHttpClient();
			// http://enterprise.smsgupshup.com/GatewayAPI/rest?method=SendMessage&send_to="+mobileNumber+"&msg=Please
			// click on
			// "+data.getSuccess().getUrl()+"&msg_type=TEXT&userid=2000169289&auth_scheme=plain&password=cmtVvQ&v=1.1&format=text
			System.out.println("aya");
			String url = "https://enterprise.smsgupshup.com/GatewayAPI/rest?method=SendMessage&send_to=" + mobileNumber
					+ "&msg=Please click on " + data.getSuccess().getUrl()
					+ "&msg_type=TEXT&userid=2000169289&auth_scheme=plain&password=cmtVvQ&v=1.1&format=text";
			System.out.println(url);
			
			// String url =
			// "http://10.3.3.72:8080/Genie/messageApi?accId=LTFS_BRE&phoneNo="+mobileNumber+"&text=Please
			// click on
			// "+data.getSuccess().getUrl()+"&password=123456&method=single&mask=LNTFIN";
			Request request = new Request.Builder().url(url).get().addHeader("cache-control", "no-cache").build();

			Response response = client.newCall(request).execute();

			/****** Changes for Response Code in EKYC 20 August *******/ 
			
			if(response.code() != 200) {
				ErrorCodeLog.saveResponseCode("perfios",mobileNumber,request.url().toString(),response.code()+"");
			}
			
			/****** Changes for Response Code in EKYC 20 August *******/ 

			
			
			
			InputStream is = response.body().byteStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
			return res.toString();
		}
		
		
		
public static void main(String[] args) throws Exception
		{
			String payload=	"{ \"to\":\"9752165945\", \"from\":\"LNTFIN\", \"text\":\"DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS 123456\", \"username\":\"sangamltfs\", \"password\":\"ltfnce89\" }";
			getCheckFlag(payload);
	}				
			
}	
		
	