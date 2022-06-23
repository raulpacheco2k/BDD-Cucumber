package Google;

import com.google.PageObjects.GooglePage;
import com.google.PageObjects.GoogleSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    private GooglePage googlePage;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void before() {
        this.googlePage = new GooglePage();
        this.googlePage.before();
    }

    @After
    public void after() {
        this.googlePage.after();
    }

    @io.cucumber.java.en.Given("That I'm on the Google homepage")
    public void thatIMOnTheGoogleHomepage() {
    }

    @When("type {string} in the search field")
    public void iTypeGeorgeWBush(String string) {
        this.googlePage.fillSearchInput(string);
    }

    @And("click search")
    public void iClickSearch() {
        this.googleSearchPage = this.googlePage.search();
    }

    @Then("a {string} about the celebrity is displayed")
    public void aSummaryAboutThCelebrityIsDisplayed(String description) {
        Assertions.assertEquals(
                description,
                this.googleSearchPage.getPageDescription()
        );
    }
}
