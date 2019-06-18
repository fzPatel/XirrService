package com.xirr.XirrController;
import com.sendSms.*;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GetBank.Bean.Data;
import com.GetBank.Bean.DataAr;
import com.GetBank.Bean.GetBankImpl;
import com.MlMaster.Bean.CasteDataAr;
import com.MlMaster.Bean.GenderData;
import com.MlMaster.Bean.GenderDataAr;
import com.MlMaster.Bean.HrmsvotrationDataAr;
import com.MlMaster.Bean.LdGridAr;
import com.MlMaster.Bean.LoanDataAr;
import com.MlMaster.Bean.MaritalDataAr;
import com.MlMaster.Bean.McmodeData;
import com.MlMaster.Bean.McmodeDataAr;
import com.MlMaster.Bean.MotherTongueDataAr;
import com.MlMaster.Bean.ReligionDataAr;
import com.MlMaster.Bean.StateKycDataAr;
import com.MlMaster.Bean.TradeDataAr;
import com.MlMaster.Dao.MlMasterDao;
import com.MlMaster.DaoImp.MlMasterDaoImpl;
import com.Rest.DataBase.DBConn;
import com.google.gson.Gson;
import com.ltfs.log.ErrorCodeLog;
import com.ltfs.request.ErrorTokenRes;
import com.ltfs.utility.FetchURL;
import com.xirr.XirrController.*;

import net.minidev.json.JSONObject;
@RestController
public class MyfirstService 
{		
private MlMasterDaoImpl ml=new MlMasterDaoImpl();

	/*
	  @Path("/Ml_Master")
	  @RestController public class MyfirstService { private MlMasterDaoImpl ml=new
	  MlMasterDaoImpl();
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public String genderData(@QueryParam("master") String master) {  
	 */

@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(value = "/MlMasters", method = RequestMethod.GET)
public String genderData(@RequestParam("master")String master ,HttpServletRequest request)  
{
	System.out.println(" Inside API");
	String response="";
	Gson gson= new Gson();
	try {	

	if(master!=null&&master.equalsIgnoreCase("genderMstr")) {
		System.out.println(" inside genderMstr");
		GenderDataAr gd=new GenderDataAr();
		gd=ml.getGenderData();
		
	 response=gson.toJson(gd);

	}
	
	else if(master!=null&&master.equalsIgnoreCase("loanDetailGrid")) {
		System.out.println(" inside loanDetailGrid");
		LdGridAr gd=new LdGridAr();
		gd=ml.loanDetailGrid();
	 response=gson.toJson(gd);
	}else if(master!=null&&master.equalsIgnoreCase("maritalMstr")) {
	
			System.out.println("inside maritalMstr");
			MaritalDataAr gd=new MaritalDataAr();
			gd=ml.getMaritalData();

			response=gson.toJson(gd);
		 }
	else if(master!=null&&master.equalsIgnoreCase("religionMstr")) {
		
		System.out.println(" inside religionMstr");
		ReligionDataAr gd=new ReligionDataAr();
		gd=ml.religionData();
		response=gson.toJson(gd);
	 }
	else if(master!=null&&master.equalsIgnoreCase("stateEkyc")) {
		
		System.out.println(" inside stateEkyc");
		StateKycDataAr gd=new StateKycDataAr();
		gd=ml.stateKycData();
		response=gson.toJson(gd);
	 }
	else if(master!=null&&master.equalsIgnoreCase("tradeMstr")) {
		System.out.println(" inside stateEkyc");
		TradeDataAr gd=new TradeDataAr();
		gd=ml.tradeData();
		response=gson.toJson(gd);
	 }
	else if(master!=null&&master.equalsIgnoreCase("motherTongueMstr")) {
		
		System.out.println(" inside motherTongueMstr");
		MotherTongueDataAr gd=new MotherTongueDataAr();
		gd=ml.motherTongueDataAr();

		response=gson.toJson(gd);
	 }
	else if(master!=null&&master.equalsIgnoreCase("loanMstr")) {
		
		System.out.println(" inside loanMstr");
		LoanDataAr gd=new LoanDataAr();
		gd=ml.loanDataAr();

		response=gson.toJson(gd);
	 }
	else if(master!=null&&master.equalsIgnoreCase("casteMstr")) {
		
		System.out.println(" inside CasteData");
		CasteDataAr gd=new CasteDataAr();
		gd=ml.casteData();
		response=gson.toJson(gd);
	 }
		
	else if(master!=null&&master.equalsIgnoreCase("hrmsVoterRationMstr")) {

	System.out.println(" inside hrmsvotrationData");
	HrmsvotrationDataAr gd=new HrmsvotrationDataAr();
	gd=ml.hrmsvotrationData();
	response=gson.toJson(gd);
	}
	else if(master!=null&&master.equalsIgnoreCase("hrmsmcModeMstr")) 
	{
		System.out.println(" inside hrmsvotrationData");
		McmodeDataAr gd=new McmodeDataAr();
		ArrayList<McmodeData> mtda = new ArrayList<McmodeData>();

		McmodeData skd=new McmodeData();
		skd.setMccode("101");
		skd.setMode("High");
		
		mtda.add(skd);
		
		gd.setMcmodeData(mtda);

		
		//gd=ml.mcmodeData();
		
		response=gson.toJson(gd);
		
		
	}
	}
	catch (Exception e) {
			System.out.println(e.getMessage());
	e.printStackTrace();
	}
return response;	
}





//--------------------------------------------------------
@GET
@Path("/GetMasters")
@Produces(MediaType.APPLICATION_JSON)
//@RequestMapping(value = "/GetMaster", method = RequestMethod.GET)
public String getMaster(HttpServletRequest request)
{
	System.out.println(" inside GetMaster");
Gson gson= new Gson();
ArrayList<Data> mtd = new ArrayList<Data>();
DataAr mtda=new DataAr();
	try 
	{
	GetBankImpl getBankImpl=new GetBankImpl();
		mtda=getBankImpl.getData();			
		mtda.setData(mtd);
		
	}catch (Exception e) {
			e.printStackTrace();
}
	
	return gson.toJson(mtda);
}



//-----------------------------------------------------


/*

@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(value = "/GetBank", method = RequestMethod.GET)
public ResponseEntity<JSONObject> GetBank(HttpServletRequest request) 
{
JSONObject jsonObject = new JSONObject();
System.out.println(" inside GetMaster");
ArrayList<Data> data = new ArrayList<Data>();
GetBankImpl getBankImpl=new GetBankImpl();
data=getBankImpl.takeData();
jsonObject.put("data", data);
//return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.NO_CONTENT);
return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.CREATED);
}



/*


@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(value = "/GetBankMaster", method = RequestMethod.GET)
public ResponseEntity<JSONObject> GetBankMaster(@RequestParam("master")String master ,HttpServletRequest request) 
{
JSONObject jsonObject = new JSONObject();
System.out.println(" inside GetBankMaster");

if(master!=null&&master.equalsIgnoreCase("genderMstr")) 
{
	
ArrayList<Data> mtd = new ArrayList<Data>();

DataAr mtda=new DataAr();

Data data1=new Data();
data1.setBankId("ICICI");
data1.setBankName("ICICI");

Data data2=new Data();
data2.setBankId("HDFC");
data2.setBankName("HDFCfghjk");

mtd.add(data1);
mtd.add(data2);

jsonObject.put("data", mtd);

}else if(master!=null&&master.equalsIgnoreCase("abc")){
	
	System.out.println(" inside genderMstr");
	ArrayList<GenderData> mtd = new ArrayList<GenderData>();
	mtd=ml.takeData();
	jsonObject.put("genderData", mtd);

}

return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.CREATED);
}


















@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(method=RequestMethod.GET,value="/check1")
public String postMessage() throws Exception{

		
	return "";
}
@PostMapping(value = "/employees")
public ResponseEntity<GenderData> addEmployee (@RequestBody GenderData employee)
{
	return new ResponseEntity<GenderData>(employee, HttpStatus.OK);
}



@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(method=RequestMethod.GET,value="/VillageMaster")
public Timestamp DateApi()
{	
	Date d=new Date();
	System.out.println(d.getTime());
	
	long currentDateTime=d.getTime();
	
	String []UploadedDate= {"1558001205606","15580012056","155800120","1558001205606"};
	String []Date2= {"1558001205606","15580012056","155800120","1558001205606"};
	
	for(int i=0;i<Date2.length;i++) 
	{
		String s=Date2[i];
		long ModifiedDateTime = Long.parseLong(s);


  if(currentDateTime<ModifiedDateTime) 
  {
	  System.out.println(" ModifiedDateTime is greater than currentDateTime");
  }
   if(currentDateTime>ModifiedDateTime) 
  {
System.out.println(" currentDateTime is greater than ModifiedDateTime "); 
  }
}
	 
	 return null;	
}



//	http://localhost:8080/GetJson?payments=101&payments=102&payments=103&payments=101&days=20120101&days=20120505
//		http://localhost:8080/xirrdata/GetJson/
//--------------------------------------------------------------

/*

{
    "dates": ["01/01/2016","10/01/2016","01/06/2016","25/10/2016","27/10/2016","01/03/2017","15/06/2017"],
    "payments": [-50000,500,500,500,500,500,51000]
}


{
    "dates": ["11/11/2015","25/11/2015","25/12/2015","25/01/2016","25/02/2016","25/03/2016"],
    "payments": [-1151250,232912,233123,233336,233551,233768]
}


*/
@RequestMapping(method=RequestMethod.GET,value="/check")
public String[] check()
{
	
	String []days= {"11/11/2015","25/11/2015","25/12/2015","25/01/2016","25/02/2016","25/03/2016"};
	return days;	
}

@Consumes({MediaType.APPLICATION_JSON})
@RequestMapping(method=RequestMethod.POST,value="/xir_json")
public double postMessage(@RequestBody XirrData msg) throws Exception{
    
	String dates[]=msg.getDates();
	double payments[]=msg.getPayments();
	
	double xirr = 0;
	if(dates.length!=payments.length) 
	{
		System.out.println(" Count does not match ");

	}
	else
	{
		 xirr=Xirr.test(payments, dates);
	}	
	return xirr;	
	    
}


@Consumes({MediaType.APPLICATION_JSON})
@RequestMapping(method=RequestMethod.POST,value="/getSmsCall")
public void getCheckFlag( String payload) throws Exception
{	System.out.println("payload"+payload);

	MessageData messageData =new MessageData();
	
	messageData.setExpires("today");
	messageData.setUrl("http://");
	
	SMSBody smsBody1= new SMSBody();
	
	smsBody1.setSuccess(messageData);

	
	Gson gson = new Gson();
	SendSmsBody smsBody=new SendSmsBody();
	smsBody = (SendSmsBody)gson.fromJson( payload, smsBody.getClass());

	MyfirstService ms=new MyfirstService();	
	System.out.println(" smsgupshup Service: "+MyfirstService.sendOTP(smsBody.getTo(), smsBody1));
	System.out.println(" myvaluefirst Service: "+ms.getCheckUp(payload));
		
		DBConn dBConn = new DBConn();
		PreparedStatement prepareStatement;

		Connection con = dBConn.getDBConnectionForPro();
		prepareStatement = con.prepareStatement(
				"SELECT VALUE FROM TBL_MASCONFIGTTB WHERE SERVICE_NAME=GUPSHUP");
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.getString("VALUE").contains("TRUE")) 
		{
		//	return ms.getCheckUp(smsBody.getTo(), smsBody);
			
		}else 
		{
			//return MyfirstService.sendOTP(smsBody.getTo(), smsBody1);
		}
	
	

}

public Object getCheckUp(String to){
	
	System.out.println(to);
//System.out.println(" To "+to+ "SendSmsBody "+smsBody);
Gson gson = new Gson();
//	System.out.println("Payload: "+payload);
	String responseJson = "";

	//String username = "sangamltfs";
	//String password = "ltfnce89";
	
//Payload: { "to":"9752165945", "from":"LNTFIN", "text":"DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS 123456", "username":"sangamltfs", "password":"ltfnce89" }
 
//SmsBody [to=9752165945, from=LNTFIN, text=DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS 123456, username=sangamltfs, password=ltfnce89]

	Properties properties = new Properties();
/*		Gson gson = new Gson();
	SendSmsBody smsBody=new SendSmsBody();
	smsBody = (SendSmsBody)gson.fromJson( payload, smsBody.getClass());
	
	System.out.println(smsBody);
*/		
	
	
	String otp=MyfirstService.getRandomNumberString();
	
	  FetchURL fetchUrl = new FetchURL();
	try {
			
			 String requestUrl = fetchUrl.getSendSmsUrl() + "?username=" +
			  URLEncoder.encode(fetchUrl.getUserName(), "UTF-8") + "&password=" +
			  URLEncoder.encode(fetchUrl.getUserPassword(), "UTF-8") + "&to=" +
			  URLEncoder.encode(to, "UTF-8") + "&from=" +
			  URLEncoder.encode(fetchUrl.getFrom(), "UTF-8") + "&messagetype=SMS:TEXT" +
			  "&text=" + URLEncoder.encode(fetchUrl.getUserText()+" "+otp, "UTF-8")+
			  "&dlr-mask=19" + "&dlr-url";
			  
			 		
		URL url = new URL(requestUrl);
		System.out.println(url);
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
		OkHttpClient client = new OkHttpClient();
		// http://enterprise.smsgupshup.com/GatewayAPI/rest?method=SendMessage&send_to="+mobileNumber+"&msg=Please
		// click on

// "+data.getSuccess().getUrl()+"&msg_type=TEXT&userid=2000169289&auth_scheme=plain&password=cmtVvQ&v=1.1&format=text
		System.out.println("aya");
		String url = "https://enterprise.smsgupshup.com/GatewayAPI/rest?method=SendMessage&send_to=" + mobileNumber
				+ "&msg=Please click on " + data.getSuccess().getUrl()
				+ "&msg_type=TEXT&userid=2000169289&auth_scheme=plain&password=cmtVvQ&v=1.1&format=text";
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
	//http://www.myvaluefirst.com/smpp/sendsms?username=sangamltfs&password=ltfnce89&to=9752165945&from=LNTFIN&messagetype=SMS:TEXT&text=DEAR+CUSTOMER%2C+YOUR+ONE-TIME+PASSWORD+FOR+THE+APPLICATION+IS+899417&dlr-mask=19&dlr-url
	
	
public static void main(String[] args) throws Exception
	{
	
	
	
	
	MyfirstService ms=new MyfirstService();
	
		System.out.println(ms.getCheckUp("9752165945"));
		String payload=	"{ \"to\":\"9752165945\", \"from\":\"LNTFIN\", \"text\":\"DEAR CUSTOMER, YOUR ONE-TIME PASSWORD FOR THE APPLICATION IS \", \"username\":\"sangamltfs\", \"password\":\"ltfnce89\" }";
		ms.getCheckFlag("9021856247");
}				

public static String getRandomNumberString() {
    // It will generate 6 digit random Number.
    // from 0 to 999999
    Random rnd = new Random();
    int number = rnd.nextInt(999999);

    // this will convert any number sequence into 6 character.
    return String.format("%06d", number);
}
	
























}		