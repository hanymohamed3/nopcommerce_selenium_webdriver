import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Pagebase {
   protected WebDriver driver;
   protected Select select;
   protected Actions actions;
    WebDriverWait wait;

   public Pagebase(WebDriver driver)
   {
       this.driver=driver;
       this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       this.actions=new Actions(driver);
   }

   public void click(WebElement element)
   {
       element.click();
   }
    public void send_values(WebElement element, String keys)
    {
       element.sendKeys(keys);
    }
    public void clear(WebElement element)
    {
        element.clear();
    }
    public boolean search_product_in_table(String productName,WebElement table) {

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        boolean productFound = false;


        for (WebElement row : rows) {

            java.util.List<WebElement> columns = row.findElements(By.tagName("td"));

            // Iterate through the columns
            for (WebElement column : columns) {

                if (column.getText().contains(productName)) {
                    productFound = true;
                    break;
                }
            }

            if (productFound) {
                break; // Product found, no need to continue searching
            }

        }
        return productFound;
    }

}
