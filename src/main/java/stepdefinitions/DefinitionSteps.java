package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    final long DEFAULT_TIME_TO_WAIT = 30;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    CoronavirusPage coronavirusPage;
    CoronavirusQuestionPage coronavirusQuestionPage;
    CoronavirusStoryPage coronavirusStoryPage;
    HomePage homePage;
    NewsPage newsPage;
    SearchPage searchPage;
    Form form;
    SearchResultPage searchResultPage;
    SportPage sportPage;
    FootballPage footballPage;
    ScoresFixturesPage scoresFixturesPage;
    ScoreFixturesSearchResultPage scoreFixturesSearchResultPage;
    ScoreFixturesDetailsPage scoreFixturesDetailsPage;
    private Map<String, String> variables = new HashMap<>();

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @And("User opens {string} page")
    public void userOpensPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User goes to News Page")
    public void userGoesToNewsPage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        homePage.clickOnNewsButton();
    }

    @And("User checks main news {string} title")
    public void userChecksMainNewsTitle(final String expectedTitle) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        newsPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, newsPage.getMainNewsHeader());
        String actualMainNewsTitle = newsPage.getMainNewsHeaderText();
        assertEquals(expectedTitle, actualMainNewsTitle);
    }

    @And("User checks secondary news titles")
    public void userChecksSecondaryNewsNames(DataTable table) {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        newsPage.waitVisibilityOfElements(DEFAULT_TIME_TO_WAIT, newsPage.getSecondaryNewsHeaders());
        List<String> expectedTitles = table.asList();
        System.out.println(expectedTitles);
        List<WebElement> secondaryNewsHeaders = newsPage.getSecondaryNewsHeaders();
        for (int i = 0; i < secondaryNewsHeaders.size(); i++) {
            assertEquals(expectedTitles.get(i), secondaryNewsHeaders.get(i).getText());
        }
    }

    @And("User get Category name")
    public void userGetsCategoryName() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        String warInUkraineCategoryText = newsPage.getWarInUkraineCategoryText();
        variables.put("categoryName", warInUkraineCategoryText);
    }

    @And("User goes to Search page")
    public void userGoesToSearchPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickSearchButton();
    }

    @And("User search by category name")
    public void userSearchByCategoryName() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, searchPage.getSearchInputField());
        searchPage.inputSearchText(variables.get("categoryName"));
        searchPage.clickOnSearchSubmitButton();
    }

    @And("User checks that search results contains category value")
    public void userChecksSearchResultText() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        searchResultPage.waitVisibilityOfElements(DEFAULT_TIME_TO_WAIT, searchResultPage.getSearchResultsHeaders());
        String searchResultText = searchResultPage.getFirstSearchResultHeaderText();
        assertTrue(searchResultText.contains(variables.get("categoryName")));
    }

    @And("User goes to Coronavirus page")
    public void userGoesToCoronavirusPage() {
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        newsPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, newsPage.getCoronavirusCategoryButton());
        newsPage.clickOnCoronavirusCategoryButton();
    }

    @And("User goes to Coronavirus Story page")
    public void userGoesToCoronavirusStoryPage() {
        coronavirusPage = pageFactoryManager.getCoronavirusPage();
        coronavirusPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        coronavirusPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusPage.getYourCoronavirusStoryTab());
        coronavirusPage.clickOnYourCoronavirusTab();
    }

    @And("User goes to Coronavirus Question page")
    public void userGoesToCoronavirusQuestionPage() {
        coronavirusStoryPage = pageFactoryManager.getCoronavirusStoryPage();
        coronavirusStoryPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        coronavirusStoryPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusStoryPage.getTopStoryHeader());
        coronavirusStoryPage.scrollToQuestionAnswersTab();
        coronavirusStoryPage.clickOnQuestionAnswersTab();
    }

    @And("User goes to Question Form")
    public void userGoesToQuestionFormTab() {
        coronavirusQuestionPage = pageFactoryManager.getCoronavirusQuestionPage();
        coronavirusQuestionPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        coronavirusQuestionPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusQuestionPage.getQuestionAnswersPageHeader());
        coronavirusQuestionPage.clickOnPopUpCloseButton();
        coronavirusQuestionPage.scrollToQuestionForm();
    }

    @And("User fills coronavirus question form")
    public void userFillCoronavirusQuestionForm(DataTable table) {
        form = pageFactoryManager.getForm();
        Dictionary<String, String> values = new Hashtable<>(table.asMap());
        form.fillForm(values);
    }

    @And("User fills question field")
    public void userFillQuestionField(DataTable table) {
        coronavirusQuestionPage.inputQuestionText(table.toString().replace("|", ""));
    }

    @And("User selects Accepted checkbox")
    public void userSelectsAcceptedCheckbox() {
        coronavirusQuestionPage.selectAcceptCheckBox();
    }

    @And("User submit coronavirus question form")
    public void userSubmitCoronavirusQuestionForm() {
        coronavirusQuestionPage.clickOnSubmitButton();
    }

    @And("User checks empty email error message {string}")
    public void userChecksEmptyEmailError(String expectedMessage) {
        coronavirusQuestionPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusQuestionPage.getEmptyEmailFieldError());
        String actualMessage = coronavirusQuestionPage.getEmptyEmailFieldErrorText();
        assertEquals(expectedMessage, actualMessage);
    }

    @And("User checks empty name error message {string}")
    public void userChecksEmptyNameError(String expectedMessage) {
        coronavirusQuestionPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusQuestionPage.getEmptyNameFieldError());
        String actualMessage = coronavirusQuestionPage.getEmptyNameFieldErrorText();
        assertEquals(expectedMessage, actualMessage);
    }

    @And("User checks unselected checkbox error message {string}")
    public void userChecksUnSelectedAcceptedCheckboxError(String expectedMessage) {
        coronavirusQuestionPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, coronavirusQuestionPage.getUnSelectedAcceptedCheckBoxError());
        String actualMessage = coronavirusQuestionPage.getUnSelectedAcceptedCheckBoxErrorText();
        assertEquals(expectedMessage, actualMessage);
    }

    @And("User goes to Sport Page")
    public void userGoesToSportPage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        homePage.clickOnSportButton();
    }

    @And("User goes to Football Page")
    public void userGoesToFootballPage() {
        sportPage = pageFactoryManager.getSportPage();
        sportPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        sportPage.clickOnFootballTabButton();
    }

    @And("User goes to Scores & Fixtures Page")
    public void userGoesToScoresFixturesPage() {
        footballPage = pageFactoryManager.getFootballPage();
        footballPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        footballPage.clickOnScoreFixturesTabButton();
    }

    @And("User search by championship {string}")
    public void userSearchByChampionshipChampionship(final String searchValue) {
        scoresFixturesPage = pageFactoryManager.getScoresFixturesPage();
        scoresFixturesPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        scoresFixturesPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, scoresFixturesPage.getFootballScoreFixturesHeader());
        scoresFixturesPage.inputValueToSearchField(searchValue);
        scoresFixturesPage.clickOnSearchResultValueButton();
    }

    @And("User selects month {string}")
    public void userSelectsMonthMonth(final String month) {
        scoreFixturesSearchResultPage = pageFactoryManager.getScoreFixturesSearchResultPage();
        scoreFixturesSearchResultPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        scoreFixturesSearchResultPage.selectMonth(month);
    }


    @And("User checks that two specific teams {string}, {string} played with a specific score {string}, {string}")
    public void userChecksThatTwoTeamsPlayedWithASpecificScore(final String homeTeamName, final String awayTeamName, final String homeTeamScore, final String awayTeamScore) {
        scoreFixturesSearchResultPage.waitVisibilityOfElements(DEFAULT_TIME_TO_WAIT, scoreFixturesSearchResultPage.getTeamNamesButtons());
        assertEquals(homeTeamName, scoreFixturesSearchResultPage.getFirstTeamName());
        assertEquals(awayTeamName, scoreFixturesSearchResultPage.getSecondTeamName());
        assertEquals(homeTeamScore, scoreFixturesSearchResultPage.getFirstTeamScore());
        assertEquals(awayTeamScore, scoreFixturesSearchResultPage.getSecondTeamScore());
    }

    @And("User goes to Score details page")
    public void userClicksOnOfTheHomeTeamNames() {
        scoreFixturesSearchResultPage.clickOnFirstTeamName();
    }

    @And("User checks that teams {string}, {string} played with a specific score {string}, {string}")
    public void userChecksThatTeamsPlayedWithASpecificScore(final String homeTeamName, final String awayTeamName, final String homeTeamScore, final String awayTeamScore) {
        scoreFixturesDetailsPage = pageFactoryManager.getScoreFixturesDetailsPage();
        scoreFixturesDetailsPage.waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        scoreFixturesDetailsPage.waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, scoreFixturesDetailsPage.getDetailsHeader());
        assertEquals(homeTeamName, scoreFixturesDetailsPage.getHomeTeamName());
        assertEquals(awayTeamName, scoreFixturesDetailsPage.getAwayTeamName());
        assertEquals(homeTeamScore, scoreFixturesDetailsPage.getHomeTeamScore());
        assertEquals(awayTeamScore, scoreFixturesDetailsPage.getAwayTeamScore());
    }
}
