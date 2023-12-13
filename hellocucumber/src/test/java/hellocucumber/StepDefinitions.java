package hellocucumber;


import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {

    String today = "lundi";
    String answer = "Amongus";

    @Given("on est {string}")
    public void todayIs(String day) {
        this.today = day;
    }

    @When("on demande si on est vendredi")
    public void askIfItsVendredi() {
        this.answer = RunCucumberTest.isItFriday(this.today);
    }

    @Then("répondre {string}")
    public void answer(String message) {
        assertEquals(message, answer);
    }

}