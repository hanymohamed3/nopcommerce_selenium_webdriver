import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.load_properties;

public class Registration_with_dataprovider_propertiesfile extends Testbase{


    Registration_Page registrationPage;

    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
    String firstname=load_properties.userdata.getProperty("firstname");
    String lastname=load_properties.userdata.getProperty("lastname");
    String email=load_properties.userdata.getProperty("email");
    String password=load_properties.userdata.getProperty("password");




    @Test
    public void successfull_registration() throws InterruptedException {
        home_page=new Home_page(driver);
        registrationPage=new Registration_Page(driver);
        succesfullRegtistrationPage=new Succesfull_Regtistration_page(driver);

        home_page.click_on_register();

        registrationPage.Registration(firstname,lastname,email,password,password);
        Thread.sleep(3000);

        registrationPage.clickregister();


        Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"),"There is failed in registration assertion");

    }

}
