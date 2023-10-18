import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class shipping_method_page extends Pagebase{
    public shipping_method_page(WebDriver driver) {
        super(driver);
    }
    private By ground_method=By.id("shippingoption_0");
    private By continuee=By.cssSelector("button.button-1.shipping-method-next-step-button");
    private By methods_list=By.id("checkout-shipping-method-load");

    public void check_ground()
    {
        click(driver.findElement(ground_method));
    }
    public void click_continuee()
    {
        click(driver.findElement(continuee));
    }
    public WebElement methods()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(methods_list));
        return driver.findElement(methods_list);
    }

}
