package helper_functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class javascript_functions {

    private WebDriver driver;
    public javascript_functions(WebDriver driver)
    {
        this.driver=driver;
    }

    public void scroll()
    {
        JavascriptExecutor ex=(JavascriptExecutor) driver;
        ex.executeScript("scrollBy(0,3000)");
    }
}
