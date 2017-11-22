package org.time.server.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Path("/time")
public class TimeEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		int sleep = ThreadLocalRandom.current().nextInt(10, 500);
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = ThreadLocalRandom.current().nextInt(100);
		if(i < 3) {
            throw new IllegalStateException("Boom");
        } else if(i < 8) {
		    return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
			return Response.ok(LocalDateTime.now() + ". The time is brought to you by " + getAddress()).build();
		}
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