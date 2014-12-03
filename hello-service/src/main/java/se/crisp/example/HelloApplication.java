package se.crisp.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    public void run(HelloConfiguration helloConfiguration, Environment environment) throws Exception {

    }
}
