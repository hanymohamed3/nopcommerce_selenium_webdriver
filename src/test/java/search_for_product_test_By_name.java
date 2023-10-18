import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class search_for_product_test_By_name extends Testbase{
    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    String productname="Apple MacBook Pro 13-inch";

    @Test
    public void searchbyname()
    {
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


}
