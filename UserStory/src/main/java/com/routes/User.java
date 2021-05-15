package com.routes;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import com.controller.*;
import com.modal.UserModal;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class User {
	
UserController app = new UserController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user-list")
	public List<UserModal> getUsers()
	{
	
		return app.getUsers();
	}
	
	
	
	@GET
	@Path("user/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModal getBuyer(@PathParam("userID") int userID)
	{
		return app.getUser(userID);
	
	}
//	
//	@POST
//	@Path("/user")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public User createPayment(User u1)
//	{
//		
//		app.createUser(u1);
//		
//		return u1;
//	}
//	
	
	@PUT
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public UserModal updateUser(UserModal b1)
	{
		System.out.println(b1);
		if(app.getUser(b1.getID()).getID()==0) {
			app.createUser(b1);
			
		}
		else
		{
			app.updateUser(b1);
			
		}
		
		return b1;
	}
	
	
	@DELETE
	@Path("user/{bid}")
	public UserModal deleteUser(@PathParam("p=bid") int bid)
	{
		UserModal f = app.getUser(bid);
		
		if(f.getID()!=0)
			app.deleteUser(bid);
		return null;
	}
	
	
}
