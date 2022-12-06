package testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.Cart_Page;
import pageobjects.GlobalHeader_Page;
import pageobjects.Search_Page;

public class SearchFunctionalityTests {

    @Parameters(
            "SearchWord"
    )
    @Test(
            description = "Search for a specific word within the title of the returned search results"
    )
    public void SearchForKeyword_Test(String searchWord) {
        GlobalHeader_Page globalHeader_page = new GlobalHeader_Page();
        globalHeader_page.clickSearchBoxField();
        globalHeader_page.typeIntoSearchBoxField(searchWord);
        globalHeader_page.clickSearchButton();
        Search_Page searchPage = new Search_Page();
        System.out.println("\n");
        System.out.println("!----------------------------------------------------");
        System.out.println("The following do not contain the word table in any form");
        searchPage.selectNextPage();
        System.out.println("\n");
        searchPage.clickAddToCartLastProductOnPage();
        searchPage.selectProductAccessoriesAddToCartButton();
        searchPage.viewShoppingCartPopupButton();
        Cart_Page cartPage = new Cart_Page();
        cartPage.clickEmptyCartButton();
        cartPage.clickEmptyCartPopupButton();
        Assert.assertTrue(cartPage.emptyCartText().equalsIgnoreCase("Your cart is empty."));
    }
}
