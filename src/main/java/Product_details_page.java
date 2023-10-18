import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.locks.Condition;

public class Product_details_page extends Pagebase{
    public Product_details_page(WebDriver driver) {
        super(driver);
    }
    private By product_name_header=By.cssSelector("div.product-name>h1");
    private By getProduct_name_in_bar=By.cssSelector("strong.current-item");
    private By email_freind=By.cssSelector("button.email-a-friend-button");
    private By price=By.cssSelector("div.product-price");
    private By addreview=By.linkText("Add your review");
    private By add_wishlist=By.id("add-to-wishlist-button-4");
    private By add_wishlist_2=By.id("add-to-wishlist-button-6");
    private By wishlist_page=By.cssSelector("div#bar-notification a");
    private By compare_list=By.cssSelector("div.overview-buttons button.button-2.add-to-compare-list-button");
    private By compare_page=By.xpath("//div[@id='bar-notification'] //a");
    private By addtocart=By.cssSelector("button.button-1.add-to-cart-button");
    private By quantity_field=By.cssSelector("input.qty-input");
    private By shopping_cart_notification_bar=By.cssSelector("div#bar-notification a");
    private By notification_add_cart=By.cssSelector("div#bar-notification");




    public String productname_header_text()
    {
        return driver.findElement(product_name_header).getText();
    }
    public String productname_bar_text()
    {
        return driver.findElement(getProduct_name_in_bar).getText();
    }
    public String pageurl()
    {
        return driver.getCurrentUrl();
    }
    public void click_email_friend_button()
    {
        click(driver.findElement(email_freind));
    }
    public String product_price()
    {
        return driver.findElement(price).getText();
    }
    public void click_add_to_wishlist()
    {

        click(driver.findElement(add_wishlist));
    }
    public void click_add_to_wishlist_2()
    {

        click(driver.findElement(add_wishlist_2));
    }
    public void click_to_wishlist_page()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishlist_page));
        click(driver.findElement(wishlist_page));
    }


    public void click_on_add_review() {
        click(driver.findElement(addreview));
    }
    public void click_add_to_compare()
    {
        click(driver.findElement(compare_list));
    }
    public void click_to_tocompare_page()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_page));
        click(driver.findElement(compare_page));
    }
    public void click_add_to_cart()
    {
        click(driver.findElement(addtocart));

        wait.until(ExpectedConditions.visibilityOfElementLocated(notification_add_cart));

    }
    public void to_shopping_cart()
    {
        click(driver.findElement(shopping_cart_notification_bar));
    }
    public void change_quantity(String number)
    {
        clear(driver.findElement(quantity_field));
        send_values(driver.findElement(quantity_field),number );

    }
    public String notification_error_cart()
    {

        return driver.findElement(notification_add_cart).getText();
    }
}
