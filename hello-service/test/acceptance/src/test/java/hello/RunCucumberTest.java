package hello;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (glue = "hello.steps", features = "classpath:features")
public class RunCucumberTest {
}
