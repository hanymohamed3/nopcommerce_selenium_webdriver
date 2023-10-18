import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class emailfriend_Page extends Pagebase {
    public emailfriend_Page(WebDriver driver) {
        super(driver);
    }
    private By friend_email=By.id("FriendEmail");
    private By your_email_address=By.id("YourEmailAddress");
    private By personal_messege=By.id("PersonalMessage");
    private By sendemail=By.name("send-email");
    private By successmessge=By.cssSelector("div.result");
    private By failedmss=By.cssSelector("div.message-error li");


    public void enter_emailfriend_data_registered(String friendemail,String messege)
    {
send_values(driver.findElement(friend_email),friendemail );
send_values(driver.findElement(personal_messege),messege );
    }
    public void enter_emailfriend_data_unregistered(String friendemail,String myemail,String messege)
    {
        send_values(driver.findElement(friend_email),friendemail );
        send_values(driver.findElement(your_email_address),myemail );
        send_values(driver.findElement(personal_messege),messege );
    }
    public String Myemail()
    {
        return driver.findElement(your_email_address).getAttribute("value");
    }
    public void click_sendbutton()
    {
        click(driver.findElement(sendemail));
    }
    public String success_messege()
    {
        return driver.findElement(successmessge).getText();
    }
    public String failed_mss()
    {
        return driver.findElement(failedmss).getText();
    }

}
