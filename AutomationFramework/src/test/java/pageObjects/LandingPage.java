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
    private By increment = By.cssSelector(".increment");
    private By addToCart = By.cssSelector(".products-wrapper button");
    private By cartIcon = By.cssSelector(".cart-icon");
    private By goToCheckout = By.cssSelector("header button[type='button']");

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

    public void incrementItem(int quantity) {
        for (int i = 0; i < quantity - 1; i++)
            driver.findElement(increment).click();
    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void selectCartIcon() throws InterruptedException {
        driver.findElement(cartIcon).click();
        Thread.sleep(500);
    }

    public void goToCheckout() throws InterruptedException {
        driver.findElement(goToCheckout).click();
        Thread.sleep(500);
    }
}
