import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_for_product_page extends Pagebase{
    public Search_for_product_page(WebDriver driver) {
        super(driver);
    }
    private By productlink=By.cssSelector("div.details a");

    public void click_on_product()
    {
        click(driver.findElement(productlink));
    }
}
