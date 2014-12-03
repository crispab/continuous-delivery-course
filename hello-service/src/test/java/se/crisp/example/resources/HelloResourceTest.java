package se.crisp.example.resources;

import org.junit.Assert;
import org.junit.Test;
import se.crisp.example.core.Greetings;


public class HelloResourceTest {

    @Test
    public void sayHelloToTheGivenName() {
        String template = "Hello %s!";
        HelloResource resource = new HelloResource(template);

        String name = "Joe";
        Greetings greetings = resource.sayHello(name);
        Assert.assertEquals("Hello Joe!", greetings.getContent());
    }
}
