package com.diworksdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {    //接続に必要な情報設定
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite";
	private static String user = "root";
	private static String password = "disql";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);//上記からMySQLへ接続準備
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
		return con;//MYSQLに接続できたか情報を渡します
	}

}