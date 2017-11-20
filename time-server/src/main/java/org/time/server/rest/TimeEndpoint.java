package org.time.server.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@ApplicationScoped
@Path("/time")
public class TimeEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok(LocalDateTime.now() + ". The time is brought to you by " + getAddress()).build();
	}

	private String getAddress() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "unknown";
	}
}