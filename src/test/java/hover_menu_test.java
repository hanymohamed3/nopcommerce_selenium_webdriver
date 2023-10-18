import org.testng.Assert;
import org.testng.annotations.Test;

public class hover_menu_test extends Testbase{

    @Test
    public void hover_test()
    {
        home_page=new Home_page(driver);
        home_page.hover_on_computers();
       softAssert.assertTrue(windows_manager().geturl().contains("desktops"));
       windows_manager().back();
       home_page.hover_on_appreal();
        softAssert.assertTrue(windows_manager().geturl().contains("shoes"));
        home_page.hover_on_electronics();
        softAssert.assertTrue(windows_manager().geturl().contains("camera-photo"));
       softAssert.assertAll();
    }
}
