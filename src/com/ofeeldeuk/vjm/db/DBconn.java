package com.ofeeldeuk.vjm.db;

import java.sql.*;

public class DBconn {
	private static Connection dbConn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(dbConn  == null){
			String driverName="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/vjm";
			String id = "root";
			String pwd = "1234";
			
			Class.forName(driverName);
			System.out.println("드라이버로드");
			dbConn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB연결 성공!");
		}
		
		return dbConn;
	}
	
	public static void close() throws SQLException{
		if(dbConn != null){
			System.out.println("conn닫기()");
			if(!dbConn.isClosed()){
				dbConn.close();
			}
		}
		dbConn = null;
	}
}
