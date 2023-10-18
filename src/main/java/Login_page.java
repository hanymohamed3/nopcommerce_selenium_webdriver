import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page extends Pagebase {
    public Login_page(WebDriver driver) {
        super(driver);
    }
    private By Email=By.id("Email");
    private By Password=By.id("Password");
    private By login_button=By.cssSelector("button.login-button");

    public void enter_login_data(String email,String password)
    {
        send_values(driver.findElement(Email), email);
        send_values(driver.findElement(Password),password );

    }
    public void press_login(){
        click(driver.findElement(login_button));
    }




}
