package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//nav[contains(@class, 'header-links international')]//a[contains(@href, 'news')]")
    private WebElement newsButton;

    @FindBy(xpath = "//nav[contains(@class, 'header-links international')]//a[contains(@href, 'sport')]")
    private WebElement sportButton;

    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public NewsPage clickOnNewsButton() {
        clickWebElement(newsButton);
        return new NewsPage(driver);
    }

    public SportPage clickOnSportButton (){
        clickWebElement(sportButton);
        return new SportPage(driver);
    }

    public SearchPage clickSearchButton() {
        clickWebElement(searchButton);
        return new SearchPage(driver);
    }
}
