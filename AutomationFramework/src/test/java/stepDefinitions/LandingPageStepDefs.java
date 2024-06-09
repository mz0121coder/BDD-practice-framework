package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestSetup;

public class LandingPageStepDefs {
    private WebDriver driver;
    private String landingPageProductName;
    private String offerPageProductName;
    private TestSetup testSetup;

    public LandingPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
    }

    @Given("the user is on the GreenCart landing page")
    public void the_user_is_on_the_green_cart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        testSetup.driver = new ChromeDriver();
        testSetup.driver.manage().window().maximize();
        testSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("the user searches for {string} on the Home page")
    public void the_user_searches_for_on_the_home_page(String string) throws InterruptedException {
        testSetup.driver.findElement(By.cssSelector(".search-keyword")).sendKeys(string);
        Thread.sleep(2000);
        testSetup.landingPageProductName = testSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    }

}
