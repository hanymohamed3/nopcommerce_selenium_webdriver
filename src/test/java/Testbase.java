import com.github.javafaker.Faker;
import com.google.common.io.Files;
import helper_functions.CookieManager;
import helper_functions.Window_manager;
import data.*;
import helper_functions.javascript_functions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class Testbase {


    protected WebDriver driver;
    protected Home_page home_page;
    Faker faker=new Faker();
protected SoftAssert softAssert=new SoftAssert();
public static String path=System.getProperty("user.dir")+"/Downloads";

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String downloadDirectory = System.getProperty("user.dir") + "/Downloads"; // Update with your desired download directory
        options.addArguments("--ignore-certificate-errors");
        options.setCapability("download.default_directory", downloadDirectory);
        options.setCapability("download.prompt_for_download", false);
        options.setCapability("download.directory_upgrade", true);
        options.setCapability("plugins.always_open_pdf_externally", true);

        return options;
    }

@Parameters({"browser"})
    @BeforeClass
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

    @AfterClass
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
