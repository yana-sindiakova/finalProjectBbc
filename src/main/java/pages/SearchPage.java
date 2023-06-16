package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchInputField;

    @FindBy(xpath = "//button[@data-testid='test-search-submit']")
    private WebElement searchSubmitButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage inputSearchText(String searchText) {
        searchInputField.sendKeys(searchText);
        return new SearchPage(driver);
    }

    public SearchResultPage clickOnSearchSubmitButton() {
        clickWebElement(searchSubmitButton);
        return new SearchResultPage(driver);
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

}
