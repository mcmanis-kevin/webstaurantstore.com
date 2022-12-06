# webstaurantstore.com

This is a Maven project utilizing Selenium WebDriver Java and TestNg

## PURPOSE

This is to test the functionality of the search functionality and adding/removal of products from cart

## EXECUTION STEPS

1. Within cmd, git bash, or ide terminal, _cd_ to the root folder of the project
2. Enter the following _Maven Command_ : **_mvn clean compile verify_**  
   **NOTE: Due to demo purposes the profile has been set to always active by default**

## TEST FLOW

> 1. Launch into webstaurantstore.com
>2. Validate correctness of page by header image
>3. Enter _'Stainless Work Table'_ into the search field
>4. Cycle through all the returned pages
>5. During the above, validate that all the titles contain the word **_Table_**
>6. Once on the last page, add the last product to the shopping cart
>7. Navigate to the shopping cart
>8. Remove the product from the shopping cart
>9. Close browser and driver
>
> NOTE: The list of products that do not contain the word table have been sent to the log printout

## INFORMATIONAL

Testcase Name : _SearchFunctionalityTest_  
NOTE: This is set for Chrome browser only

