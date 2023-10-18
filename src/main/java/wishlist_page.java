import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class wishlist_page extends Pagebase{
    public wishlist_page(WebDriver driver) {
        super(driver);
    }
    private By wishlist_title=By.cssSelector("div.page-title");
    private By productname=By.cssSelector("a.product-name");
    private By remove_btn=By.cssSelector("button.remove-btn");
    private By empty_page=By.cssSelector("div.no-data");
    private By table_of_product=By.cssSelector("table.cart");


    public String wishlist_titlee()
    {
        return driver.findElement(wishlist_title).getText();
    }
    public void click_remove_btn()
    {
        click(driver.findElement(remove_btn));
    }
    public String productname()
    {
        return driver.findElement(productname).getText();
    }
    public String empty_wishlist()
    {
        return driver.findElement(empty_page).getText();
    }
    public boolean find_product_in_table(String productName) {
        WebElement table = driver.findElement(table_of_product);
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
