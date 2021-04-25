package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Researcher;



@Path("/Researcher")

public class researcherService {

	Researcher Researcher = new Researcher();
	

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String readResearcher() 
	{ 
		return Researcher.readResearcher(); 
	
	}
	
	
	
	
	
	

	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 

	public String insertResearcher(@FormParam("ResearcherName") String ResearcherName, 
						@FormParam("ResearcherAddress") String ResearcherAddress, 
						@FormParam("NIC") String NIC, 
						@FormParam("ResearcherPositiont") String ResearcherPosition,
						@FormParam("description") String description)
						
	{ 
	
		String output = Researcher.insertResearcher(ResearcherName, ResearcherAddress, NIC, ResearcherPosition, description); 
		return output; 
 
	}









	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateResearcher(String itemData)
	{

		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();

		String Researcher_id  = itemObject.get("Researcher_id").getAsString();
		String ResearcherName    = itemObject.get("ResearcherName").getAsString();
		String ResearcherAddress    = itemObject.get("ResearcherAddress").getAsString();
		String NIC   = itemObject.get("NIC").getAsString();
		String ResearcherPosition      = itemObject.get("ResearcherPosition").getAsString();
		String description      = itemObject.get("description").getAsString();
		
	
		String output = Researcher.updateResearcher(Researcher_id, ResearcherName, ResearcherAddress, NIC,ResearcherPosition, description );
		
		return output;
		
		}
			
		










	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteResearcher(String itemData)
	{

		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		String Researcher_id = doc.select("Researcher_id").text();
	
		String output = Researcher.deleteResearcher(Researcher_id);
	
		return output;
	}



}
