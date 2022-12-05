package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.Webdriver_Manager._webdriver;

public class Home_Page extends Webdriver_Library {

    @CacheLookup
    @FindBy(css = "svg[aria-label='Webstaurantstore Logo']")
    WebElement webstaurantstoreLogo_PageObject = null;

    @CacheLookup
    @FindBy(id = "searchval")
    WebElement searchField_PageObject = null;

    @CacheLookup
    @FindBy(css = "button[Value='Search']")
    WebElement searchButton_PageObject = null;

    public Home_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void checkIsDisplayedWebstaurantLogo() {
        webstaurantstoreLogo_PageObject.isDisplayed();
    }

    public void clickSearchBoxField() {
        clickElement(searchField_PageObject);
    }

    public void typeIntoSearchBoxField(String searchWord) {
        typeElement(searchField_PageObject, searchWord);
    }

    public void clickSearchButton() {
        clickElement(searchButton_PageObject);
    }

}
