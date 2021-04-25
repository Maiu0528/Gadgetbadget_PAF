package model;

import java.sql.*; 

public class Researcher {

	
	

	public  Connection connect() { 
		
		Connection con = null;
		
		try {
		 
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gaddb","root", "");
	 		
		}
	 
	 	catch(Exception e) {
	 		
	 		e.printStackTrace();
	 		}

		return con;

	 
	}
	


	public String insertResearcher(String ResearcherID, String ResearcherName, String ResearcherAddress, String NIC, String ResearcherPosition, String Description) { 
		
		String output = ""; 
	 
		try { 
			Connection con = connect();
	  
			if (con == null) {
				return "Error while connecting to the database for inserting."; 
			} 
	 
			String query = " insert into Researcher (`Researcher_id`, `user_id`,`ResearcherName`,`ResearcherAddress`,`NIC`,`ResearcherPosition`,`description`)" + " values (?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, ResearcherID); 
			preparedStmt.setString(3, ResearcherName); 
			preparedStmt.setString(4, ResearcherAddress); 
			preparedStmt.setString(5, NIC); 
			preparedStmt.setString(6, ResearcherPosition); 
			preparedStmt.setString(7, Description); 
		
	 
	
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Researcher successfully added"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the Researcher."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	
	
	

	public String readResearcher() 
	 { 
		String output = ""; 
		
		try
		{ 
			Connection con = connect(); 
			if (con == null) {
				return "Error while connecting to the database for reading.";
				} 
	
			output = "<table border='1'> <tr><th>Researcher ID</th>"
					+ "<th>User ID</th>"
					+ "<th>ResearcherName</th>"
					+ "<th>ResearcherAddress</th>"
					+ "<th>NIC</th>"
					+ "<th>ResearcherPosition</th>"
					+ "<th>Description</th></tr>"; 
	 
			String query = "select * from Researcher"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
	 
	 
	
			while (rs.next()) 
			{ 
		 
				String Researcher_id = Integer.toString(rs.getInt("Researcher_id")); 
				String user_id = rs.getString("user_id"); 
				String ResearcherName = rs.getString("ResearcherName"); 
				String ResearcherAddress = rs.getString("ResearcherAddress"); 
				String NIC = rs.getString("NIC"); 
				String ResearcherPosition = rs.getString("ResearcherPosition"); 
				String description = rs.getString("description"); 
				
	 
	
				output += "<tr><td>" + Researcher_id + "</td>";
				output += "<td>" + user_id + "</td>";
				output += "<td>" + ResearcherName + "</td>"; 
				output += "<td>" + ResearcherAddress + "</td>"; 
				output += "<td>" + NIC + "</td>"; 
				output += "<td>" + ResearcherPosition + "</td>"; 
				output += "<td>" + description + "</td>"; 
				
				 // buttons 		
				   output
						  += "<td><input name='btnUpResearcherPosition' "
						  + " type='button' value='UpResearcherPosition' class='btn btn-secondary' </td>"
				 		  + "<td><form ResearcherName='post' action='Products.jsp'>"
				 		  + "<input name='btnRemove' " + " type='submit' value='Remove' class='btn btn-danger'>"
				 		  + "<input name='Researcher_id' type='hidden' " + " value='" + Researcher_id + "'>" + "</form></td></tr>";
				 		 
			} 
			
	 con.close(); 
	 
	// Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "Error while reading the Researcher."; 
		 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

	

	public String upResearcherPositionResearcher(String ResearcherID, String researcherID, String ResearcherName, String ResearcherAddress, String NIC, String ResearcherPosition, String Description)
	 {
		
	 String output = "";
	 
	 try
	 {
		 Connection con = connect();
		 
		 if (con == null) {
			 
			 return "Error while connecting to the database for updating.";
			 }
		 
		 
		
			 
		 String query = "UPResearcherPosition sponsor SET user_id=?, ResearcherName=?, ResearcherAddress=?, NIC=?, ResearcherPosition=?, description=?  WHERE Researcher_id=?";

		 PreparedStatement preparedStmt = con.prepareStatement(query);

		 preparedStmt.setString(1, ResearcherID); 
		 preparedStmt.setString(2, ResearcherName); 
		 preparedStmt.setString(3, ResearcherAddress); 
		 preparedStmt.setString(4, NIC); 
		 preparedStmt.setString(5, ResearcherPosition); 
		 preparedStmt.setString(6, Description); 
		 preparedStmt.setInt(7, Integer.parseInt(ResearcherID));
		
				
			 
		 preparedStmt.execute();
		 con.close();
	
		 output = "Researcher successfully upResearcherPosition ";
		 }
	
	 catch (Exception e){
		 
		 output = "Error while updating the Researcher.";
		 System.err.println(e.getMessage());
	 
	 }
	
	 return output;
	 } 
	
	

	
	public String deleteResearcher(String ResearcherID)
	 {
	 
		String output = "";
		
		try{
			
			Connection con = connect();
			if (con == null){
				return "Error while connecting to the database for deleting.";
				}
	 
			
			String query = "delete from Researcher where Researcher_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			preparedStmt.setInt(1, Integer.parseInt(ResearcherID));
			
			preparedStmt.execute();
			con.close();
			
			output = "Researcher successfully deleted ";
		}
			
	 catch (Exception e) {
		 
		 output = "Error while deleting the Sponsor Details.";
		 System.err.println(e.getMessage());
	 }
		
	 return output;
	 
	 }



	public String updateResearcher(String researcher_id, String researcherName, String researcherAddress, String nIC,
			String amount, String description) {
		// TODO Auto-generated method stub
		return null;
	}



	public String insertResearcher(String researcherName, String researcherAddress, String nIC,
			String researcherPosition, String description) {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
