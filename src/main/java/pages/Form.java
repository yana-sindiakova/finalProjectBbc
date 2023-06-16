package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Dictionary;
import java.util.Enumeration;

public class Form extends BasePage {
    public Form(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Dictionary<String, String> dictionary) {
        Enumeration<String> keys = dictionary.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = dictionary.get(key);
            String inputFieldXpath = "//input[@aria-label='" + key + "']";
            WebElement inputField = driver.findElement(By.xpath(inputFieldXpath));
            inputField.sendKeys(value);
        }
    }
}


