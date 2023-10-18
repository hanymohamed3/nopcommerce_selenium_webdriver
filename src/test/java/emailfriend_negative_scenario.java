import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class emailfriend_negative_scenario extends Testbase{
    String name=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();
    String personal_messege="i suggest this product for you";
    Product_details_page productPage;
    String productname="Mac";
    emailfriend_Page emailfriendPage;
    @Test(priority = 1)
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
    @Test(dependsOnMethods = "search_by_random")
    public void email_freind_test()
    {
        productPage=new Product_details_page(driver);
        emailfriendPage=new emailfriend_Page(driver);
        productPage.click_email_friend_button();
        emailfriendPage.enter_emailfriend_data_unregistered("hanymoo@gmail.com",email,personal_messege);
        emailfriendPage.click_sendbutton();
        Assert.assertTrue(emailfriendPage.failed_mss().contains("Only registered customers can use email a friend feature"));

    }
}
