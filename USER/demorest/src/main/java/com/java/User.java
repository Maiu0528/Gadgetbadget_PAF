package com.java;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private int Id;
	private String FirstName;
	private String LastName;
	private Date DateofBirth;
	private String Address;
	private String TelephoneNo;
	private String UserName;
	private String PassWord;
	private String Email;
	private String UserType;

	public int getId()
	{
		return Id;
	}
	
	public void SetId(int id)
	{
		Id=id;
	}
	
	public String getFirstName()
	{
		return FirstName;
	}
	
	public void SetFirstName(String firstname)
	{
		FirstName=firstname;
	}
	
	public String getLastName()
	{
		return LastName;
	}
	
	public void SetLastName(String lastname)
	{
		LastName=lastname;
	}
	
	public Date getdate()
	{
		return DateofBirth;
	}
	
	public void SetDate(Date date)
	{
		DateofBirth=date;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public void SetAddress(String address)
	{
		Address=address;
	}
	
	public String getTelephoneNo()
	{
		return TelephoneNo;
	}
	
	public void setTelephoneNo(String tp_no)
	{
		TelephoneNo=tp_no;
	}
	
	public String getUserName()
	{
		return UserName;
	}
	
	public void setUserName(String uname)
	{
		UserName=uname;
	}
	public String getPassWord()
	{
		return PassWord;
	}
	
	public void setPassWord(String pwd)
	{
		PassWord=pwd;
	}
	public String getEmail()
	{
		return Email;
	}
	
	public void setEmail(String mail)
	{
		Email=mail;
	}
	
	public String getUsetrType()
	{
		return UserType;
	}
	
	public void setUsetrType(String uType)
	{
		UserType=uType;
	}
	
	@Override
	public String toString() {
		
		return "User [Id=" +Id + " ,FirstName=" + FirstName + ", LastName=" + LastName + ", DateofBirth=" + DateofBirth
				+ ", Address=" + Address +", TelephoneNo=" + TelephoneNo + ",UserName=" + UserName + ",PassWord=" + PassWord 
				+ ",Email=" + Email + ",UserType=" + UserType + "]";
	}	
}
