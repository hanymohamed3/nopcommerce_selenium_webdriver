import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Registration_with_csv_file extends Testbase{


    Registration_Page registrationPage;
    Login_page loginPage;
    Succesfull_Regtistration_page succesfullRegtistrationPage;
  CSVReader csvReader;

    @Test()
    public void successfull_registration() throws IOException, CsvValidationException {
        String userDir = System.getProperty("user.dir");
        String csv_file_path = userDir + "\\src\\main\\java\\data\\csv_file.csv";

        csvReader = new CSVReader(new FileReader(csv_file_path));
        String[] csv_cell;
        while ((csv_cell = csvReader.readNext()) != null) {
            String firstname=csv_cell[0];
            String lastname=csv_cell[1];
            String email=csv_cell[2];
            String password=csv_cell[3];
            home_page = new Home_page(driver);
            registrationPage = new Registration_Page(driver);
            succesfullRegtistrationPage = new Succesfull_Regtistration_page(driver);

            home_page.click_on_register();

            registrationPage.Registration(firstname, lastname, email, password, password);

            registrationPage.clickregister();


            Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"), "There is failed in registration assertion");

        }
    }

}
