import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Home_page extends Pagebase{

    public Home_page(WebDriver driver) {
        super(driver);
    }
    private By registrationbutton =By.cssSelector("a.ico-register");
    private By loginbutton =By.cssSelector("a.ico-login");

    private By logoutbutton=By.linkText("Log out");
    private By my_accountbutton=By.cssSelector("a.ico-account");
    private By search_bar =By.id("small-searchterms");
    private By search_button=By.cssSelector("button.search-box-button");
    private By search_list=By.id("ui-id-1");
    private By contact_us=By.linkText("Contact us");
    private By change_currency=By.id("customerCurrency");
    private By computers=By.linkText("Computers");
    private By desktop=By.xpath("//a[contains(.,'Desktops ')]");
    private By shoes=By.xpath("//a[contains(.,'Shoes ')]");
    private By electronics=By.linkText("Electronics");
    private By camera=By.xpath("//a[contains(.,'Camera & photo ')]");
    private By appreal=By.linkText("Apparel");



    public void click_on_register()  {
       click( driver.findElement(registrationbutton));

    }
    public void click_on_login_button()  {
        click( driver.findElement(loginbutton));

    }
    public void click_on_logout_button()  {
        click( driver.findElement(logoutbutton));

    }
    public void click_on_myaccount_button()
    {
        click(driver.findElement(my_accountbutton));
    }
    public String myaccount_text()
    {
       return driver.findElement(my_accountbutton).getText();
    }
    public String logout_text()
    {
        return driver.findElement(logoutbutton).getText();
    }
    public void write_in_searchbar(String productname)
    {
        send_values(driver.findElement(search_bar),productname );
    }
    public void click_on_searchbutton()
    {
        click(driver.findElement(search_button));
    }
    public void click_on_product_in_searchlist(int index)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_list));
        click(driver.findElements(search_list).get(index));
    }
    public String productname(int index)
    {
        return driver.findElements(search_list).get(index).getText();
    }


    public void click_on_contact_us() {
        click(driver.findElement(contact_us));
    }


    public void setChange_currency_euro() {
        select=new Select(driver.findElement(change_currency));
        select.selectByVisibleText("Euro");
    }
    public void setChange_currency_dollar() {
        select=new Select(driver.findElement(change_currency));
        select.selectByVisibleText("US Dollar");
    }
    public void hover_on_computers()
    {
        actions.moveToElement(driver.findElement(computers)).moveToElement(driver.findElement(desktop)).click().perform();
    }
    public void hover_on_appreal()
    {
        actions.moveToElement(driver.findElement(appreal)).moveToElement(driver.findElement(shoes)).click().perform();
    }
    public void hover_on_electronics()
    {
        actions.moveToElement(driver.findElement(electronics)).moveToElement(driver.findElement(camera)).click().perform();
    }

}
