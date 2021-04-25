package com.controller;


import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.*;

import com.java.User;

import com.config.dbconnector;

public class cntUser {
	
	Connection con = null;
	
	public cntUser() 
	{
		con=dbconnector.connector();
	}
	
	public List<User> GetUsers()
	{
		List<User> users = new ArrayList<>();
	   	 String sql = "select * from User";
	   	 try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next())
			{
				User u=new User();
				u.SetId(rs.getInt(1));
				u.SetFirstName(rs.getString(2));
				u.SetLastName(rs.getString(3));
				u.SetDate(rs.getDate(4));
				u.SetAddress(rs.getString(5));
				u.setTelephoneNo(rs.getString(6));
				u.setUserName(rs.getString(7));
				u.setPassWord(rs.getString(8));
				u.setEmail(rs.getString(9));
				u.setUsetrType(rs.getString(10));
				
				users.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	 return users;
	}
	
	public User GetUser(int id)
	{
		String sql = "select * from User where Id="+id;
	   	  User u = new User();
	   	try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if(rs.next())
			{
				u.SetId(rs.getInt(1));
				u.SetFirstName(rs.getString(2));
				u.SetLastName(rs.getString(3));
				u.SetDate(rs.getDate(4));
				u.SetAddress(rs.getString(5));
				u.setTelephoneNo(rs.getString(6));
				u.setUserName(rs.getString(7));
				u.setPassWord(rs.getString(8));
				u.setEmail(rs.getString(9));
				u.setUsetrType(rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	  return u;
	}
	
	public void CreateUser(User usr)
	{
		String sql = "insert into User values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, usr.getId());
			st.setString(2, usr.getFirstName());
			st.setString(3, usr.getLastName());
			st.setDate(4, (Date) usr.getdate());
			st.setString(5, usr.getAddress());
			st.setString(6, usr.getTelephoneNo());
			st.setString(7, usr.getUserName());
			st.setString(8, usr.getPassWord());
			st.setString(9, usr.getEmail());
			st.setString(10, usr.getUsetrType());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateUser(User usr)
	{
		String sql = "update User set FirstName=?,LastName=?,DateofBirth=?,Address=?,TelephoneNo=?,UserName=?,PassWord=?,Email=?,UserType=? where Id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, usr.getFirstName());
			st.setString(2, usr.getLastName());
			st.setDate(3, (Date) usr.getdate());
			st.setString(4, usr.getAddress());
			st.setString(5, usr.getTelephoneNo());
			st.setString(6, usr.getUserName());
			st.setString(7, usr.getPassWord());
			st.setString(8, usr.getEmail());
			st.setString(9, usr.getUsetrType());
			st.setInt(10, usr.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteUser(int id)
	{
		String sql = "delete from User where Id=?";
		 try {
			PreparedStatement st = con.prepareStatement(sql);
			 st.setInt(1, id);
	         st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
