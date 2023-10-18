import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class changepassword_page extends Pagebase{
    public changepassword_page(WebDriver driver) {
        super(driver);
    }
    private By oldpassword=By.id("OldPassword");
    private By newpassword=By.id("NewPassword");
    private By confirmnewpassword=By.id("ConfirmNewPassword");
    private By Changepassword_button=By.cssSelector("button.change-password-button");
    private By successbar=By.id("bar-notification");
    private By logoutbutton=By.linkText("Log out");
    private By close_of_successbar=By.cssSelector("span.close");


    public void enter_newpassword_data(String Oldpassword,String Newpassword,String ConfirmNewpassword)
    {
        send_values(driver.findElement(oldpassword),Oldpassword );
        send_values(driver.findElement(newpassword),Newpassword );
        send_values(driver.findElement(confirmnewpassword),ConfirmNewpassword );
    }
    public void click_changepassword_button()
    {
        click(driver.findElement(Changepassword_button));
    }
    public String success_text()
    {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(successbar));
        return driver.findElement(successbar).getText();
    }
    public void click_logoutbutton()
    {
        click(driver.findElement(logoutbutton));
    }
    public void click_on_closesucessbar()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(close_of_successbar));
        click(driver.findElement(close_of_successbar));
    }
}
