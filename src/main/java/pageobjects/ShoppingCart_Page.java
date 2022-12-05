package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static managers.Webdriver_Manager._webdriver;

public class ShoppingCart_Page extends Webdriver_Library {

    @FindBy(css = ".itemDelete > button")
    WebElement removeItemFromCartButton_PageObject = null;

    @FindBys(
            @FindBy(css = "li[data-cart-item-id]")
    )
    List<WebElement> listOfCartItems_PageObjects = null;

    @FindBy(css = "h1")
    WebElement cartHeader_PageObject = null;

    @FindBy(xpath = "//p[text()='Your cart is empty.']")
    WebElement emptyCartText_PageObject = null;

    public ShoppingCart_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void clickRemoveItemButton() {
        clickElement(removeItemFromCartButton_PageObject);
    }

    public String emptyCartText() {
        return emptyCartText_PageObject.getText();
    }

    public String shoppingCartHeaderText() {
        return cartHeader_PageObject.getText();
    }

}
