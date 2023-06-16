package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {
    @FindBy(xpath = "//h3[@class= 'gs-c-promo-heading__title gel-canon-bold nw-o-link-split__text']")
    private WebElement mainNewsHeader;

    @FindBy(xpath = "//div[contains(@class, 'nw-c-5-slice')]//h3[contains(@class, 'gs-c-promo-heading')]")
    private List<WebElement> secondaryNewsHeaders;

    @FindBy(xpath = "//div[contains(@class, 'wide-navigation')]//span[text()='War in Ukraine']")
    private WebElement warInUkraineCategoryButton;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//a[contains(@href, 'coronavirus')]")
    private WebElement coronavirusCategoryButton;

    @FindBy(xpath = "//h3[@class= 'gs-c-promo-heading__title gel-canon-bold nw-o-link-split__text']")
    private WebElement categoryHeader;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCategoryHeader() {
        return categoryHeader;
    }

    public WebElement getMainNewsHeader() {
        return mainNewsHeader;
    }

    public String getMainNewsHeaderText() {
        return mainNewsHeader.getText();
    }

    public String getWarInUkraineCategoryText() {
        return warInUkraineCategoryButton.getText();
    }

    public CoronavirusPage clickOnCoronavirusCategoryButton() {
        clickWebElement(coronavirusCategoryButton);
        return new CoronavirusPage(driver);
    }

    public List<WebElement> getSecondaryNewsHeaders() {
        return secondaryNewsHeaders;
    }

    public WebElement getCoronavirusCategoryButton() {
        return coronavirusCategoryButton;
    }
}
