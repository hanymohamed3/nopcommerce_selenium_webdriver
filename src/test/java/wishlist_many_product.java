import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class wishlist_many_product extends Testbase {
    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    wishlist_page wishlist_pagee;
    String productname="Apple MacBook Pro 13-inch";
    String product_name_2="Samsung Series 9 NP900X4C Premium Ultrabook";

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
    public void check_wishlist_1()
    {
        productPage=new Product_details_page(driver);
        wishlist_pagee=new wishlist_page(driver);
        productPage.click_add_to_wishlist();
        productPage.click_to_wishlist_page();
        softAssert.assertTrue(wishlist_pagee.productname().contains(productname));
        softAssert.assertAll();

    }
    @Test(dependsOnMethods = "check_wishlist_1")
    public void searchbyname_2() throws InterruptedException {
        productPage=new Product_details_page(driver);
        searchForProductPage=new Search_for_product_page(driver);
        home_page=new Home_page(driver);
        home_page.write_in_searchbar(product_name_2);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(),product_name_2);
        softAssert.assertEquals(productPage.productname_header_text(),product_name_2);

        softAssert.assertAll();
        Thread.sleep(3000);


    }
    @Test(dependsOnMethods = "searchbyname_2")
    public void check_wishlist() throws InterruptedException {
        productPage=new Product_details_page(driver);
        wishlist_pagee=new wishlist_page(driver);
        productPage.click_add_to_wishlist_2();
        productPage.click_to_wishlist_page();
        Thread.sleep(3000);
        softAssert.assertTrue(wishlist_pagee.find_product_in_table(product_name_2),"a7aaaa");
        softAssert.assertAll();


    }
    @Test(dependsOnMethods = "check_wishlist")
    public void check_remove_product()
    {
        wishlist_pagee.click_remove_btn();
        Assert.assertFalse(wishlist_pagee.find_product_in_table(productname));
    }
}
