import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Succesfull_Regtistration_page extends Pagebase{
    public Succesfull_Regtistration_page(WebDriver driver) {
        super(driver);
    }
    private By success=By.cssSelector("div.result");
    private By loginbutton =By.cssSelector("a.ico-login");

    public String successmessege()
    {
        return driver.findElement(success).getText();
    }
    public String pagetitle()
    {
       return driver.getTitle();
    }
    public void click_on_login_button()  {
        click( driver.findElement(loginbutton));

    }


}
