import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class shopping_cart_page extends Pagebase{
    public shopping_cart_page(WebDriver driver) {
        super(driver);
    }
    private By shopping_cart_title=By.cssSelector("div.page-title");
    private By product_table=By.cssSelector("table.cart");
    private By quantity_field=By.cssSelector("input.qty-input");
    private By remove_product_btn=By.cssSelector("button.remove-btn");
    private By totalprice=By.cssSelector("span.product-subtotal");
    private By continue_shopping=By.name("continueshopping");
    private By update_shopping=By.id("updatecart");
    private By shopping_cart_empty=By.cssSelector("div.no-data");
    private By product_name=By.cssSelector("a.product-name");
    private By error_messege_=By.cssSelector("div.message-error");
    private By add_copon_field=By.id("discountcouponcode");
    private By apply_copon_button=By.id("applydiscountcouponcode");
    private By copon_failure_messege=By.cssSelector("div.coupon-box div.message-failure");
    private By add_gift_field=By.id("giftcardcouponcode");
    private By apply_gift_button=By.id("applygiftcardcouponcode");
    private By gift_failure_messege=By.cssSelector("div.giftcard-box div.message-failure");
    private By accept_terms=By.id("termsofservice");
    private By checkout_button=By.id("checkout");
    private By warning_messege_terms=By.id("terms-of-service-warning-box");
    private By close_warning=By.cssSelector("button.ui-button ");



    public void click_update_shopping()
    {
        click(driver.findElement(update_shopping));
    }
    public void click_continue_shopping()
    {
        click(driver.findElement(continue_shopping));
    }
    public void change_quantity(String number)
    {
        clear(driver.findElement(quantity_field));
        send_values(driver.findElement(quantity_field),number );
    }
    public void click_remove_product()
    {
        click(driver.findElement(remove_product_btn));
    }
    public String total_price()
    {
        return driver.findElement(totalprice).getText();
    }
    public String shopping_cart_empty()
    {
        return driver.findElement(shopping_cart_empty).getText();
    }
    public boolean search_for_product_name(String name)
    {
        return search_product_in_table(name,driver.findElement((product_table)));
    }
    public String error_messege()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_messege_));
        return driver.findElement(error_messege_).getText();
    }
    public void enter_copon(String copon)
    {
        send_values(driver.findElement(add_copon_field),copon );
        click(driver.findElement(apply_copon_button));
    }
    public void enter_gift(String gift)
    {
        send_values(driver.findElement(add_gift_field),gift );
        click(driver.findElement(apply_gift_button));
    }
    public String copon_failure_mss()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(copon_failure_messege));
        return driver.findElement(copon_failure_messege).getText();
    }
    public String gift_failure_mss()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gift_failure_messege));
        return driver.findElement(gift_failure_messege).getText();
    }
    public void click_checkout()
    {
        click(driver.findElement(checkout_button));
    }
    public void click_accept_terms()
    {
        click(driver.findElement(accept_terms));
    }
    public String warning_accept_terms()
    {
        return driver.findElement(warning_messege_terms).getText();
    }
    public void click_close_warning()
    {
        click(driver.findElement(close_warning));
    }
}
