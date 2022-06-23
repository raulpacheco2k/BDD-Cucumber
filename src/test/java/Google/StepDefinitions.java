package Google;

import com.google.PageObjects.GooglePage;
import com.google.PageObjects.GoogleSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private GooglePage googlePage;
    private GoogleSearchPage googleSearchPage;

    @Before
    public void before() {
        this.googlePage.beforeEach();
    }

    @After
    public void after() {
        this.googlePage.afterEach();
    }

    @io.cucumber.java.en.Given("That I'm on the Google homepage")
    public void thatIMOnTheGoogleHomepage() {
        this.googlePage = new GooglePage();
    }

    @When("type {string} in the search field")
    public void iTypeGeorgeWBush(String string) {
        this.googlePage.fillSearchInput(string);
    }

    @And("click search")
    public void iClickSearch() {
        this.googleSearchPage = this.googlePage.search();
    }

    @Then("a {string} about the president is displayed")
    public void aSummaryAboutTheTermIsDisplayed(String description) {
        Assert.assertEquals(
                description,
                this.googleSearchPage.getPageDescription()
        );
        this.googleSearchPage.afterEach();
    }
}
