package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    private WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.cssSelector("input#search-field");
    private By offerPageProduct = By.cssSelector("tr > td:nth-of-type(1)");

    public void searchProduct(String string) throws InterruptedException {
        driver.findElement(searchField).sendKeys(string);
        Thread.sleep(500);
    }

    public String getProductName() {
        return driver.findElement(offerPageProduct).getText();
    }
}
