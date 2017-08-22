package sample.hateoas.test.acceptance.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import sample.hateoas.test.acceptance.ScenarioContext;
import sample.hateoas.test.acceptance.StepsDefinition;
import sample.hateoas.domain.CustomerRepository;
import sample.hateoas.test.acceptance.domain.Customer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@StepsDefinition
public class CustomerSteps {

    @Autowired
    private ScenarioContext context;

    @Autowired
    CustomerRepository repository;

    @When("^searching for all customers$")
    public void fetchingAllCustomers() throws Throwable {
        context.customers = repository.findAll();
    }

    @Then("^the following customers should be returned:$")
    public void theFollowingCustomersShouldBePresent(List<Customer> customers) throws Throwable {
        for (Customer customer : customers) {
            sample.hateoas.domain.Customer one = repository.findOne(customer.id);
            assertThat(one.getId()).isEqualTo(customer.id);
            assertThat(one.getFirstName()).isEqualTo(customer.firstName);
            assertThat(one.getLastName()).isEqualTo(customer.lastName);
        }
    }
}
