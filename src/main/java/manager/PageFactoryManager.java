package manager;

import org.openqa.selenium.WebDriver;
import pages.*;


public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(driver);
    }

    public SportPage getSportPage (){
        return new SportPage(driver);
    }

    public FootballPage getFootballPage(){
        return new FootballPage(driver);
    }

    public ScoresFixturesPage getScoresFixturesPage(){
        return new ScoresFixturesPage(driver);
    }

    public ScoreFixturesSearchResultPage getScoreFixturesSearchResultPage (){
        return new ScoreFixturesSearchResultPage(driver);
    }

    public ScoreFixturesDetailsPage getScoreFixturesDetailsPage(){
        return new ScoreFixturesDetailsPage(driver);
    }

    public CoronavirusQuestionPage getCoronavirusQuestionPage() {
        return new CoronavirusQuestionPage(driver);
    }

    public CoronavirusStoryPage getCoronavirusStoryPage() {
        return new CoronavirusStoryPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public Form getForm() {
        return new Form(driver);
    }
}
