package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScoresFixturesPage extends BasePage {

    @FindBy(xpath = "//h1[@id='page']")
    private WebElement footballScoreFixturesHeader;

    @FindBy(xpath = "//input[@id='downshift-0-input']")
    private WebElement searchInputField;

    @FindBy(xpath = "//ul[@id='search-results-list']")
    private WebElement searchResultValueButton;

    public ScoresFixturesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFootballScoreFixturesHeader() {
        return footballScoreFixturesHeader;
    }

    public ScoresFixturesPage inputValueToSearchField(String searchValue) {
        searchInputField.sendKeys(searchValue);
        return this;
    }

    public ScoreFixturesSearchResultPage clickOnSearchResultValueButton() {
        clickWebElement(searchResultValueButton);
        return new ScoreFixturesSearchResultPage(driver);
    }
}
