package hello.steps;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import org.junit.Assert;

public class GreetingsSteps {
    private final SetupSteps setupSteps;
    private String greetings;

    public GreetingsSteps(SetupSteps setup) {
        this.setupSteps = setup;
    }

    @When("^he says hello$")
    public void sayGreetings() throws Throwable {
        Client client = Client.create();
        String endpoint = System.getProperty("service.endpoint");
        WebResource resource = client.resource(endpoint + "/hello?name=" + this.setupSteps.getPersonName());
        resource.accept("application/json");
        ClientResponse response = resource.get(ClientResponse.class);
        Assert.assertEquals("Unexpected HTTP status code", 200, response.getStatus());

        this.greetings = response.getEntity(String.class);
    }

    @Then("^he gets a greeting back$")
    public void shouldGetAGreeingBack() throws Throwable {
        Assert.assertTrue(this.greetings.contains(this.setupSteps.getPersonName()));
    }
}
