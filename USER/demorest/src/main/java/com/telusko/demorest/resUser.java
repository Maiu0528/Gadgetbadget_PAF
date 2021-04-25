package com.telusko.demorest;

import com.controller.cntUser;
import com.java.User;

import java.util.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/User")
public class resUser {

	cntUser app = new cntUser();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("User")
	public List<User> getUsers()
	{
		System.out.println("Users called...");
		return app.GetUsers();
	}
	
	@GET
	@Path("User/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("Id") int Id)
	{
		return app.GetUser(Id);
	
	}
	
	@POST
	@Path("/User")
	@Consumes(MediaType.APPLICATION_JSON)
	public User createPayment(User p1)
	{
		System.out.println(p1);
		app.CreateUser(p1);
		
		return p1;
	}
	
	@PUT
	@Path("/User")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updatePayment(User p1)
	{
		System.out.println(p1);
		if(app.GetUser(p1.getId()).getId()==0) {
			app.CreateUser(p1);
			
		}
		else
		{
			app.UpdateUser(p1);
			
		}
		
		return p1;
	}
	
	@DELETE
	@Path("User/{Id}")
	public User deletePatient(@PathParam("Id") int id)
	{
		User p = app.GetUser(id);
		
		if(p.getId()!=0)
			app.DeleteUser(id);
		return null;
	}
}
