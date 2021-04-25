//IT18095586

package model;

import java.sql.*;

public class Product {

	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget", "root", "");

			// For testing
			System.out.print("DB Successfully connected");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}

	// Insert
	public String insertProduct(String ProdName, String Category, String Price, String Researchers, String Description) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into Producttable(`ProductID`,`ProdName`,`Category`,`Price`,`Researchers`,`Description`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, ProdName);
			preparedStmt.setString(3, Category);
			preparedStmt.setDouble(4, Double.parseDouble(Price));
			preparedStmt.setString(5, Researchers);
			preparedStmt.setString(6, Description);
			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Read
	public String readProduct() {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Product Name</th>" + "<th>Category</th><th>Price</th>"
					+ "<th>Researchers</th>" + "<th>Description</th></tr>";

			String query = "select * from Producttable";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String ProductID  = Integer.toString(rs.getInt("ProductID"));
				String ProdName = rs.getString("ProdName");
				String Category = rs.getString("Category");
				String Price = Double.toString(rs.getDouble("Price"));
				String Researchers = rs.getString("Researchers");
				String Description = rs.getString("Description");;

				// Add into the html table
				output += "<tr><td>" + ProdName + "</td>";
				output += "<td>" + Category + "</td>";
				output += "<td>" + Price + "</td>";
				output += "<td>" + Researchers + "</td>";
				output += "<td>" + Description + "</td>";
				

			}

			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Products.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Update
	public String updateProduct(String ProductID, String ProdName, String Category, String Price, String Researchers, String Description) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE Producttable SET ProdName=?,Category=?,Price=?,Researchers=?,Description=? WHERE ProductID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, ProdName);
			preparedStmt.setString(2, Category);
			preparedStmt.setDouble(3, Double.parseDouble(Price));
			preparedStmt.setString(4, Researchers);
			preparedStmt.setString(5, Description);
			preparedStmt.setInt(6, Integer.parseInt(ProductID));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";

		} catch (Exception e) {
			output = "Error while updating the Products.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Delete
	public String deleteProduct(String ProductID) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from Producttable where ProductID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ProductID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the Product Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
