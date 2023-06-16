package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {
    @FindBy(xpath = "//li[contains(@class, 'nw-c-nav__secondary-menuitem-container')]")
    private WebElement yourCoronavirusStoryTab;

    public WebElement getYourCoronavirusStoryTab() {
        return yourCoronavirusStoryTab;
    }

    public CoronavirusStoryPage clickOnYourCoronavirusTab() {
        clickWebElement(yourCoronavirusStoryTab);
        return new CoronavirusStoryPage(driver);
    }

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }
}
