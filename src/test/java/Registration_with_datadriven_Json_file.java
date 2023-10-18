import data.excel_reader;
import data.json_reader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration_with_datadriven_Json_file extends Testbase{


    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;



    @Test()
    public void successfull_registration() throws IOException, ParseException {
        json_reader json_reader = new json_reader();
        json_reader.Json_reader();
        home_page=new Home_page(driver);
        registrationPage=new Registration_Page(driver);
        succesfullRegtistrationPage=new Succesfull_Regtistration_page(driver);

        home_page.click_on_register();

        registrationPage.Registration(json_reader.firstname,json_reader.lastname,json_reader.email,json_reader.password,json_reader.password);

        registrationPage.clickregister();


        Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"),"There is failed in registration assertion");

    }

}
