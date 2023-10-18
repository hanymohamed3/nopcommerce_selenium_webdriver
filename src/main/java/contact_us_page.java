import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contact_us_page extends Pagebase{
    public contact_us_page(WebDriver driver) {
        super(driver);
    }
    private By fullname=By.id("FullName");
    private By email=By.id("Email");
    private By enquiry=By.id("Enquiry");
    private By submit=By.name("send-email");
    private By succeffully=By.cssSelector("div.result");

    public void write_enquiry_data_unregistered(String name,String Email,String Enquiry)
    {
        send_values(driver.findElement(fullname),name );
        send_values(driver.findElement(email),Email );
        send_values(driver.findElement(enquiry),Enquiry );

    }
    public void write_enquiry_data_registered(String name,String Enquiry)
    {
        send_values(driver.findElement(fullname),name );

        send_values(driver.findElement(enquiry),Enquiry );

    }
    public void click_submit()
    {
        click(driver.findElement(submit));
    }
    public String enquiry_sended_text()
    {
        return driver.findElement(succeffully).getText();
    }
    public String emailtext()
    {
        return driver.findElement(email).getAttribute("value");
    }

}
