package com.example.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tomitribe.sabot.Config;

@Path("/")
public class HelloWorldResource {

	@Inject
	@Config("name")
	private String env;
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello World !!! Environment : "+env;
	}
	
}
