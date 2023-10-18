import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class compare_page extends Pagebase {
    public compare_page(WebDriver driver) {
        super(driver);
    }

    private By table_of_compare = By.cssSelector("table.compare-products-table");
    private By clear = By.cssSelector("a.clear-list");
    private By nodata = By.cssSelector("div.no-data");

    public boolean find_product_in_table(String productName) {
        WebElement table = driver.findElement(table_of_compare);
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

        public void click_clear_button()
        {
            click(driver.findElement(clear));
        }
        public String no_data(){
        return driver.findElement(nodata).getText();
        }

    }


