package stepDefinitions.UI.Wikipedia.WikipediaSearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.wikipedia.WikipediaSearchPage;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.time.Duration;

public class WikipediaSearchStepDef {

    BrowserUtilities browserUtilities = new BrowserUtilities();

    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Given("user clicks Search In")
    public void userClicksSearchIn() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wikipediaSearchPage.searchInBox.click();
    }

    @When("Default is already checked")
    public void defaultIsAlreadyChecked() {
        Assert.assertTrue(wikipediaSearchPage.searchInDefaultTickBox.isSelected());
    }

    @When("user clicks element Default")
    public void userClicksElementDefault() {
        wikipediaSearchPage.searchInDefaultTickBox.click();
    }

    @Then("verify that element Default is unchecked")
    public void verifyThatElementDefaultIsUnchecked() {
        Assert.assertFalse(wikipediaSearchPage.searchInDefaultTickBox.isSelected());
    }

    @When("user clicks element General Help")
    public void userClicksElementGeneralHelp() {
        wikipediaSearchPage.searchInGeneralHelpTickBox.click();
    }

    @Then("verify that element General Help is checked")
    public void verifyThatElementGeneralHelpIsChecked() {
        Assert.assertTrue(wikipediaSearchPage.searchInGeneralHelpTickBox.isSelected());
    }

    @When("verify that element labels Wikipedia, Help are appeared")
    public void verifyThatElementLabelsWikipediaHelpAreAppeared() {
        Assert.assertEquals("Wikipedia", wikipediaSearchPage.widgetWikipedia.getText());
        Assert.assertEquals("Help", wikipediaSearchPage.widgetHelp.getText());
    }

    @Then("verify that element General Help is unchecked")
    public void verifyThatElementGeneralHelpIsUnchecked() {
        Assert.assertFalse(wikipediaSearchPage.searchInGeneralHelpTickBox.isSelected());
    }

    @When("verify all elements are unchecked")
    public void verifyAllElementsAreUnchecked() {
        Assert.assertFalse(wikipediaSearchPage.searchInDefaultTickBox.isSelected());
        Assert.assertFalse(wikipediaSearchPage.searchInDiscussionTickBox.isSelected());
        Assert.assertFalse(wikipediaSearchPage.searchInGeneralHelpTickBox.isSelected());
        Assert.assertFalse(wikipediaSearchPage.searchInAllTickBox.isSelected());
    }

    @When("user clicks element All")
    public void userClicksElementAll() {
        wikipediaSearchPage.searchInAllTickBox.click();
    }

    @Then("verify all elements are checked")
    public void verifyAllElementsAreChecked() {
        Assert.assertTrue(wikipediaSearchPage.searchInDefaultTickBox.isSelected());
        Assert.assertTrue(wikipediaSearchPage.searchInDiscussionTickBox.isSelected());
        Assert.assertTrue(wikipediaSearchPage.searchInGeneralHelpTickBox.isSelected());
        Assert.assertTrue(wikipediaSearchPage.searchInAllTickBox.isSelected());
    }

    @When("verify that element labels Article, Gadget definition talk are appeared")
    public void verifyThatElementLabelsArticleGadgetDefinitionTalkAreAppeared() {
        Assert.assertEquals("(Article)", wikipediaSearchPage.widgetArticle.getText());
        Assert.assertEquals("Gadget definition talk", wikipediaSearchPage.widgetGadgetDefinitionTalk.getText());
    }
}
