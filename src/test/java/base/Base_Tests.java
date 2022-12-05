package base;

import managers.Webdriver_Manager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobjects.Home_Page;

import static managers.Webdriver_Manager._webdriver;

public class Base_Tests {

    @BeforeTest(
            description = "Initialize the webdriver regardless of browser version"
    )
    public void initWebdriver() {
        new Webdriver_Manager().initializeWebdriverManager();
    }

    @BeforeTest(
            description = "Navigate to the url given"
            , dependsOnMethods = "initWebdriver"
    )
    public void navigateToUrl() {
        _webdriver.get("https://www.webstaurantstore.com/");
        new Home_Page().checkIsDisplayedWebstaurantLogo();
    }

    @AfterTest(
            description = "Quit the webdriver if still active"
    )
    public void tearDown() {
        if (_webdriver != null)
            _webdriver.quit();
    }

}
