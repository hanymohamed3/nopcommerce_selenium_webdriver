import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class check_out_unregistered_user extends Testbase{
    Product_details_page productPage;
    Search_for_product_page searchForProductPage;
    shopping_cart_page shoppingCartPage;
    check_out_Page checkOutPage;
    check_out_as_guest_Page checkOutAsGuestPage;
    shipping_method_page shippingMethodPage;
    payment_method_page paymentMethod;
    payment_info_page paymentInfoPage;
    String productname="Apple MacBook Pro 13-inch";
    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();


    @Test(priority = 1)
    public void add_first_item_positve_scenario() throws InterruptedException {
        productPage = new Product_details_page(driver);
        searchForProductPage = new Search_for_product_page(driver);
        home_page = new Home_page(driver);
        home_page.write_in_searchbar(productname);
        home_page.click_on_searchbutton();
        searchForProductPage.click_on_product();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.productname_bar_text(), productname);
        softAssert.assertEquals(productPage.productname_header_text(), productname);
        productPage.change_quantity("2");
        productPage.click_add_to_cart();
        Thread.sleep(1000);
        Assert.assertTrue(productPage.notification_error_cart().contains("The product has been added to your "));
    }
    @Test(dependsOnMethods = "add_first_item_positve_scenario")
    public void check_first_element()
    {
        productPage=new Product_details_page(driver);
        shoppingCartPage=new shopping_cart_page(driver);
        productPage.to_shopping_cart();
        softAssert.assertTrue(shoppingCartPage.search_for_product_name(productname));
        softAssert.assertTrue(shoppingCartPage.total_price().contains("3,600.00"));

        softAssert.assertAll();

    }
    @Test(dependsOnMethods = "check_first_element")
    public void checkOut_negative_scenario()
    {
        shoppingCartPage=new shopping_cart_page(driver);
        shoppingCartPage.click_checkout();
        Assert.assertTrue(shoppingCartPage.warning_accept_terms().contains("Please accept the terms of service before the next step"));
        shoppingCartPage.click_close_warning();
    }
    @Test(dependsOnMethods = "checkOut_negative_scenario")
    public void checkOut_positive_scenario()
    {
        shoppingCartPage=new shopping_cart_page(driver);
        shoppingCartPage.click_accept_terms();
        checkOutPage=new check_out_Page(driver);
        shoppingCartPage.click_checkout();
        Assert.assertTrue(checkOutPage.page_title().contains("Welcome, Please Sign In!"));
    }
    @Test(dependsOnMethods = "checkOut_positive_scenario")
    public void check_out_as_guest()
    {
        checkOutPage=new check_out_Page(driver);
        shippingMethodPage=new shipping_method_page(driver);
        checkOutPage.click_checkout_by_guest();

        checkOutAsGuestPage=new check_out_as_guest_Page(driver);
        Assert.assertTrue(checkOutAsGuestPage.page_title().contains("Checkout"));
        checkOutAsGuestPage.enter_guest_data(firstname,lastName,email,"xcsc","scscsc","12232","01122323");
        Assert.assertTrue(shippingMethodPage.methods().isDisplayed());

    }
    @Test(dependsOnMethods = "check_out_as_guest")
    public void choose_shipping_method()
    {
        shippingMethodPage=new shipping_method_page(driver);
        paymentMethod=new payment_method_page(driver);
        shippingMethodPage.check_ground();
        shippingMethodPage.click_continuee();
        Assert.assertTrue(paymentMethod.payment_list().isDisplayed());

    }
//    @Test(priority = 7)
//    public void visa_card_test_negative_scenario() throws InterruptedException {
//        paymentMethod=new payment_method_page(driver);
//        paymentMethod.click_visa_method();
//        Thread.sleep(3000);
//        paymentMethod.enter_visa_card_data("123232","1234");
//        paymentMethod.click_continue();
//        Assert.assertTrue(paymentMethod.error_messege_visa_card().contains("Wrong card number"));
//        paymentMethod.click_back();
//    }
    @Test(dependsOnMethods = "choose_shipping_method")
    public void cash_order_test()
    {
        paymentMethod=new payment_method_page(driver);
        paymentInfoPage =new payment_info_page(driver);
        paymentMethod.click_cash_method();
        Assert.assertTrue(paymentInfoPage.infoo().isDisplayed());
    }
    @Test(dependsOnMethods = "cash_order_test")
    public void end_the_checkout() throws InterruptedException {
        paymentInfoPage =new payment_info_page(driver);
        Thread.sleep(1000);
        paymentInfoPage.click_continue();
        Assert.assertTrue(paymentInfoPage.order_review_data().isDisplayed());
        paymentInfoPage.click_confirm();
        Thread.sleep(2000);
        Assert.assertTrue(windows_manager().geturl().contains("completed"));

    }
    @Test(dependsOnMethods = "end_the_checkout")
    public void check_download() throws InterruptedException {
        paymentInfoPage =new payment_info_page(driver);
        paymentInfoPage.click_order_details();
        paymentInfoPage.click_download();
        Thread.sleep(2000);
    }



}
