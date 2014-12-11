package se.crisp.example;

import com.sun.jersey.api.core.ResourceConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.crisp.example.resources.HelloResource;

public class HelloApplication extends Application<HelloConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {

    }

    @Override
    public void run(HelloConfiguration configuration, Environment environment) throws Exception {
        HelloResource resource = new HelloResource(configuration.getTemplate());
        environment.jersey().disable(ResourceConfig.FEATURE_DISABLE_WADL);
        environment.jersey().register(resource);
    }
}