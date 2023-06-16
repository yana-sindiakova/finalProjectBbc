package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScoreFixturesSearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='gel-long-primer-bold gs-u-display-block']")
    private List<WebElement> monthsButtons;

    @FindBy(xpath = "//span[contains(@class,'team-name-trunc')]")
    private List<WebElement> teamNames;

    @FindBy(xpath = "//span[contains(@class,'sp-c-fixture__number--ft')]")
    private List<WebElement> teemScores;

    public ScoreFixturesSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTeamNamesButtons() {
        return teamNames;
    }

    public String getFirstTeamName() {
        return teamNames.get(0).getText();
    }

    public String getSecondTeamName() {
        return teamNames.get(1).getText();
    }

    public String getFirstTeamScore() {
        return teemScores.get(0).getText();
    }

    public String getSecondTeamScore() {
        return teemScores.get(1).getText();
    }

    public ScoreFixturesDetailsPage clickOnFirstTeamName() {
        clickWebElement(teamNames.get(0));
        return new ScoreFixturesDetailsPage(driver);
    }

    public ScoreFixturesSearchResultPage selectMonth(String month) {
        for (WebElement button : monthsButtons) {
            if (button.getText().equals(month)) {
                clickWebElement(button);
                break;
            }
        }
        return this;
    }


}
