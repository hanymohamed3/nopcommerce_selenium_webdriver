import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.excel_reader;

import java.io.IOException;

public class Registration_with_datadriven_excelfile extends Testbase{


    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
    @DataProvider(name = "exceldata")
    public Object[][] dataa() throws IOException {
     excel_reader excel=new excel_reader();
     return excel.excelData();
    }


    @Test(dataProvider = "exceldata")
    public void successfull_registration(String firstname,String lastname,String email,String password)  {
        home_page=new Home_page(driver);
        registrationPage=new Registration_Page(driver);
        succesfullRegtistrationPage=new Succesfull_Regtistration_page(driver);

        home_page.click_on_register();

        registrationPage.Registration(firstname,lastname,email,password,password);

        registrationPage.clickregister();


        Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"),"There is failed in registration assertion");

    }

}
