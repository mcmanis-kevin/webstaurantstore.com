package testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.*;

public class SearchFunctionalityTests {

    @Parameters(
            "SearchWord"
    )
    @Test(
            description = "Search for a specific word within the title of the returned search results"
    )
    public void SearchForKeyword_Test(String searchWord) {
        Home_Page home_page = new Home_Page();
        home_page.clickSearchBoxField();
        home_page.typeIntoSearchBoxField(searchWord);
        home_page.clickSearchButton();
        new PageMenu_Page().selectNextPage();
        new IndividualSearchProductTile_Page().clickLastProductOnPage();
        IndividualProductDetails_Page individualItemDetailsPage = new IndividualProductDetails_Page();
        individualItemDetailsPage.clickAddToCartButton();
        individualItemDetailsPage.clickViewCartButton();
        ShoppingCart_Page shoppingCartPage = new ShoppingCart_Page();
        Assert.assertTrue(shoppingCartPage.shoppingCartHeaderText().equalsIgnoreCase("Cart"));
        shoppingCartPage.clickRemoveItemButton();
        Assert.assertTrue(shoppingCartPage.emptyCartText().equalsIgnoreCase("Your cart is empty"));
    }
}
