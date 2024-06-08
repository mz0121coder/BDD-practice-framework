package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefs {
    private WebDriver driver;
    private String homeProductName;
    private String offerProductName;

    @Given("the user is on the GreenCart landing page")
    public void the_user_is_on_the_green_cart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("the user searches for {string} on the Home page")
    public void the_user_searches_for_on_the_home_page(String string) throws InterruptedException {
        driver.findElement(By.cssSelector(".search-keyword")).sendKeys(string);
        Thread.sleep(2000);
        homeProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
    }

    @And("the user searches again for {string} on the Offers page")
    public void the_user_searches_again_for_on_the_offers_page(String string) {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        System.out.println(iterator.toString());
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }

    @Then("the product {string} is displayed on both pages")
    public void the_product_is_displayed_on_both_pages(String string) throws InterruptedException {
        driver.findElement(By.cssSelector("input#search-field")).sendKeys(string);
        Thread.sleep(2000);
        offerProductName = driver.findElement(By.cssSelector("tr > td:nth-of-type(1)")).getText();
        Assert.assertEquals(homeProductName, offerProductName);
        driver.quit();
    }

}
