package com.overhome.modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String url = "jdbc:mysql://http://35.204.23.49/overhome";
	private static String user = "root";
	private static String pwd = "admin";

	private static Connection connection = null;

	private static int connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pwd);
			return 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static Connection getConnection(){
		try {
			if (connection == null || connection.isClosed()){
				connect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnetion(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}