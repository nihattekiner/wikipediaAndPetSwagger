package pages.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WikipediaSearchPage {

    public WikipediaSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ooui-php-1")
    public WebElement searchTextBox;

    @FindBy(id = "firstHeading")
    public WebElement firstTitle;

    @FindBy(xpath = "(//span[@class='mw-advancedSearch-expandablePane-button oo-ui-widget oo-ui-widget-enabled oo-ui-buttonElement oo-ui-buttonElement-framed oo-ui-indicatorElement oo-ui-labelElement oo-ui-buttonWidget'])[2]")
    public WebElement searchInBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement searchInDefaultTickBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement searchInDiscussionTickBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement searchInGeneralHelpTickBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement searchInAllTickBox;

    @FindBy(xpath = "(//span[@class='oo-ui-labelElement-label'])[29]")
    public WebElement widgetWikipedia;

    @FindBy(xpath = "(//span[@class='oo-ui-labelElement-label'])[31]")
    public WebElement widgetHelp;

    @FindBy(xpath = "(//span[@class='oo-ui-labelElement-label'])[29]")
    public WebElement widgetArticle;

    @FindBy(xpath = "(//span[@class='oo-ui-labelElement-label'])[83]")
    public WebElement widgetGadgetDefinitionTalk;
}
