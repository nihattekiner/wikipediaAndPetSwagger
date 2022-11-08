package stepDefinitions.UI.Wikipedia.WikipediaIstanbulSearch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.wikipedia.WikipediaIstanbulPage;
import pages.wikipedia.WikipediaIstanbulSearchResultsPage;
import pages.wikipedia.WikipediaSearchPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class WikipediaIstanbulSearchStepDef {

    BrowserUtilities browserUtilities = new BrowserUtilities();

    WikipediaIstanbulSearchResultsPage wikipediaIstanbulSearchResultsPage = new WikipediaIstanbulSearchResultsPage();
    WikipediaIstanbulPage wikipediaIstanbulPage = new WikipediaIstanbulPage();
    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @And("user search the {string}")
    public void user_search_the(String searchWordIstanbul) {
        wikipediaSearchPage.searchTextBox.sendKeys(searchWordIstanbul + Keys.ENTER);
    }

    @When("verify the title is Istanbul - Search results - Wikipedia")
    public void verifyTheTitleIsIstanbulSearchResultsWikipedia() {
        Assert.assertEquals("Istanbul - Search results - Wikipedia", Driver.getDriver().getTitle());

    }

    @Then("user clicks on the first title about {string}")
    public void userClicksOnTheFirstTitleAbout(String searchWordIstanbul) {
        wikipediaIstanbulSearchResultsPage.istanbulSearchResultsFirstTitle.click();
    }

    @When("verify the title is Istanbul - Wikipedia")
    public void verifyTheTitleIsIstanbulWikipedia() {
        Assert.assertEquals("Istanbul - Wikipedia", Driver.getDriver().getTitle());
    }

    @And("verify that the first heading is {string}")
    public void verifyThatTheFirstHeadingIs(String istanbulPageFirstHeading) {
        Assert.assertEquals("Istanbul", wikipediaIstanbulPage.istanbulPageFirstHeading.getText());
    }

    @Then("verify that all content names and all header names are same")
    public void verifyThatAllContentNamesAndAllHeaderNamesAreSame() {
        for (int i = 0; i < wikipediaIstanbulPage.istanbulPageContentsWE.size(); i++) {
            System.out.println(wikipediaIstanbulPage.istanbulPageContentsWE.get(i).getText());
            System.out.println(wikipediaIstanbulPage.istanbulPageHeadersWE.get(i).getText());
            Assert.assertEquals(wikipediaIstanbulPage.istanbulPageContentsWE.get(i).getText(), wikipediaIstanbulPage.istanbulPageHeadersWE.get(i).getText());
        }
    }
}
