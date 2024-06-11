package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productName = By.cssSelector(".product-name");
    private By quantity = By.cssSelector(".quantity");
    private By promoBtn = By.cssSelector(".promoBtn");
    private By placeOrder = By.cssSelector(".products > div > button");

    public String getProductName() {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public int getQuantity() {
        return Integer.parseInt(driver.findElement(quantity).getText());
    }

    public Boolean verifyPromoBtn() {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean verifyPlaceOrderBtn() {
        return driver.findElement(placeOrder).isDisplayed();
    }
}
