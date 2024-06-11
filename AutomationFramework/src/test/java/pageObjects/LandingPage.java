package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.cssSelector(".search-keyword");
    private By landingPageProduct = By.cssSelector("h4.product-name");
    private By topDealsLink = By.linkText("Top Deals");

    public void searchItem(String string) throws InterruptedException {
        driver.findElement(searchField).sendKeys(string);
        Thread.sleep(500);
    }

    public String getProductName() {
        return driver.findElement(landingPageProduct).getText().split("-")[0].trim();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDealsLink).click();
    }
}
