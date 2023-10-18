import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Myaccount_page extends Pagebase{

    public Myaccount_page(WebDriver driver) {
        super(driver);
    }
private By change_password =By.partialLinkText("Change password");







    public void click_on_changepassword_button()
    {
        click(driver.findElement(change_password));
    }

}
