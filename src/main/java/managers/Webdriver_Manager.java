package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Webdriver_Manager {

    public static WebDriver _webdriver;

    public void initializeWebdriverManager() {
        try {
            _webdriver = WebDriverManager
                    .chromedriver()
                    .arch32()
                    .capabilities(chromeOptions())
                    .create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions opts = new ChromeOptions();
        opts.setAcceptInsecureCerts(true);
        opts.addArguments("--ignore-zoom-level");
        opts.addArguments("--start-maximized");
        opts.addArguments("--incognito");
        return opts;
    }

}
