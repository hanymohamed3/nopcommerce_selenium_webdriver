import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class add_to_cart_tests extends Testbase{

    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    shopping_cart_page shoppingCartPage;
    String productname="Apple MacBook Pro 13-inch";
    String product_name_2="Samsung Series 9 NP900X4C Premium Ultrabook";

    @Test(priority = 1)
    public void add_first_item_negative_scenario() throws InterruptedException {
        productPage=new Product_details_page(driver);
        searchForProductPage=new Search_for_product_page(driver);
        home_page=new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(),productname);
        softAssert.assertEquals(productPage.productname_header_text(),productname);
        productPage.change_quantity("1");
        productPage.click_add_to_cart();
        softAssert.assertTrue(productPage.notification_error_cart().contains("The minimum quantity allowed for purchase is 2"));


        softAssert.assertAll();


    }
    @Test(dependsOnMethods = {"add_first_item_negative_scenario"})
    public void add_first_element_positive_scenario() throws InterruptedException {
        productPage=new Product_details_page(driver);
        productPage.change_quantity("2");
        productPage.click_add_to_cart();
      Thread.sleep(1000);
        Assert.assertTrue(productPage.notification_error_cart().contains("The product has been added to your "));
    }
    @Test(dependsOnMethods = "add_first_element_positive_scenario")
    public void check_first_element()
    {
        productPage=new Product_details_page(driver);
        shoppingCartPage=new shopping_cart_page(driver);
        productPage.to_shopping_cart();
        softAssert.assertTrue(shoppingCartPage.search_for_product_name(productname));
        softAssert.assertTrue(shoppingCartPage.total_price().contains("3,600.00"));

        softAssert.assertAll();

    }
    @Test(dependsOnMethods = "check_first_element")
    public void change_quantity_negative_scenario()
    {
     shoppingCartPage.change_quantity("1");
     shoppingCartPage.click_update_shopping();
     Assert.assertTrue(shoppingCartPage.error_messege().contains("The minimum quantity allowed for purchase is 2."));
    }
    @Test(dependsOnMethods = "change_quantity_negative_scenario")
    public void change_quantity_positive_scenario() throws InterruptedException {
        shoppingCartPage.change_quantity("3");
        shoppingCartPage.click_update_shopping();

        Assert.assertTrue(shoppingCartPage.total_price().contains("5,400.00"));
    }
    @Test(dependsOnMethods = "change_quantity_positive_scenario")
public void add_another_product()
    {
        productPage=new Product_details_page(driver);
        searchForProductPage=new Search_for_product_page(driver);
        home_page=new Home_page(driver);
        home_page.write_in_searchbar(product_name_2);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(),product_name_2);
        softAssert.assertEquals(productPage.productname_header_text(),product_name_2);
        productPage.change_quantity("2");
        productPage.click_add_to_cart();
        softAssert.assertTrue(productPage.notification_error_cart().contains("The product has been added to your "));

    }
    @Test(dependsOnMethods = "change_quantity_positive_scenario")
    public void check_it_in_shopping_cart()
    {
        productPage=new Product_details_page(driver);
        shoppingCartPage=new shopping_cart_page(driver);
        productPage.to_shopping_cart();
        softAssert.assertTrue(shoppingCartPage.search_for_product_name(product_name_2));


        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "check_it_in_shopping_cart")
    public void remove_one_product() throws InterruptedException {
        home_page=new Home_page(driver);
        shoppingCartPage=new shopping_cart_page(driver);
        productPage=new Product_details_page(driver);
        shoppingCartPage.click_remove_product();

        Assert.assertFalse(shoppingCartPage.search_for_product_name(productname));

    }
    @Test(dependsOnMethods = "remove_one_product")
    public void remove_all_products() throws InterruptedException {
        home_page=new Home_page(driver);
        shoppingCartPage=new shopping_cart_page(driver);
        productPage=new Product_details_page(driver);
        shoppingCartPage.click_remove_product();

        Assert.assertTrue(shoppingCartPage.shopping_cart_empty().contains("Your Shopping Cart is empty!"));

    }

}
