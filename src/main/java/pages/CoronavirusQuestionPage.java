package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusQuestionPage extends BasePage {
    @FindBy(xpath = "//h1[@id='main-heading']")
    private WebElement questionAnswersPageHeader;

    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement popupCloseButton;

    @FindBy(xpath = "//div[@class='hearken-embed cleanslate']")
    private WebElement questionForm;

    @FindBy(xpath = "//textarea[@class='text-input--long']")
    private WebElement questionInputField;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement acceptedCheckbox;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message' and contains(.,'Email')]")
    private WebElement emptyEmailFieldError;

    @FindBy(xpath = "//div[@class='input-error-message' and contains(.,'Name')]")
    private WebElement emptyNameFieldError;

    @FindBy(xpath = "//div[@class='input-error-message' and contains(.,' must be accepted')]")
    private WebElement unSelectedAcceptedCheckBoxError;

    public CoronavirusQuestionPage(WebDriver driver) {
        super(driver);
    }

    public Form scrollToQuestionForm() {
        scrollToElement(questionForm);
        return new Form(driver);
    }

    public CoronavirusQuestionPage clickOnPopUpCloseButton() {
        clickWebElement(popupCloseButton);
        return this;
    }

    public CoronavirusQuestionPage inputQuestionText(String questionText) {
        questionInputField.sendKeys(questionText);
        return this;
    }

    public WebElement getQuestionAnswersPageHeader() {
        return questionAnswersPageHeader;
    }

    public CoronavirusQuestionPage inputNameText(String nameText) {
        nameInputField.sendKeys(nameText);
        return this;
    }

    public CoronavirusQuestionPage inputEmailText(String emailText) {
        emailInputField.sendKeys(emailText);
        return this;
    }

    public CoronavirusQuestionPage selectAcceptCheckBox() {
        clickWebElement(acceptedCheckbox);
        return this;
    }

    public WebElement getEmptyEmailFieldError() {
        return emptyEmailFieldError;
    }

    public WebElement getEmptyNameFieldError() {
        return emptyNameFieldError;
    }

    public WebElement getUnSelectedAcceptedCheckBoxError() {
        return unSelectedAcceptedCheckBoxError;
    }

    public String getEmptyEmailFieldErrorText() {
        return emptyEmailFieldError.getText();
    }

    public String getEmptyNameFieldErrorText() {
        return emptyNameFieldError.getText();
    }

    public String getUnSelectedAcceptedCheckBoxErrorText() {
        return unSelectedAcceptedCheckBoxError.getText();
    }

    public CoronavirusQuestionPage clickOnSubmitButton() {
        clickWebElement(submitButton);
        return this;
    }

    public CoronavirusQuestionPage inputTextToQuestionInputField(String question) {
        questionInputField.sendKeys(question);
        return this;
    }

}
