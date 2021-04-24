package com.controller;

import java.sql.*;
import java.util.*;
import com.java.Payment;

import com.config.dbconnector;

public class cntPayment {
	 
		
		Connection con = null;
		
		public cntPayment()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Payment>getPayments(){
	   	 
	   	 List<Payment> payments = new ArrayList<>();
	   	 String sql = "select * from payment";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Payment p = new Payment();
					  p.setPayment_id(rs.getInt(1));
					  p.setUser_id(rs.getInt(2));
					  p.setMethod(rs.getString(3));
					  p.setStatus(rs.getString(4));
					  p.setAmount(rs.getDouble(5));
					  p.setDate(rs.getDate(6));
					  p.setDescription(rs.getString(7));
					  				   
					  
					  payments.add(p);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return payments;
	    }
	        
	    
	    public Payment getPayment(int payment_id)
	    
	    {
	   	 String sql = "select * from payment where payment_id="+payment_id;
	   	  Payment p = new Payment();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  p.setPayment_id(rs.getInt(1));
					  p.setUser_id(rs.getInt(2));
					  p.setMethod(rs.getString(3));
					  p.setStatus(rs.getString(4));
					  p.setAmount(rs.getDouble(5));
					  p.setDate(rs.getDate(6));
					  p.setDescription(rs.getString(7));
					  	
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p;
	    }

		public void create(Payment p1) 
		{
			String sql = "insert into payment values(?,?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getPayment_id());
			  st.setInt(2, p1.getUser_id());
			  st.setString(3, p1.getMethod());
			  st.setString(4, p1.getStatus());
			  st.setDouble(5, p1.getAmount());
			  st.setDate(6, p1.getDate());
			  st.setString(7, p1.getDescription());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Payment p1) 
		{
			String sql = "update payment set method=?,status=?,amount=?,date=?,description=?,user_id=? where payment_id=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setString(1, p1.getMethod());
			  st.setString(2, p1.getStatus());
			  st.setDouble(3, p1.getAmount());
			  st.setDate(4, p1.getDate());
			  st.setString(5, p1.getDescription());
			  st.setInt(6, p1.getUser_id());
			  st.setInt(7, p1.getPayment_id());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int payment_id) {

			String sql = "delete from payment where payment_id=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, payment_id);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
