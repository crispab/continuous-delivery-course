package hello;


import io.dropwizard.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HelloApplicationTest {

    @Test
    @Category(FastTests.class)
    public void serviceShouldBeNamed() {
        Application application = new HelloApplication();
        Assert.assertEquals("hello", application.getName());
    }
}
