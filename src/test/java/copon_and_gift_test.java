import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class copon_and_gift_test extends Testbase{

    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    shopping_cart_page shoppingCartPage;
    String productname="Apple MacBook Pro 13-inch";
    String product_name_2="Samsung Series 9 NP900X4C Premium Ultrabook";
    @Test(priority = 1)
    public void add_first_item_positve_scenario() throws InterruptedException {
        productPage = new Product_details_page(driver);
        searchForProductPage = new Search_for_product_page(driver);
        home_page = new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(), productname);
        softAssert.assertEquals(productPage.productname_header_text(), productname);
        productPage.change_quantity("2");
        productPage.click_add_to_cart();
        Thread.sleep(1000);
        Assert.assertTrue(productPage.notification_error_cart().contains("The product has been added to your "));
    }
    @Test(dependsOnMethods = "add_first_item_positve_scenario")
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
    public void add_copon_code_negative_scenario()
    {
        shoppingCartPage=new shopping_cart_page(driver);
        shoppingCartPage.enter_copon("hadcdcd");
        Assert.assertTrue(shoppingCartPage.copon_failure_mss().contains("The coupon code cannot be found"));
    }
    @Test(dependsOnMethods = "add_copon_code_negative_scenario")
    public void add_gift_code_negative_scenario()
    {
        shoppingCartPage=new shopping_cart_page(driver);
        shoppingCartPage.enter_gift("hadcdcd");
        Assert.assertTrue(shoppingCartPage.gift_failure_mss().contains("The coupon code you entered couldn't be applied to your order"));
    }

}
