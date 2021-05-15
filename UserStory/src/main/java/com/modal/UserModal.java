package com.modal;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class UserModal {
	
	private int ID;
	private String UserName;
	private String Mail;
	private String Address;
	private int Mobile;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		Mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", UserName=" + UserName + ", Mail=" + Mail + ", Address=" + Address + ", Mobile="
				+ Mobile + "]";
	}


	
	
	

}
