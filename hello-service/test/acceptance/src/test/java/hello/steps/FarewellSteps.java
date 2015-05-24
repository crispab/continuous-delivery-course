package hello.steps;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FarewellSteps {
    private final SetupSteps setupSteps;
    private String goodbye;

    public FarewellSteps(SetupSteps setupSteps) {
        this.setupSteps = setupSteps;
    }

    @When("^she says goodbye$")
    public void sayGoodbye() throws Throwable {
        Client client = Client.create();
        String endpoint = System.getProperty("service.endpoint");
        WebResource resource = client.resource(endpoint + "/goodbye?name=" + setupSteps.getPersonName());
        resource.accept("application/json");
        ClientResponse response = resource.get(ClientResponse.class);
        Assert.assertEquals("Unexpected HTTP status code", 200, response.getStatus());

        this.goodbye = response.getEntity(String.class);
    }

    @Then("^she gets goodbye back$")
    public void shouldGetAGoodbyeBack() throws Throwable {
        Assert.assertTrue(this.goodbye.contains(setupSteps.getPersonName()));
    }
}
