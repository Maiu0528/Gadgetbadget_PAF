package com.config;

import java.sql.*;

public class dbconnector {

	public static Connection connector() {
		Connection con = null;

		String url = "jdbc:mysql://127.0.0.1:3306/user";
		String username = "root";
		String password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Top");

			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/gbsystem?user=" + username + "&password=" + password);
			System.out.println("Connection Successfully connected");
			if (con != null) {
				System.out.println("Fail to  Connected....!!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
