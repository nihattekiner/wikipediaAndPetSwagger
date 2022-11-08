package stepDefinitions.UI.Wikipedia;

import io.cucumber.java.en.Given;
import utilities.ConfigurationReader;
import utilities.Driver;

public class WikipediaStepDef {

    @Given("User is on {string}")
    public void userIsOn(String pageURL) {
        pageURL = ConfigurationReader.getProperty("WIKIPEDIA_URL");
        Driver.getDriver().get(pageURL);
    }
}
