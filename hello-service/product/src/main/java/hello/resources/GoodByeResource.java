package hello.resources;

import hello.model.Greetings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/goodbye")
@Produces(MediaType.APPLICATION_JSON)
public class GoodByeResource {

    @GET
    public Greetings sayGoodbye(@QueryParam("name") String name) {
        return new Greetings("Goodbye, " + name + "!");
    }
}
