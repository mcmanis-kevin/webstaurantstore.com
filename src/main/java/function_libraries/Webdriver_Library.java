package function_libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static managers.Webdriver_Manager._webdriver;

public class Webdriver_Library {

    public void clickElement(WebElement element) {
        isClickable(element).click();
    }

    public void typeElement(WebElement element, String textToType) {
        element.sendKeys(textToType);
    }

    public WebElement isClickable(WebElement element) {
        return new WebDriverWait(_webdriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void isPresent(By by) {
        new WebDriverWait(_webdriver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

}