import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class wishlist_test_oneproduct extends Testbase{

    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    wishlist_page wishlist_pagee;
    String productname="Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void searchbyname() throws InterruptedException {
        productPage=new Product_details_page(driver);
        searchForProductPage=new Search_for_product_page(driver);
        home_page=new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(),productname);
        softAssert.assertEquals(productPage.productname_header_text(),productname);

        softAssert.assertAll();


    }
    @Test(dependsOnMethods = "searchbyname")
    public void check_wishlist()
    {
        productPage=new Product_details_page(driver);
        wishlist_pagee=new wishlist_page(driver);
        productPage.click_add_to_wishlist();
        productPage.click_to_wishlist_page();
        softAssert.assertTrue(wishlist_pagee.productname().contains(productname));
        softAssert.assertAll();

    }
    @Test(dependsOnMethods = "check_wishlist")
    public void check_remove_product()
    {
        wishlist_pagee.click_remove_btn();
        Assert.assertTrue(wishlist_pagee.empty_wishlist().contains("The wishlist is empty!"));
    }
}
