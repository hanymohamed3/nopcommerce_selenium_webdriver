import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class add_review_page extends Pagebase{
    public add_review_page(WebDriver driver) {
        super(driver);
    }
    private By review_title=By.id("AddProductReview_Title");
    private By review_text=By.id("AddProductReview_ReviewText");
    private By rate_1=By.id("addproductrating_1");
    private By submit=By.name("add-review");
    private By success=By.cssSelector("div.result");
    private By validationmss=By.cssSelector("div.message-error.validation-summary-errors");

    public void add_review_data(String reviewtitle,String reviewtext)
    {
        send_values(driver.findElement(review_title), reviewtitle);
        send_values(driver.findElement(review_text), reviewtext);
        click(driver.findElement(rate_1));
    }
    public void click_submit()
    {
        click(driver.findElement(submit));
    }
    public String success_messege()
    {
        return driver.findElement(success).getText();
    }
    public String failed_messege()
    {
        return driver.findElement(validationmss).getText();
    }

}
