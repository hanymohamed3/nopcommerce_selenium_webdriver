import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class payment_method_page extends Pagebase{
    public payment_method_page(WebDriver driver) {
        super(driver);
    }
    private By cash_order=By.id("paymentmethod_0");
    private By visa_order=By.id("paymentmethod_1");
    private By continuee=By.cssSelector("button.button-1.payment-method-next-step-button");
    private By back_in_visa_page=By.cssSelector("div#checkout-step-payment-info p.back-link a");
    private By card_number_field=By.id("CardNumber");
    private By card_code_field=By.id("CardCode");

    private By payment_method_list=By.id("payment-method-block");
    private By error_messege_in_visa_page=By.cssSelector("div.message-error.validation-summary-errors");


    public void click_cash_method()
    {
        click(driver.findElement(cash_order));
        click(driver.findElement(continuee));
    }
    public void click_visa_method()
    {
        click(driver.findElement(visa_order));
        click(driver.findElement(continuee));
    }
    public void enter_visa_card_data(String card_number,String cardCode)
    {

        send_values(driver.findElement(card_number_field),card_number );
        send_values(driver.findElement(card_code_field),cardCode );

    }
    public void click_continue()
    {
        click(driver.findElement(continuee));
    }
    public void click_back()
    {
        click(driver.findElement(back_in_visa_page));
    }
    public WebElement payment_list()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payment_method_list));
        return driver.findElement(payment_method_list);
    }
    public String error_messege_visa_card()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_messege_in_visa_page));
        return driver.findElement(error_messege_in_visa_page).getText();
    }


}
