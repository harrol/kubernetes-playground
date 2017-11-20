package org.hello.server.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hi there! The time is: " + getTime()).build();
	}


	private String getTime() {
		return ClientBuilder.newClient()
				.target("http://time-server:8080/time")
				.request()
				.get(String.class);
	}
}