import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class compare_product_test extends Testbase {

    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    compare_page comparePage;
    String productname = "Apple MacBook Pro 13-inch";
    String product_name_2 = "Samsung Series 9 NP900X4C Premium Ultrabook";

    @Test(priority = 1)
    public void add_first_product() throws InterruptedException {
        productPage = new Product_details_page(driver);
        searchForProductPage = new Search_for_product_page(driver);
        home_page = new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(), productname);
        softAssert.assertEquals(productPage.productname_header_text(), productname);
        productPage.click_add_to_compare();


        softAssert.assertAll();


    }



    @Test(dependsOnMethods = "add_first_product")
    public void add_product_2() throws InterruptedException {
        productPage = new Product_details_page(driver);
        searchForProductPage = new Search_for_product_page(driver);
        home_page = new Home_page(driver);
        home_page.write_in_searchbar(product_name_2);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(), product_name_2);
        softAssert.assertEquals(productPage.productname_header_text(), product_name_2);
        productPage.click_add_to_compare();
        productPage.click_to_tocompare_page();

        softAssert.assertAll();
        Thread.sleep(3000);

    }
    @Test(dependsOnMethods = "add_product_2")
    public void check_products()
    {
        comparePage=new compare_page(driver);
        Assert.assertTrue(comparePage.find_product_in_table(productname));
        Assert.assertTrue(comparePage.find_product_in_table(product_name_2));
    }
    @Test(dependsOnMethods = "check_products")
    public void check_clear_function()
    {
        comparePage=new compare_page(driver);
        comparePage.click_clear_button();
        Assert.assertTrue(comparePage.no_data().contains("You have no items to compare"));
    }
}
