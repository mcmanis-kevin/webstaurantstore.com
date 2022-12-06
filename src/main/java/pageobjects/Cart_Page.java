package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.Webdriver_Manager._webdriver;

public class Cart_Page extends Webdriver_Library {

    @CacheLookup
    @FindBy(css = "div[data-hypernova-key='EmptyCart'] > button")
    WebElement emptyCartButton_PageObject = null;

    @CacheLookup
    @FindBy(xpath = "//p[text()='Your cart is empty.']")
    WebElement emptyCartText_PageObject = null;

    @CacheLookup
    @FindBy(xpath = "//footer/button[text()='Empty']")
    WebElement emptyCartPopupButton_PageObject = null;

    @FindBy(xpath = "//div[@Class='cartEmpty']//a[text()='Continue Shopping']")
    WebElement emptyCartContinueShoppingButton = null;

    public Cart_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void clickEmptyCartButton() {
        clickElement(emptyCartButton_PageObject);
    }

    public String emptyCartText() {
        isClickable(emptyCartContinueShoppingButton);
        return emptyCartText_PageObject.getText();
    }

    public void clickEmptyCartPopupButton() {
        clickElement(emptyCartPopupButton_PageObject);
    }

}
