package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        }
        return driver;
    }
}
