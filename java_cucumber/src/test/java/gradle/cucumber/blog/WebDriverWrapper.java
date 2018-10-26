package gradle.cucumber.blog;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWrapper {
    public ChromeDriver driver = new ChromeDriver();

    public WebDriverWrapper() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    public ChromeDriver getDriver() {
        return driver;
    }
}
