import com.google.common.io.Files;
import helper_functions.CookieManager;
import helper_functions.Window_manager;
import helper_functions.javascript_functions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class Testbase_2 {


    protected WebDriver driver;
    protected Home_page home_page;
    SoftAssert softAssert=new SoftAssert();


@Parameters({"browser"})
    @BeforeMethod
    public void setup( @Optional("chrome") String browsername)
    {
        if(browsername.equalsIgnoreCase("chrome"))
        {
            driver= new ChromeDriver();
        }
        else if (browsername.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");


    }

    @AfterMethod
    public void quit()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @AfterMethod
    public void failure_test(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("screenshots/" + result.getName() + ".png"));
        }
    }
    public CookieManager cookie_manager()
    {
        return new CookieManager(driver);
    }
    public Window_manager windows_manager()
    {
        return new Window_manager(driver);
    }
    public javascript_functions java()
    {
        return new javascript_functions(driver);
    }


}
