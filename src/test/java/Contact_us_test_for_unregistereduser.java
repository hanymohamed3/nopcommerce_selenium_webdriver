import org.testng.Assert;
import org.testng.annotations.Test;

public class Contact_us_test_for_unregistereduser extends Testbase{

    contact_us_page contactUsPage;
    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();
    String enquiry="please can you change this ugly user interface";

    @Test
    public void contact_us()
    {
        home_page=new Home_page(driver);
        contactUsPage=new contact_us_page(driver);
        java().scroll();
        home_page.click_on_contact_us();
        contactUsPage.write_enquiry_data_unregistered(firstname,email,enquiry);
        contactUsPage.click_submit();
        Assert.assertTrue(contactUsPage.enquiry_sended_text().contains("Your enquiry has been successfully sent to the store owner."));

    }
}
