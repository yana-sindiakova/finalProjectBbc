package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballPage extends BasePage {
    @FindBy(xpath = "//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoresFixturesTabButton;

    public FootballPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getScoresFixturesTabButton() {
        return scoresFixturesTabButton;
    }

    public ScoresFixturesPage clickOnScoreFixturesTabButton() {
        clickWebElement(scoresFixturesTabButton);
        return new ScoresFixturesPage(driver);
    }
}
