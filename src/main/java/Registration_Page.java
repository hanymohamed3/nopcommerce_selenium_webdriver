import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration_Page extends Pagebase {

    public Registration_Page(WebDriver driver) {
        super(driver);
    }
    private By Gender_male_radiobutton=By.id("gender-male");
    private By Gender_female_radiobutton=By.id("gender-female");
    private By First_name=By.id("FirstName");
    private By Last_name=By.id("LastName");
    private  By Dayofbirth =By.name("DateOfBirthDay");
    private By Monthofbirth =By.name("DateOfBirthMonth");
    private By Yearofbirth=By.name("DateOfBirthYear");
    private By Email=By.id("Email");
    private By Company_name=By.id("Company");
    private By Newsletter_checkbox=By.id("Newsletter");
    private By Password=By.id("Password");
    private By Confirm_password=By.id("ConfirmPassword");
    private By Register_button=By.id("register-button");


    public void Registration(String firstname,String lastname,String email,String password,String confirm_password)
    {
        //required
       send_values( driver.findElement(First_name),firstname);
        send_values(  driver.findElement(Last_name),lastname);
        send_values( driver.findElement(Email),email);
       send_values( driver.findElement(Password),password);
        send_values(driver.findElement(Confirm_password),confirm_password);

        //not required
       click(driver.findElement(Gender_male_radiobutton));
        Select dayofbirth= new Select(driver.findElement(Dayofbirth));
        dayofbirth.selectByVisibleText("20");
        Select monthofbirth= new Select(driver.findElement(Monthofbirth));
        monthofbirth.selectByVisibleText("March");
        Select yearofbirth= new Select(driver.findElement(Yearofbirth));
       yearofbirth.selectByVisibleText("2001");
        send_values(driver.findElement(Company_name),"valuo");
        click(driver.findElement(Newsletter_checkbox));




    }
    public void clickregister()
    {
        driver.findElement(Register_button).click();
    }


















}
