import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class check_out_as_guest_Page extends Pagebase{
    public check_out_as_guest_Page(WebDriver driver) {
        super(driver);
    }
    private By page_title=By.cssSelector("div.page-title");
    private By first_name=By.id("BillingNewAddress_FirstName");
    private By last_name=By.id("BillingNewAddress_LastName");
    private By email=By.id("BillingNewAddress_Email");
    private By city=By.id("BillingNewAddress_City");
    private By address1=By.id("BillingNewAddress_Address1");
    private By zip_code=By.id("BillingNewAddress_ZipPostalCode");
    private By phone=By.id("BillingNewAddress_PhoneNumber");
    private By continuo=By.cssSelector("button[name='save'][class='button-1 new-address-next-step-button']");
    private By country=By.id("BillingNewAddress_CountryId");



    public void enter_guest_data(String first,String last,String Email,String City,String address,String zip_codee,String Phone)
    {
        send_values(driver.findElement(first_name),first );
        send_values(driver.findElement(last_name),last );
        send_values(driver.findElement(email),Email);
        send_values(driver.findElement(city),City );
        send_values(driver.findElement(address1),address );
        send_values(driver.findElement(zip_code),zip_codee );
        send_values(driver.findElement(phone),Phone );
        Select select1=new Select(driver.findElement(country));
        select1.selectByIndex(3);
        click(driver.findElement(continuo));
    }
    public String page_title()
    {
        return driver.findElement(page_title).getText();
    }


    }

