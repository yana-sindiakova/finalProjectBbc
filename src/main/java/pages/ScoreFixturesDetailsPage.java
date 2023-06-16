package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScoreFixturesDetailsPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'football-oppm-header')]")
    private WebElement detailsHeader;

    @FindBy(xpath = "//div[contains(@class,'football')]//span[contains(@class,'home')]//span[contains(@class,'block@m')]")
    private WebElement homeTeamName;

    @FindBy(xpath = "//div[contains(@class,'football')]//span[contains(@class,'away')]//span[contains(@class,'block@m')]")
    private WebElement awayTeamName;

    @FindBy(xpath = "//div[contains(@class,'football')]//span[contains(@class,'number--home')]")
    private WebElement homeTeamScore;

    @FindBy(xpath = "//div[contains(@class,'football')]//span[contains(@class,'number--away')]")
    private WebElement awayTeamScore;

    public ScoreFixturesDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDetailsHeader() {
        return detailsHeader;
    }

    public String getHomeTeamName() {
        return homeTeamName.getText();
    }

    public String getAwayTeamName() {
        return awayTeamName.getText();
    }

    public String getHomeTeamScore() {
        return homeTeamScore.getText();
    }

    public String getAwayTeamScore() {
        return awayTeamScore.getText();
    }


}
