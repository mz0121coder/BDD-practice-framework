package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefs {
    TestSetup testSetup;
    private String offerPageProductName;

    public OfferPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
    }

    @And("the user searches again for {string} on the Offers page")
    public void the_user_searches_again_for_on_the_offers_page(String string) throws InterruptedException {
        switchToOffersPage();
        testSetup.driver.findElement(By.cssSelector("input#search-field")).sendKeys(string);
        Thread.sleep(2000);
        offerPageProductName = testSetup.driver.findElement(By.cssSelector("tr > td:nth-of-type(1)")).getText();
    }

    @Then("the product {string} is displayed on both pages")
    public void the_product_is_displayed_on_both_pages(String string) {
        Assert.assertEquals(testSetup.landingPageProductName, offerPageProductName);
        testSetup.driver.quit();
    }

    public void switchToOffersPage() {
//        if already on offers page, skip the rest of the logic
        if (testSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
            return;

        testSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windowHandles = testSetup.driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        testSetup.driver.switchTo().window(childWindow);
    }
}
