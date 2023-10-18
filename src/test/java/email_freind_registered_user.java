import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class email_freind_registered_user extends Testbase{
    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();
    String personal_messege="i suggest this product for you";
    Product_details_page productPage;
    String productname="Mac";
    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
    emailfriend_Page emailfriendPage;


    @Test(priority = 1)
    public void successfull_registration()  {
        home_page=new Home_page(driver);
        registrationPage=new Registration_Page(driver);
        succesfullRegtistrationPage=new Succesfull_Regtistration_page(driver);

        home_page.click_on_register();

        registrationPage.Registration(firstname,lastName,email,password,password);

        registrationPage.clickregister();
        Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"),"There is failed in registration assertion");



    }
    @Test(dependsOnMethods = {"successfull_registration"})
    public void validlogin() throws InterruptedException {

        home_page=new Home_page(driver);
        loginPage=new Login_page(driver);
        SoftAssert softAssert = new SoftAssert();

        home_page.click_on_login_button();

        loginPage.enter_login_data(email,password);

        loginPage.press_login();
        softAssert.assertTrue(home_page.logout_text().contains("Log out"));
        softAssert.assertTrue(home_page.myaccount_text().contains("My account"));

        softAssert.assertAll();


    }
    @Test(dependsOnMethods = {"validlogin"})
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
        emailfriendPage.enter_emailfriend_data_registered("hanymoo@gmail.com",personal_messege);
        emailfriendPage.click_sendbutton();
      Assert.assertTrue(emailfriendPage.success_messege().contains("Your message has been sent."));

    }
}
