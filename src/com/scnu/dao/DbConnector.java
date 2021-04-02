package com.scnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private Connection con;
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private String dbUser = "root";
	private String dbPsw = "123456";
	private String dbUrl = "jdbc:mysql://localhost:3306/xcglxt?serverTimezone=UTC";

	public Connection getConnection() {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPsw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
