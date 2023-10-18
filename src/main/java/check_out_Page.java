import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class check_out_Page extends Pagebase{
    public check_out_Page(WebDriver driver) {
        super(driver);
    }
    private By page_title=By.cssSelector("div.page-title");
   private By check_out_as_guest=By.cssSelector("button.button-1.checkout-as-guest-button");







   public String page_title()
   {
       return driver.findElement(page_title).getText();
   }
   public void click_checkout_by_guest(){
      click(driver.findElement(check_out_as_guest));
   }
}

