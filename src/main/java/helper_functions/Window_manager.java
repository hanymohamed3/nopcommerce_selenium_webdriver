package helper_functions;

import org.openqa.selenium.WebDriver;

public class Window_manager {

    private WebDriver driver;

    public Window_manager(WebDriver driver) {
        this.driver = driver;
    }

    public void back() {
        driver.navigate().back();
    }

    public String gettitle() {
        return driver.getTitle();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public String geturl() {
        return driver.getCurrentUrl();
    }

    public String getcuurentwindowhandle() {
        return driver.getWindowHandle();
    }

    public void switchs_to_last_window() {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

        }
    }

    public void switchToWindowByTitle(String windowTitle) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            if (driver.getTitle().equals(windowTitle))
            {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
