package sample.hateoas.test.acceptance;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("cucumber-glue")
public class ScenarioContext {
    public List<sample.hateoas.domain.Customer> customers;
}
