import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Change_password_test extends Testbase {

    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
    Myaccount_page myaccount_page;
    changepassword_page changepasswordPage;
    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();

    String password=faker.number().digits(8).toString();
    String newpassword=faker.number().digits(8).toString();

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
    @Test(dependsOnMethods = "successfull_registration")
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
    public void change_password_test() throws InterruptedException {
        home_page=new Home_page(driver);
        changepasswordPage=new changepassword_page(driver);
        myaccount_page=new Myaccount_page(driver);
        home_page.click_on_myaccount_button();

        myaccount_page.click_on_changepassword_button();
        changepasswordPage.enter_newpassword_data(password,newpassword,newpassword);
        changepasswordPage.click_changepassword_button();
        driver.navigate().refresh();
        home_page.click_on_login_button();
        loginPage.enter_login_data(email,newpassword);
        loginPage.press_login();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(home_page.logout_text().contains("Log out"));
        softAssert.assertTrue(home_page.myaccount_text().contains("My account"));
        softAssert.assertAll();

    }
}