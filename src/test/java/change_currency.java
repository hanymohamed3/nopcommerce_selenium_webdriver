import org.testng.annotations.Test;

public class change_currency extends Testbase_2 {

    Product_details_page productPage;
    String productname="Mac";


    @Test
    public void change_currency_euro() throws InterruptedException {
        productPage=new Product_details_page(driver);
        home_page=new Home_page(driver);
        home_page.setChange_currency_euro();
        home_page.write_in_searchbar(productname);
        home_page.click_on_product_in_searchlist(0);

        softAssert.assertTrue(productPage.productname_bar_text().contains(productname));
        softAssert.assertTrue(productPage.productname_header_text().contains(productname));

        softAssert.assertTrue(productPage.product_price().contains("€"));

        softAssert.assertAll();
    }
    @Test
    public void change_currency_dollar()
    {
        productPage=new Product_details_page(driver);
        home_page=new Home_page(driver);
        home_page.setChange_currency_dollar();
        home_page.write_in_searchbar(productname);
        home_page.click_on_product_in_searchlist(0);
        softAssert.assertTrue(productPage.productname_bar_text().contains(productname));
        softAssert.assertTrue(productPage.productname_header_text().contains(productname));
        softAssert.assertTrue(productPage.product_price().contains("$"));

        softAssert.assertAll();
    }

}
