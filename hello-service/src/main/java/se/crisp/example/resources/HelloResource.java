package se.crisp.example.resources;

import se.crisp.example.core.Greetings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;

    public HelloResource(String template) {
        this.template = template;
    }

    @GET
    public Greetings sayHello(@QueryParam("name") String name) {
        String content = String.format(template, name);
        return new Greetings(content);
    }
}
