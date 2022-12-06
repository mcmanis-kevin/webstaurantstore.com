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

public class Search_Page extends Webdriver_Library {

    @FindBys(
            @FindBy(xpath = "//div[@id='details']/a[last()]")
    )
    List<WebElement> itemTitle_PageObjects = null;

    @FindBy(css = "a[aria-label~='last']")
    WebElement lastPageButton_PageObject = null;

    @CacheLookup
    @FindBy(xpath = "(//div[@Class='add-to-cart'])[last()]/form/*/*/input[last()]")
    WebElement lastProductAddToCartButton_PageObject = null;

    @FindBy(xpath = "//div[@Class='ReactModalPortal']//button[text()='Add To Cart']")
    WebElement productAccessoriesAddToCartButton_PageObject = null;

    @FindBy(xpath = "//a[text()='View Cart']")
    WebElement viewCartPopupButton_PageObject = null;

    By pagingBy = By.cssSelector("#paging > nav > ul");

    public Search_Page() {
        PageFactory.initElements(_webdriver, this);
    }

    public void clickAddToCartLastProductOnPage() {
        clickElement(lastProductAddToCartButton_PageObject);
    }

    private List<WebElement> get_ItemTitleList() {
        return itemTitle_PageObjects;
    }

    public void selectNextPage() {
        isPagingContainerDisplayed();
        int lastPageNumber = Integer.parseInt(lastPageButton_PageObject.getText());
        for (int a = 1; a <= lastPageNumber; a++) {
            System.out.println("PAGE " + a);
            clickElement(_webdriver.findElement(By.xpath("//a[contains(@aria-label, 'page " + a + "')]")));
            validateItemTitle("Table");
        }
    }

    private void isPagingContainerDisplayed() {
        isPresent(pagingBy);
    }

    private void validateItemTitle(String titleContainsText) {
        for (WebElement singleElement : get_ItemTitleList()) {
            String elementTitle = isClickable(singleElement).getText();
            if (!elementTitle.contains(titleContainsText)) {
                System.out.println("------> [" + elementTitle + "] did not contain " + titleContainsText);
            }
        }
    }

    public void selectProductAccessoriesAddToCartButton() {
        clickElement(productAccessoriesAddToCartButton_PageObject);
    }

    public void viewShoppingCartPopupButton() {
        clickElement(viewCartPopupButton_PageObject);
    }

}
