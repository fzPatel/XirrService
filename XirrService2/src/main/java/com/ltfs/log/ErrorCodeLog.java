package com.ltfs.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Rest.DataBase.DBConn;


public class ErrorCodeLog {

	public static void saveResponseCode(String string, String id,String url,String status_code) {

		DBConn dbConn=new DBConn();
		Connection con=dbConn.getDBConnectionForPro();
		
		PreparedStatement ps=null;
		try {
			
			ps= con.prepareStatement("INSERT INTO api_failure_logs(ServiceType,id,url,status_code) VALUES(?,?,?,?)");
			
			ps.setString(1, string);
			ps.setString(2, id);
			ps.setString(3, url);
			ps.setString(4, status_code);
			ps.execute();

		} catch (SQLException e) {
			PerfiosLogger.error(e.getMessage(), e);
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
