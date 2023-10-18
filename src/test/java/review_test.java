import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class review_test extends Testbase{

    String firstname=faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8).toString();
        String review_text = "i like this product";
        String review_title="mac products";
        Product_details_page productPage;
        String productname = "Mac";
        Registration_Page registrationPage;
        Login_page loginPage;
        Succesfull_Regtistration_page succesfullRegtistrationPage;
        add_review_page add_review_page;



       @Test(priority = 1)
        public void successfull_registration() {
            home_page = new Home_page(driver);
            registrationPage = new Registration_Page(driver);
            succesfullRegtistrationPage = new Succesfull_Regtistration_page(driver);

            home_page.click_on_register();

            registrationPage.Registration(firstname, lastName, email, password, password);

            registrationPage.clickregister();
            Assert.assertTrue(succesfullRegtistrationPage.successmessege().contains("Your registration completed"), "There is failed in registration assertion");


        }

        @Test(dependsOnMethods = {"successfull_registration"})
        public void validlogin() throws InterruptedException {

            home_page = new Home_page(driver);
            loginPage = new Login_page(driver);
            SoftAssert softAssert = new SoftAssert();

            home_page.click_on_login_button();

            loginPage.enter_login_data(email, password);

            loginPage.press_login();
            softAssert.assertTrue(home_page.logout_text().contains("Log out"));
            softAssert.assertTrue(home_page.myaccount_text().contains("My account"));

            softAssert.assertAll();


        }

        @Test(dependsOnMethods = {"validlogin"})
        public void search_by_random_positive() {
            productPage = new Product_details_page(driver);
            home_page = new Home_page(driver);
            home_page.write_in_searchbar(productname);
            home_page.click_on_product_in_searchlist(0);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(productPage.productname_bar_text().contains(productname));
            softAssert.assertTrue(productPage.productname_header_text().contains(productname));

            softAssert.assertAll();
        }
        @Test(dependsOnMethods = {"search_by_random_positive"})
        public void addreview_positive_senario()
        {
            productPage = new Product_details_page(driver);
            home_page = new Home_page(driver);
            add_review_page=new add_review_page(driver);
            productPage.click_on_add_review();
            add_review_page.add_review_data(review_title,review_text);
            add_review_page.click_submit();

            Assert.assertTrue(add_review_page.success_messege().contains("Product review is successfully added."));
        }
        @Test(dependsOnMethods = {"addreview_positive_senario"})
        public void logout()
        {
            home_page.click_on_logout_button();

        }
        @Test(dependsOnMethods = {"logout"})
        public void search_by_random_negative() {
            productPage = new Product_details_page(driver);
            home_page = new Home_page(driver);
            home_page.write_in_searchbar(productname);
            home_page.click_on_product_in_searchlist(0);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(productPage.productname_bar_text().contains(productname));
            softAssert.assertTrue(productPage.productname_header_text().contains(productname));

            softAssert.assertAll();
        }
        @Test(dependsOnMethods = {"search_by_random_negative"})
        public void addreview_negative_senario()
        {
            productPage = new Product_details_page(driver);
            home_page = new Home_page(driver);
            add_review_page=new add_review_page(driver);
            productPage.click_on_add_review();

            Assert.assertTrue(add_review_page.failed_messege().contains("Only registered users can write reviews"));
        }

    }

