package dojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import static org.junit.Assert.assertEquals;


public class CocktailSteps {

    private Order order;

    @Given("{string} who wants to buy a drink")
    public void todayIs(String nom) {
        order = new Order();
        order.declareOwner(nom);
    }

    @When("an order is declared for {string}")
    public void askIfItsVendredi(String nom) {
        order.declareTarget(nom);
    }

    @Then("there is no cocktail in the order")
    public void answer() {
        List<String> cocktails =  order.getCocktails();
        assertEquals(0, cocktails.size());
    }

}