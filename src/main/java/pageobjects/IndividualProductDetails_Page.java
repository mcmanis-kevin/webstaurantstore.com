package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.Webdriver_Manager._webdriver;

public class IndividualProductDetails_Page extends Webdriver_Library {

    @CacheLookup
    @FindBy(id = "buyButton")
    WebElement addToCartButton_PageObject = null;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(), 'View Cart')]")
    WebElement viewCartButton_PageObject = null;

    public IndividualProductDetails_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void clickAddToCartButton() {
        clickElement(addToCartButton_PageObject);
    }

    public void clickViewCartButton() {
        clickElement(viewCartButton_PageObject);
    }

}
