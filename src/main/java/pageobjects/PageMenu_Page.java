package pageobjects;

import function_libraries.Webdriver_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static managers.Webdriver_Manager._webdriver;

public class PageMenu_Page extends Webdriver_Library {

    @FindBys(
            @FindBy(xpath = "//div[@id='details']/a[last()]")
    )
    List<WebElement> itemTitle_PageObjects = null;

    @FindBys(
            @FindBy(css = "a[aria-label^=page], a[aria-label^='last'], a[aria-label^='current']")
    )
    List<WebElement> pageCounterButtons_PageObjects = null;

    @FindBy(css = "a[aria-label~='last']")
    WebElement lastPageButton_PageObject = null;

    @CacheLookup
    @FindBy(css = "#paging > nav > ul")
    WebElement pagingContainer_PageObject = null;

    By pagingBy = By.cssSelector("#paging > nav > ul");

    public PageMenu_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    private List<WebElement> get_ItemTitleList() {
        return itemTitle_PageObjects;
    }

    public List<WebElement> get_ReturnItemPages() {
        return pageCounterButtons_PageObjects;
    }

    public void clickLastItemPage() {
        clickElement(lastPageButton_PageObject);
    }

    public void selectNextPage() {
        isPagingContainerDisplayed();
        int lastPageNumber = Integer.parseInt(lastPageButton_PageObject.getText());
        for (int a = 1; a <= lastPageNumber; a++) {
            clickElement(_webdriver.findElement(By.xpath("//a[contains(@aria-label, 'page " + a + "')]")));
            System.out.println("\n");
            System.out.println("!----------------------------------------------------");
            System.out.println("The following do not contain the word table in any form");
            System.out.println("PAGE " + a);
            validateItemTitle("Table");
        }
        System.out.println("\n");
    }

    public void isPagingContainerDisplayed() {
        isPresent(pagingBy);
    }

    public void validateItemTitle(String titleContainsText) {
        for (WebElement singleElement : get_ItemTitleList()) {
            String elementTitle = isClickable(singleElement).getText();
            if (!elementTitle.contains(titleContainsText)) {
                System.out.println("------> [" + elementTitle + "] did not contain " + titleContainsText);
            }
        }
    }

}
