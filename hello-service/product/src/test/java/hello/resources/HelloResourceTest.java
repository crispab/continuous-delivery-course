package hello.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import hello.SlowTests;
import hello.model.Greetings;


public class HelloResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloResource("Hello %s!")).build();

    @Test
    @Category(SlowTests.class)
    public void sayHelloToTheGivenName() {
        String template = "Hello %s!";
        HelloResource resource = new HelloResource(template);

        String name = "Joe";
        Greetings greetings = resource.sayHello(name);
        Assert.assertEquals("Hello Joe!", greetings.getContent());
    }

    @Test
    @Category(SlowTests.class)
    public void sayHelloViaTheResource() {
        Client client = resources.client();
        WebResource resource = client.resource("/hello?name=Joe");
        Greetings actualGreetings = resource.get(Greetings.class);

        Greetings expectedGreetings = new Greetings("Hello Joe!");
        Assert.assertEquals(expectedGreetings, actualGreetings);
    }
}
