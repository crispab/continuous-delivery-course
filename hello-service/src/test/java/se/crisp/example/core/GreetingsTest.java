package se.crisp.example.core;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.FixtureHelpers;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.skyscreamer.jsonassert.JSONAssert;
import se.crisp.example.SlowTests;

import java.io.IOException;

public class GreetingsTest {
    @Test
    @Category(SlowTests.class)
    public void shouldBeSerializableFromJSON() throws IOException, JSONException {
        final Greetings greetings = new Greetings("Hello");
        String serializedGreetings = Jackson.newObjectMapper().writeValueAsString(greetings);
        String fixture = FixtureHelpers.fixture("fixtures/greetings.json");

        JSONAssert.assertEquals(fixture, serializedGreetings, false);
    }

    @Test
    @Category(SlowTests.class)
    public void shouldBeDeserializableToJSON() throws IOException, JSONException {
        final Greetings expectedGreetings = new Greetings("Hello");
        String fixture = FixtureHelpers.fixture("fixtures/greetings.json");

        Greetings actualGreetings = Jackson.newObjectMapper().readValue(fixture, Greetings.class);
        Assert.assertEquals(expectedGreetings, actualGreetings);
    }
}
