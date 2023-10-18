import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class payment_info_page extends Pagebase{
    public payment_info_page(WebDriver driver) {
        super(driver);
    }
    private By info_of_order=By.id("co-payment-info-form");
    private By order_review_data=By.cssSelector("div.order-review-data");
    private By continuee=By.cssSelector("button.button-1.payment-info-next-step-button");
    private By confirm=By.cssSelector("button.button-1.confirm-order-next-step-button");
    private By success_messege_order=By.cssSelector("div.title");
    private By order_details_link=By.cssSelector("div.details-link a");
    private By download_button=By.cssSelector("a.button-2.pdf-invoice-button");
    public WebElement infoo()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(info_of_order));
        return driver.findElement(info_of_order);
    }
    public WebElement order_review_data()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(order_review_data));
        return driver.findElement(order_review_data);
    }
    public void click_continue()
    {
        wait.until(ExpectedConditions.elementToBeClickable(continuee));
        click(driver.findElement(continuee));
    }
    public void click_confirm()
    {
        click(driver.findElement(confirm));
    }
    public String success_messege()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(success_messege_order));
        return driver.findElement(success_messege_order).getText();
    }
    public void click_order_details()
    {
        click(driver.findElement(order_details_link));
    }
    public void click_download()
    {
        click(driver.findElement(download_button));
    }
}
