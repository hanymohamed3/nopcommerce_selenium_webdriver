import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class search_for_product_for_suggestlist extends Testbase {

    Product_details_page productPage;
    String productname="Mac";

    @Test
    public void search_by_random()
    {
        productPage=new Product_details_page(driver);
        home_page=new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_product_in_searchlist(0);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(productPage.productname_bar_text().contains(productname));
        softAssert.assertTrue(productPage.productname_header_text().contains(productname));

        softAssert.assertAll();
    }



}
