//IT18095586

package com;

//Model
import model.Product;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//SET PATH ..............................................
@Path("/Product")
public class ProductService {

	//Object
	Product productObj = new Product();
	
	// Read
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)

		public String readProduct() {

			return productObj.readProduct();
		}
		
		// Insert
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertProduct(

				@FormParam("ProdName") String ProdName,
				@FormParam("Category") String Category,
				@FormParam("Price") String Price,
				@FormParam("Researchers") String Researchers,
				@FormParam("Description") String Description) {

			String output = productObj.insertProduct(ProdName, Category, Price, Researchers, Description);
			return output;
		}
		
		
		// Update
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateProduct(String productData) {

			// Convert the input string to a JSON object
			JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject();

			// Read the values from the JSON object
			String ProductID = productObject.get("ProductID").getAsString();
			String ProdName = productObject.get("ProdName").getAsString();
			String Category = productObject.get("Category").getAsString();
			String Price = productObject.get("Price").getAsString();
			String Researchers = productObject.get("Researchers").getAsString();
			String Description = productObject.get("Description").getAsString();
			
			String output = productObj.updateProduct(ProductID, ProdName, Category, Price, Researchers, Description);

			return output;
		}

		
		// Delete
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteProduct(String productData) {

			// Convert the input string to an XML document
			Document doc = Jsoup.parse(productData, "", Parser.xmlParser());

			// Read the value from the element <ProductID>
			String ProductID = doc.select("ProductID").text();
			
			String output = productObj.deleteProduct(ProductID);
			return output;
		}
}
