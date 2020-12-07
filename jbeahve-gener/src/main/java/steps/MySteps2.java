package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
//import org.springframework.stereotype.Component;

//@Component
public class MySteps2 {

    @Given("test12")
    public void one(){
        System.out.println("One2");
    }

    @When("test22")
    public void two(){
        System.out.println("Two2");
    }

    @Then("test23")
    public void three(){
        System.out.println("Three2");
    }

}
