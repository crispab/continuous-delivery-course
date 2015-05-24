package hello.steps;

import cucumber.api.java.en.Given;

public class SetupSteps {
    private String personName;

    @Given("^a persons name is (\\S+)$")
    public void setPersonName(String name) throws Throwable {
        this.personName = name;
    }

    public String getPersonName() {
        return personName;
    }
}
