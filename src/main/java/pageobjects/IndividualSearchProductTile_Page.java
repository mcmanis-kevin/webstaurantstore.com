package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static managers.Webdriver_Manager._webdriver;

public class IndividualSearchProductTile_Page extends Webdriver_Library {

    @FindBy(xpath = "(//div[@id='details']/a)[last()]")
    WebElement lastProduct_PageObject = null;

    public IndividualSearchProductTile_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void clickLastProductOnPage() {
        clickElement(lastProduct_PageObject);
    }

}
