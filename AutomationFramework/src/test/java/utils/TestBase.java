package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String baseURL = properties.getProperty("baseURL");
        String browser = properties.getProperty("browser");
        
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.get(baseURL);
        }
        return driver;
    }
}
