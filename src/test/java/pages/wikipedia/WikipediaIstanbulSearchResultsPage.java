package pages.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WikipediaIstanbulSearchResultsPage {

    public WikipediaIstanbulSearchResultsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@title='Istanbul'])[2]")
    public WebElement istanbulSearchResultsFirstTitle;
}
