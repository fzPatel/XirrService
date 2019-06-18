/*package com.xirr.XirrService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.swing.text.html.HTML.Tag;

import org.json.JSONObject;
import org.json.XML;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GenerateLinkDaoImpl implements GenerateLinkDao {

	
	 * static String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
	 * "MIIBOwIBAAJBAO3eZC1p0pFM/0PaPru4ZDTq8vmz5VLzcVo5MQo2Ar+U4ZmnXy5r\n" +
	 * "jAujgTy+Gp4BG0tzqZ/kBMZCgNt2wcC4UOcCAwEAAQJAYwkSwG2sw95A8WkucU3m\n" +
	 * "OroPi7NAqXa+HQhuyIeQQV7XrMAHjt8wCJOW/gYBQW+dhYV/Kwi5ssgQyFolzR6O\n" +
	 * "4QIhAP9HXPhvCxfNwDiab8bBwDtgVZLvCvSKGs2bDL+2j0TZAiEA7opvltAgTz2v\n" +
	 * "WTTYU4chffCbG6iJTwZN1Uk0rb0vq78CIETm5SAlELBvF3fvr0XNW+5q1Q4guStB\n" +
	 * "73QZanqAcvEZAiEAhakIUecY043q3P9hX5xORfU11E+hcKhFoIc+f0OMnJ0CIQCU\n" +
	 * "oxmjwcY+rySlkBlaR2CdVbZ4M8XxSeVj5IxyHziCjw==\n" +
	 * "-----END RSA PRIVATE KEY-----";
	 

	
	 * static String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
	 * "MIIEowIBAAKCAQEA0P+j0DVIINPjun7CXcx1vZKR+9PwVnsDO1BR97xgTzMpX0uE\n" +
	 * "hNQPdADwfRlNNJPLyTkpwY0FCwpLgLynyChDsrGftruOrylSOoeq/zEuipaVU5Cr\n" +
	 * "r8CDBhYL5EUJPgA1QgfeOTtZoz71dmkRBZ9LdE7JVr/ZgPBgVJ8qp9vkcrvDT+9Y\n" +
	 * "OwBtVy/+8QcBTGCRpte5TMq+CfJUop8ZkF1rw4ZGtMmmA+YnwcxdcGLaDUVnpC3f\n" +
	 * "qTT236lyCHpjwyN/I4SqOGXfUkt16pqUC6DbGnr3SvmJYLnvesnlkfJvbSTYhg36\n" +
	 * "jsIXeWWRzHDVGqgyadaIeOWQeCPbbLqghXx9kQIDAQABAoIBAQC4Kz2YYQtxWibI\n" +
	 * "FaGDdIOgjQM1bZrRKk87uliwvQAFaqkff3WEczY23AkPw/cDyOWAKW5BT9pM00Kb\n" +
	 * "bCNRvyGA2wNJzFc8xWXfi+PEQvunRnDKFaclFbif6VeLTMaLKzXDPRm3RzSDJRy6\n" +
	 * "vnUwhiHAmRjU5/RrqebJSwUUrDHQY0lZKShucYwYyecCW87g8sGmpkyzUS0bxNko\n" +
	 * "hA2p1aIheOxqclyinFUOqKIlief0DXSY/jpHhWijh3ixzqLCAT1y8rJNoqJXSVtv\n" +
	 * "cOoPwkcB/8pcVYsoEpxJIZx0wFtzvrhLmSgUPmKA+WC2BIjgT9imFvWaJiMedaXw\n" +
	 * "M7wNSEDBAoGBAP93EM0Rhemv9WsqbKuFxhthIWL0cCxbaV3E8O8c0ulZHp9SeRAn\n" +
	 * "4ktARGGBYnns1Ez2bfO6wUJSv5IOK7a4KHuxJ2zqYxxx62u5HpTKQKi2cdMKBPBU\n" +
	 * "itlTov8e8r4SZ47frHEaxCEN6TcPGE6nYzj3MXDng183Qd1DoByS7Lj5AoGBANFv\n" +
	 * "qtPhPKgAOyZlC80OJ7qf6Vyp4gDUpOnhbfgIa6lcqbQS1dKJOlHvmqAAITGmFK1N\n" +
	 * "HWriWy6juXIAqr5B0+6CehUuiJjfEsAWFD/CQ1cWwTerQCTvl99Z4JEAIJ+S7dqB\n" +
	 * "G5oI1di9ksSpAufad3/5tvrY33Q1Zx4bzDVd5GdZAoGAJvT3QO5tJ2fH2yHLFJT/\n" +
	 * "0ukK+FYiTQFbngsMWspgd2k5vD4NbCNI5QTV6LCcXc95yIrD1akjE4Qe5pz2mZSX\n" +
	 * "x9UKGBfeKVZN+k1ulm4JUjEQRoh+nE+oJOAWOSV1Cvsvg6AkYdMdGZVPfS/2Gvh3\n" +
	 * "rxYzGe6UIA8DIkTPw8u8AbECgYBXWRBRH/5RPw9sWvZKBl5ReoI0cHHe0NEa7jcU\n" +
	 * "HEbysr/gZ36gOTWGmLzPgF5Xu6GiCah8PH20/PnJ7zdG9GN0dRx/mxHDWD4UuOCn\n" +
	 * "GtlFCCt7kUPGY9refzimoPv6Mahb2j7txkOSCracqLSaiEYQrNBA3JSNffxM1WEc\n" +
	 * "3NT2uQKBgGQKfjiyikg+petG0JzMIc8L5JP2JVTmaqatuHVkcfv0EPQtLcMmGp6V\n" +
	 * "31ANKue62mkCfbNz2cxV/+ZxDBZYvRWcqTvfXGFEPV4dmBx6B5YRMpUAJJDQtrjc\n" +
	 * "paZs5ulBhK55pypkUnBAFb1qiN4QM9s+drM0T8Llu8Vlp1hSOrlh\n" +
	 * "-----END RSA PRIVATE KEY-----" ;
	 

	static String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEowIBAAKCAQEAqOcfbkllftnRCsT2BwK2dfcAPPpgD1Rf9JkDDmyxHjZJdL0C\n"
			+ "QJ3exTI7uJ1MZFADKGh3woQT2OjRHTr2R8aQssJQTRGkSrz0KYiQnUEn+HOX9/LU\n"
			+ "rAKmh2RVxYxn291wKRD7vYomQ0zkbZkwFt+EGjROEO8mPSb3mRDPvcES9SH4RByz\n"
			+ "OGAcLYpZMVtBuWevmH7ARU2EaqHLYA9/O8J9zwsY0oVcXgY0RplqCx+jgczX8PHl\n"
			+ "wj3aMHD4Kfx//kiTDnxRgsOLktt6B1JppMLj5AIVBLUjeKsxT56x3S4ATVAjC/Pz\n"
			+ "Z6ZtRBhPjSUBRN9ejT2FHSW1UB80lSqInc01IwIDAQABAoIBAEoVpnmvg+9SBxkc\n"
			+ "L3X/wJyZjOcyQzQ2JCibfPW0wzOnSC0GQpipJm+EiyF9DWbqmZf9ypntaO85n4+c\n"
			+ "ry3ocMuX47UKSe/mVYpqNlRjoe6edUfyoUoZl4XHgr+1yFBuHqZEpscKc6INdhyE\n"
			+ "ls1RmRYNXziaTUGBeBURhK2MpI4UcJlT9b75rPt8PyVYGySxsLWIz7UGU11VCaUz\n"
			+ "T2zf8JoBTEiqr0Cojxje+LviLiYjp6mAgfEDw7aIt3HRYFj2djXgsmmMgBpmdzFJ\n"
			+ "GevF6mn2hV5JtbVTMhCfwT/TmEo8rx2nzftD4woLGPriIYdyeYgQNg9SAPtWjEud\n"
			+ "8wGSfsECgYEA+7gj0Og7KYaA1VH34k0tm/Ergr0n79bnDHm1TRyIQym7hEm0+5uL\n"
			+ "j5fTI3/aXTRJUeP6jrUtvMo7DjsicxbfzGFlNCLRH5kT1qGP+SDcZVDh4SQ18MDI\n"
			+ "lAENClnVYwU5OdaesDEYDjzLAaBzeZyljgooMU8UtGV7CHnToCJnzHECgYEAq8Zw\n"
			+ "+ae6HefOMsOgkU4C/fv8ZltDKUkdaTC5KM4abEk1zgwJv5wrPkYGwWprLS+p+s92\n"
			+ "cg6Y6n4FM09vN67wzrAp3gk76e2lNoCQDwtx4g0bL5PGSFT0MxUqR4hKRn0/Rt/Q\n"
			+ "O+/GlJ96u0kNZXIUcBz5YWq3EoCGyYCu0Yuk9NMCgYBC53eFkCQhbmGR0V6MZK0J\n"
			+ "tLk236XcxobUtwisPTguecogaCLVeUtH2DfDSLk2aq5OOMUg5yEH+8xkhO0sH9lO\n"
			+ "DlkC2Xox5tLyCjElK0nJGA1hdOltWyA0zm6z4Jqp3fqO1++HrxTQu/HNNeNbYHpU\n"
			+ "XXi/WmCLbimcYB0Sg/KI0QKBgQCogbieD/2yDI3omqPPJvokcad+OZS+0Wy6ngNl\n"
			+ "lhmxlHfls0V05Bw/sK472stcvl8/HXmSFePIVOuBFDGELGcqOwI3QFO3/VqPBrtL\n"
			+ "Ju0G1diPaaWfm0cbPW4GUhqa347NVg2OXn8tmOzrAJTVqX2HJcU13VvOGKsgzM2x\n"
			+ "3g1p5QKBgB00/m98J/10V/WHkQ1seiwocDRXy46bWk5si+NvnHpAFd592oM8+cAm\n"
			+ "P9QCl+rwsov68ndqEU2uvF0PltJT5Yj5kdXoYFMKGjrwuNLNmeGglvufoqnDiQ6h\n"
			+ "Ih6+sQkAiDT4/ho/ZIpNp7tdcBmpcblp4m+kJRtQusDttTLAd9Je\n" + "-----END RSA PRIVATE KEY-----";

	static final String DIGEST_ALGO = "SHA-1";
	static final String ENCRYPTION_ALGO = "RSA/ECB/PKCS1Padding";
	static String format = "xml";

	private final static char[] HEXA = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
			'D', 'E', 'F' };

	public String getEncryptMail(String mailId) {
		String emailEncrypted = "";
		emailEncrypted = encrypt(mailId, ENCRYPTION_ALGO, buildPublicKey(privateKey));
		return emailEncrypted;
	}

	public static String encrypt(String raw, String encryptAlgo, Key k) {
		String strEncrypted = "";
		try {
			Cipher cipher = Cipher.getInstance(encryptAlgo);
			cipher.init(Cipher.ENCRYPT_MODE, k);
			byte[] encrypted = cipher.doFinal(raw.getBytes("UTF-8"));
			byte[] encoded = Hex.encode(encrypted);
			strEncrypted = new String(encoded);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strEncrypted;
	}

	private static PublicKey buildPublicKey(String privateKeySerialized) {
		StringReader reader = new StringReader(privateKeySerialized);
		PublicKey pKey = null;
		try {
			PEMReader pemReader = new PEMReader(reader);
			KeyPair keyPair = (KeyPair) pemReader.readObject();
			pKey = keyPair.getPublic();
			pemReader.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return pKey;
	}

	public static String makeDigest(String payload, String digestAlgo) {
		String strDigest = "";
		try {
			MessageDigest md = MessageDigest.getInstance(digestAlgo);
			md.update(payload.getBytes("UTF-8"));
			byte[] digest = md.digest();
			byte[] encoded = Hex.encode(digest);
			strDigest = new String(encoded);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strDigest;
	}

	public String getPerfiosSignature(String payload) {
		String signature = "";
		signature = getSignature(ENCRYPTION_ALGO, DIGEST_ALGO, buildPrivateKey(privateKey), payload);
		return signature;
	}

	public static String getSignature(String encryptAlgo, String digestAlgo, Key k, String xml) {
		String dig = makeDigest(xml, digestAlgo);
		return encrypt(dig, encryptAlgo, k);
	}

	private static PrivateKey buildPrivateKey(String privateKeySerialized) {
		StringReader reader = new StringReader(privateKeySerialized);
		PrivateKey pKey = null;
		try {
			PEMReader pemReader = new PEMReader(reader);
			KeyPair keyPair = (KeyPair) pemReader.readObject();
			pKey = keyPair.getPrivate();
			pemReader.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return pKey;
	}

	public int insert(GenerateLinkReq generateLinkReq, String txnid) throws SQLException {
		DBConn dbConn = new DBConn();

		PreparedStatement prepareStatement;

		Connection con = dbConn.getDBConnectionForPro();
		
		 * prepareStatement = con.
		 * prepareStatement("INSERT INTO TBL_GENERATE_LINK(TXN_ID,DESTINATION,LOAN_AMOUNT,LOAN_DURATION,LOAN_TYPE,APPLICANT_ID,APP_TYPE,MTOKEN,USER_ID,MOBILENO)"
		 * + " VALUES(?,?,?,?,?,?,?,?,?,?)");
		 * prepareStatement.setString(1,generateLinkReq.getTxnId());
		 * prepareStatement.setString(2,generateLinkReq.getDestination());
		 * prepareStatement.setString(3,generateLinkReq.getLoanAmount());
		 * prepareStatement.setString(4,generateLinkReq.getLoanDuration());
		 * prepareStatement.setString(5,generateLinkReq.getLoanType());
		 * prepareStatement.setString(6,generateLinkReq.getApplicantId());
		 * prepareStatement.setString(7,generateLinkReq.getAppType());
		 * prepareStatement.setString(8,generateLinkReq.getMtoken());
		 * prepareStatement.setString(9,generateLinkReq.getUserID());
		 * prepareStatement.setString(10,generateLinkReq.getMobileNo());
		 
		prepareStatement = con.prepareStatement(
				"insert into TBL_Perfios_Log (USERID,APPID,EMAIL_ID,LTTXN_ID,CREATED_DATE,APPLICANT_ID,APP_TYPE,MTOKEN,USER_ID,APPLICATION_ID,MOBILENO,OPERATION_TYPE,currentEmployer,previousEmployer) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		prepareStatement.setString(1, generateLinkReq.getCustomerName());
		prepareStatement.setString(2, generateLinkReq.getAppType());
		prepareStatement.setString(3, generateLinkReq.getEmailId());
		prepareStatement.setString(4, txnid);
		prepareStatement.setTimestamp(5, DateUtility.getCurrentDate());
		prepareStatement.setString(6, generateLinkReq.getApplicantId());
		prepareStatement.setString(7, generateLinkReq.getAppType());
		prepareStatement.setString(8, generateLinkReq.getMtoken());
		prepareStatement.setString(9, generateLinkReq.getUserID());
		prepareStatement.setString(10, generateLinkReq.getApplicationId());
		prepareStatement.setString(11, generateLinkReq.getMobileNo());
		prepareStatement.setString(12, "CD_" + generateLinkReq.getOperationDesc());
		if (generateLinkReq.getEmployerNames().size() == 1) {
			prepareStatement.setString(13, generateLinkReq.getEmployerNames().get(0));
			prepareStatement.setString(14, "");
		} else {
			prepareStatement.setString(13, generateLinkReq.getEmployerNames().get(0));
			prepareStatement.setString(14, generateLinkReq.getEmployerNames().get(1));
		}
		int i = prepareStatement.executeUpdate();
		con.close();
		return i;

	}

	@Override
	public String generateLink(GenerateLinkReq generateLinkReq) {
		
		 * DBConn dbConn = new DBConn(); CallableStatement prepareStatement = null;
		 * Connection conndb = null; ResultSet rs = null;
		 
		// TODO Auto-generated method stub
		String lttxnId = getTransactionId(generateLinkReq.getUserID(), generateLinkReq.getAppType());
		//PerfiosLogger.logInfo("GenerateLinkDaoImpl :: Inside generate link()");

		try {
			
			
			insert(generateLinkReq, lttxnId);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String responseJson = "";
		// String url =
		// "https://demo.perfios.com/KuberaVault/insights/api/transaction/request";
		String url = "https://www.perfios.com/KuberaVault/insights/api/transaction/request";

		String callbackUrl = "";
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("url.properties"));
			callbackUrl = prop.getProperty("callBackUrlPublicIP");
		} catch (Exception e) {
			PerfiosLogger.error(e.getMessage(), e);

		}
		
		
		
		String payload = "";
		if (generateLinkReq.getEmployerNames().size() == 1) {
			// payload =
			// "<payload><apiVersion>2.0</apiVersion><vendorId>ltFinance</vendorId><txnId>"+lttxnId+"</txnId><employerNames><namePattern><pattern>"+generateLinkReq.getEmployerNames().get(0)+"</pattern></namePattern><namePattern><pattern></pattern></namePattern></employerNames><destination>"+generateLinkReq.getDestination()+"</destination><transactionCompleteCallbackUrl>"+callbackUrl+"</transactionCompleteCallbackUrl><loanAmount>"+generateLinkReq.getLoanAmount()+"</loanAmount><loanDuration>"+generateLinkReq.getLoanDuration()+"</loanDuration><loanType>"+generateLinkReq.getLoanType()+"</loanType><employmentType>"+generateLinkReq.getEmploymentType()+"</employmentType><productType>"+generateLinkReq.getAppType()+"</productType><customerName>"+generateLinkReq.getCustomerName()+"</customerName></payload>";
			// payload =
			// "<payload><apiVersion>2.0</apiVersion><vendorId>ltFinance</vendorId><txnId>"+lttxnId+"</txnId><employerNames><namePattern><pattern>"+generateLinkReq.getEmployerNames().get(0)+"</pattern></namePattern><namePattern></employerNames><destination>"+generateLinkReq.getDestination()+"</destination><transactionCompleteCallbackUrl>"+callbackUrl+"</transactionCompleteCallbackUrl><loanAmount>"+generateLinkReq.getLoanAmount()+"</loanAmount><loanDuration>"+generateLinkReq.getLoanDuration()+"</loanDuration><loanType>"+generateLinkReq.getLoanType()+"</loanType><employmentType>"+generateLinkReq.getEmploymentType()+"</employmentType><productType>"+generateLinkReq.getAppType()+"</productType><customerName>"+generateLinkReq.getCustomerName()+"</customerName></payload>";
			String currentEmployerName = generateLinkReq.getEmployerNames().get(0);
			// Added below code to change special characters to escape sequences for
			// employer names.	
			String currentEmployerName = CommonUtility.replaceSpecialCharToEscapeSeq(generateLinkReq.getEmployerNames().get(0));
			if(currentEmployerName.contains("&apos;") || currentEmployerName.contains("&quot;") )
			{
				//PerfiosLogger.logInfo("GenerateLinkDaoImpl : Calling  replaceSpecialCharToEscapeSeq again ");
				currentEmployerName = CommonUtility.replaceSpecialCharToEscapeSeq(currentEmployerName);				
			}

			//PerfiosLogger.logInfo("GenerateLinkDaoImpl ::currentEmployerName replaceSpecialCharToEscapeSeq:-" + currentEmployerName);
			//PerfiosLogger.logInfo("GenerateLinkDaoImpl ::if payload :-" + payload);
			payload = "<payload><apiVersion>2.0</apiVersion><vendorId>ltFinance</vendorId><txnId>" + lttxnId
					+ "</txnId><employerNames><namePattern><pattern>" +  "<![CDATA["+currentEmployerName+"]]>" 
					+ "</pattern></namePattern></employerNames><destination>" + generateLinkReq.getDestination()
					+ "</destination><transactionCompleteCallbackUrl>" + callbackUrl
					+ "</transactionCompleteCallbackUrl><loanAmount>" + generateLinkReq.getLoanAmount()
					+ "</loanAmount><loanDuration>" + generateLinkReq.getLoanDuration() + "</loanDuration><loanType>"
					+ generateLinkReq.getLoanType() + "</loanType><employmentType>"
					+ generateLinkReq.getEmploymentType() + "</employmentType><productType>"
					+ generateLinkReq.getAppType() + "</productType><customerName>" + generateLinkReq.getCustomerName()
					+ "</customerName></payload>";
			PerfiosLogger.logInfo("GenerateLinkDaoImpl :: if payload :-" + payload);
		} else {
			String currentEmployerName = generateLinkReq.getEmployerNames().get(0);
			String previousEmployerName = generateLinkReq.getEmployerNames().get(1);
			
				Changed below code to Handle special characters
			 *  to escape perfios logic
			 *  by using CData Tag .A <![CDATA["+currentEmployerName+"]]>


			payload = "<payload><apiVersion>2.0</apiVersion><vendorId>ltFinance</vendorId><txnId>" + lttxnId
					+ "</txnId><employerNames><namePattern><pattern>" + "<![CDATA["+currentEmployerName+"]]>" 
					+ "</pattern></namePattern><namePattern><pattern>" + "<![CDATA["+previousEmployerName+"]]>"
					+ "</pattern></namePattern></employerNames><destination>" + generateLinkReq.getDestination()
					+ "</destination><transactionCompleteCallbackUrl>" + callbackUrl
					+ "</transactionCompleteCallbackUrl><loanAmount>" + generateLinkReq.getLoanAmount()
					+ "</loanAmount><loanDuration>" + generateLinkReq.getLoanDuration() + "</loanDuration><loanType>"
					+ generateLinkReq.getLoanType() + "</loanType><employmentType>"
					+ generateLinkReq.getEmploymentType() + "</employmentType><productType>"
					+ generateLinkReq.getAppType() + "</productType><customerName>" + generateLinkReq.getCustomerName()
					+ "</customerName></payload>";
			PerfiosLogger.logInfo("GenerateLinkDaoImpl ::else payload :-" + payload);
		}

		// "<employerNames><namePattern><pattern>VIKRAM
		// JAIN</pattern></namePattern><namePattern><pattern>Bosch</pattern></namePattern></employerNames>"�

		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		PerfiosLogger.logInfo("Request for testing -->>>>> generateLink" + payload);
		try {
			String sign = getSignature(ENCRYPTION_ALGO, DIGEST_ALGO, buildPrivateKey(privateKey), payload);
			OkHttpClient client = new OkHttpClient();

			RequestBody formBody = new FormBody.Builder().add("payload", payload).add("signature", sign).build();

			Request request = new Request.Builder().url(url).post(formBody)
					.addHeader("Content-type", "application/x-www-form-urlencoded").build();
			//PerfiosLogger.logInfo("request Body >>>>> " + request.toString());
			Response response = client.newCall(request).execute();
			// System.out.println("Response Code >>>>>" + response.code());
			// System.out.println("Response Body >>>>>" + response.isSuccessful());
			PerfiosLogger.logInfo("Response Body >>>>> " + response.toString());
			//PerfiosLogger.logInfo("Response success >>>>> " + response.isSuccessful());
			//PerfiosLogger.logInfo("Response Body1 >>>>> " + response.body());
			
			
			*//****** Changes for Response Code in EKYC 20 August *******//* 
			
			if(response.code() != 200) {
				ErrorCodeLog.saveResponseCode("perfios",lttxnId,request.url().toString(),response.code()+"");
			}
			
			*//****** Changes for Response Code in EKYC 20 August *******//* 

			
			
			InputStream is = response.body().byteStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer res = new StringBuffer();
			//PerfiosLogger.logInfo("StringBuffer res Body >>>>> " + res.toString());
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			//PerfiosLogger.logInfo("FINAL Resonse before in.close()" + res.toString());
			in.close();

			// print result			 
			PerfiosLogger.logInfo("FINAL Response " + res.toString());
			JSONObject obj = XML.toJSONObject(res.toString());
			responseJson = obj.toString();
			//PerfiosLogger.logInfo("responseJson Resonse " + responseJson);
			PerfiosLogger.logerror("Response -->>>>> generateLink" + responseJson);
			Gson gson = new Gson();
			SMSBody body = new SMSBody();
			body = gson.fromJson(obj.toString(), body.getClass());
			String responsedata = sendOTP(generateLinkReq.getMobileNo(), body);
			String responsesms = SendSms(generateLinkReq.getMobileNo(), body);
			*//**
			 * Calling method to send Perfios Flag to LOS - RE: Perfios initiation payload - START
			 *//*
			PerfiosFlagBean perfiosBean = new PerfiosFlagBean();
			PerfiosFlag perfiosFlag = new PerfiosFlag();
			String applicantId=generateLinkReq.getApplicantId();
			ArrayList<Applicants> applicantsList = new ArrayList<Applicants>();
			if(applicantId != null && applicantId != "" ){
				Applicants applicant= new Applicants();
				applicant.setId(applicantId);
				applicant.setPerfios_Intiated__c(Boolean.TRUE);
				applicantsList.add(applicant);
			}
			perfiosFlag.setApplicants(applicantsList);
			
			perfiosBean.setContent(perfiosFlag);
			CommonUtility.sendPerfiosFlagToLos(perfiosBean);
			*//**
			 * Calling method to send Perfios Flag to LOS - RE: Perfios initiation payload - END
			 *//*
			// System.out.println("ResponseData: "+responsedata);
			String flag = responsedata.split(",")[0];
			if (flag.equals("SUCCESS")) {
				// System.out.println("SMS Send Successfully");
			}
		} catch (Exception e) {
			PerfiosLogger.error(e.getMessage(), e);
			PerfiosLogger.logerror("Error -->>>>> generateLink" + e.getMessage());
		}

		return responseJson;
	}

	private String getTransactionId(String userId, String appId) {

		String psno = "";

		if (StringUtils.isNumeric(userId)) {
			int new_x = Integer.parseInt(userId.substring(2));
			psno = new_x + "";
		} else {
			psno = userId.substring(2);
		}
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hrs = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int milsec = cal.get(Calendar.MILLISECOND);
		// String txnId = "ven" + "TW" + year + "" + month + "" + day+ "" +hrs+ "" +min
		// +""+ sec+ "" +milsec;
		String txnId = psno + year % 100 + "" + month + "" + day + "" + hrs + "" + min + "" + sec + "" + milsec / 10;
		return txnId;
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

		*//****** Changes for Response Code in EKYC 20 August *******//* 
		
		if(response.code() != 200) {
			ErrorCodeLog.saveResponseCode("perfios",mobileNumber,request.url().toString(),response.code()+"");
		}
		
		*//****** Changes for Response Code in EKYC 20 August *******//* 

		
		
		
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
	
	public static String SendSms(String to, SMSBody data) throws Exception {
		
		String payload = null;
		System.out.println("Payload: "+payload);
		String responseJson = "";
	
		//String username = "sangamltfs";
		//String password = "ltfnce89";
		Properties properties = new Properties();
		Gson gson = new Gson();
		SendSmsBody smsBody=new SendSmsBody();
		smsBody = (SendSmsBody)gson.fromJson( payload, smsBody.getClass());
		 System.out.println(smsBody);
		  String requestUrl;
		  FetchURL fetchUrl = new FetchURL();
		try {
			requestUrl = fetchUrl.getSendSmsUrl() + "?username="
			  + URLEncoder.encode(properties.getProperty("user-sms"), "UTF-8") + "&password=" +
			  URLEncoder.encode(properties.getProperty("password-sms"), "UTF-8") + "&to=" +
			  URLEncoder.encode(smsBody.getTo(), "UTF-8") + "&from=" +
			  URLEncoder.encode(smsBody.getFrom(), "UTF-8") + "&messagetype=SMS:TEXT" +
			  "&text=" + URLEncoder.encode(smsBody.getText(), "UTF-8") + "&dlr-mask=19" +
			  "&dlr-url";
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
	public static void main(String[] args) {
		
		System.out.println("aya");
		SMSBody smsBody= new SMSBody();
		MessageData messageData =new MessageData();
		
		messageData.setExpires("today");
		messageData.setUrl("http://");
		
		smsBody.setSuccess(messageData);

		try {
			DBConn dBConn = new DBConn();
			PreparedStatement prepareStatement;

			Connection con = dBConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(
					"SELECT VALUE FROM TBL_MASCONFIGTTB WHERE SERVICE_NAME=GUPSHUP");
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.getString("VALUE").contains("TRUE")) {
				System.out.println(GenerateLinkDaoImpl.sendOTP("9028369297", smsBody));
			}else {
				System.out.println(GenerateLinkDaoImpl.SendSms("9028369297", smsBody));
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
*/