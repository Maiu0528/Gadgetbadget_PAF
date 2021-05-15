package com.controller;

import java.sql.*;

import java.util.*;

import com.config.dbconnector;
import com.modal.UserModal;



public class UserController {

	Connection con = null;

	public UserController() {
		con = dbconnector.connector();
	}

	public List<UserModal> getUsers() {

		List<UserModal> user = new ArrayList<>();
		String sql = "select * from user";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				UserModal b = new UserModal();
				b.setID(rs.getInt(1));
				b.setUserName(rs.getString(2));
				b.setMail(rs.getString(3));

				b.setAddress(rs.getString(4));
				b.setMobile(rs.getInt(5));

				user.add(b);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return user;
	}

	public UserModal getUser(int bid)

	{
		String sql = "select * from user where ID=" + bid;
		UserModal b = new UserModal();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				b.setID(rs.getInt(1));
				b.setUserName(rs.getString(2));
				b.setMail(rs.getString(3));
				b.setAddress(rs.getString(4));
				b.setMobile(rs.getInt(5));
				

			}

		} catch (Exception e) {

			System.out.println(e);
		}
		return b;
	}

	public void createUser(UserModal b1) {
		String sql = "insert into user values(?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, b1.getID());
			st.setString(2, b1.getUserName());
			st.setString(3, b1.getMail());

			st.setString(4, b1.getAddress());

			st.setInt(5, b1.getMobile());
			st.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public void updateUser(UserModal b1) {
		String sql = "update user set UserName=?,Mail=?,Address=?,Mobile=?, where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, b1.getID());
			st.setString(2, b1.getUserName());
			st.setString(3, b1.getMail());
			st.setString(4, b1.getAddress());
			st.setInt(5, b1.getMobile());
			

			st.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public void deleteUser(int bid) {

		String sql = "delete from user where ID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, bid);
			st.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}

	}

}
