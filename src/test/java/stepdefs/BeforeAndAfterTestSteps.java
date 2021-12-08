package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class BeforeAndAfterTestSteps {
    static WebDriver driver;

    @Before
    public void setUp() throws IOException, AWTException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverlocalmac");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void cleanUp() throws IOException {
        driver.quit();
    }
}