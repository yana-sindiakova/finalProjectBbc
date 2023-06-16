package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'PrimaryNav')]//a[contains(@href, 'football')]")
    private WebElement footballTabButton;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public FootballPage clickOnFootballTabButton() {
        clickWebElement(footballTabButton);
        return new FootballPage(driver);
    }
}
