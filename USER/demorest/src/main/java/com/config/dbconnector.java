package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnector {

	public static Connection connector()
	{
		Connection con=null;
		String dbURL = "jdbc:sqlserver:LAPTOP-AI01D0D7;databaseName=gadgetbadget;";
		String UserName="sa";
		String PassWord="abcd1234";
		try {
			con=DriverManager.getConnection(dbURL, UserName, PassWord);
			System.out.println("Connection Done");
			if (con != null) {
                System.out.println("Connected to the fail");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
