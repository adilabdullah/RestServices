package com.java.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test/rest")
public class Restful {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String HelloWorld()
	{
		return "This is adil abdullah ansari";
	}
	
}
