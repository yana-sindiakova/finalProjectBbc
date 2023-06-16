package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusStoryPage extends BasePage {
    @FindBy(xpath = "//div[@class='no-mpu']//a[contains(@class, 'gs-u-mt+ nw-o-link-split__anchor')]")
    private WebElement topStoryHeader;

    @FindBy(xpath = "//h3[contains(text(), 'What questions do you have?')]/ancestor::a")
    private WebElement questionAnswersTab;

    public WebElement getTopStoryHeader() {
        return topStoryHeader;
    }

    public WebElement getQuestionAnswersTab() {
        return questionAnswersTab;
    }

    public CoronavirusQuestionPage clickOnQuestionAnswersTab() {
        clickWebElement(questionAnswersTab);
        return new CoronavirusQuestionPage(driver);
    }

    public void scrollToQuestionAnswersTab() {
        scrollToElement(questionAnswersTab);
    }

    public CoronavirusStoryPage(WebDriver driver) {
        super(driver);
    }
}
