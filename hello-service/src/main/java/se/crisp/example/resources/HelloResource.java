package se.crisp.example.resources;

import se.crisp.example.core.Greetings;

public class HelloResource {
    private String template;

    public HelloResource(String template) {
        this.template = template;
    }

    public Greetings sayHello(String name) {
        String content = String.format(template, name);
        return new Greetings(content);
    }
}
