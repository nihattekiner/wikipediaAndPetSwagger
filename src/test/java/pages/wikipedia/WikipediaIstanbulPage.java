package pages.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WikipediaIstanbulPage {

    public WikipediaIstanbulPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstHeading")
    public WebElement istanbulPageFirstHeading;

    @FindBy(xpath = "//span[@class='toctext']")
    public List<WebElement> istanbulPageContentsWE;

    @FindBy(xpath = "//span[@class='mw-headline']")
    public List<WebElement> istanbulPageHeadersWE;
}
