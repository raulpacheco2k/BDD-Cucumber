package Google;

import com.google.PageObjects.GooglePage;
import com.google.PageObjects.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private GooglePage googlePage;
    private GoogleSearchPage googleSearchPage;

    @io.cucumber.java.en.Given("That I'm on the Google homepage")
    public void thatIMOnTheGoogleHomepage() {
        this.googlePage = new GooglePage();
        this.googlePage.beforeEach();
    }

    @When("type {string}")
    public void iTypeGeorgeWBush(String text) {
        this.googlePage.fillSearchInput(text);
    }

    @And("click search")
    public void iClickSearch() {
        this.googleSearchPage = this.googlePage.search();
    }

    @Then("a summary about the president is displayed")
    public void aSummaryAboutTheTermIsDisplayed(
    ) {
        Assert.assertEquals(
                "George Walker Bush, /ˈdʒɔrdʒ ˈwɔːkər ˈbʊʃ/; é um político estadunidense que serviu como o 43.º Presidente dos Estados Unidos, de 2001 a 2009, e como o 46.º Governador do Texas, entre 1995 a 2000. Bush faz parte de uma proeminente família política dos Estados Unidos. É o filho mais velho de George H. W.",
                this.googleSearchPage.getPageDescription()
        );
        this.googleSearchPage.afterEach();
    }
}
