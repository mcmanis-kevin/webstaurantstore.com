package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Webdriver_Manager {

    public static WebDriver _webdriver;

    public void initializeWebdriverManager() {
        try {
            _webdriver = WebDriverManager
                    .chromedriver()
                    .arch32()
                    .capabilities(chromeOptions())
                    .create();
//            _webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
