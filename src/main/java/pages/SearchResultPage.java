package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']/span")
    private List<WebElement> searchResultsHeaders;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsHeaders() {
        return searchResultsHeaders;
    }

    public String getFirstSearchResultHeaderText() {
        return searchResultsHeaders.get(1).getText();
    }
}
