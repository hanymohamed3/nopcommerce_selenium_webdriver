import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration_with_dataprovider_test extends Testbase{


    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
    @DataProvider(name = "testdata")
    public Object[][] dataa()
    {
        return new Object[][]{
                {"hany","mohamed","hanymohamed32012@gmail.com","hahaha","hahaha"},
                {"mohamed","ali","mohamedali134@gmail.com","hahaha","hahaha"}

        };
    }


    @Test(dataProvider = "testdata")
    public void successfull_registration(String firstname,String lastname,String email,String password,String confirm_password)  {
        home_page=new Home_page(driver);
        registrationPage=new Registration_Page(driver);
        succesfullRegtistrationPage=new Succesfull_Regtistration_page(driver);

        home_page.click_on_register();

        registrationPage.Registration(firstname,lastname,email,password,confirm_password);

        registrationPage.clickregister();


        Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"),"There is failed in registration assertion");

    }

}
