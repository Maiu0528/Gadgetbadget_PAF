package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Payment {
	
	private int payment_id;
	private String method;
	private String status;
	private double amount;
	private Date date;
	private String description;
	private int user_id;
	
	

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		
		return "Payment [payment_id=" +payment_id + " ,method=" + method + ", status=" + status + ", amount=" + amount
				+ ",date=" + date + ",description=" + description + ", user_id=" + user_id + "]";
	}	
	
	
	

}
