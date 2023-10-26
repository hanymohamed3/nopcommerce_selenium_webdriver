import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Contact_us_test_for_registereduserr extends Testbase{

    contact_us_page contactUsPage;
    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();
    String enquiry="please can you change this ugly user interface";
    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;


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
    public void contact_us()
    {
        home_page=new Home_page(driver);
        contactUsPage=new contact_us_page(driver);
        java().scroll();
        home_page.click_on_contact_us();
        contactUsPage.write_enquiry_data_registered(firstname,enquiry);
        Assert.assertEquals(email,contactUsPage.emailtext());
        contactUsPage.click_submit();
        Assert.assertTrue(contactUsPage.enquiry_sended_text().contains("Your enquiry has been successfully sent to the store owner."));

    }
}