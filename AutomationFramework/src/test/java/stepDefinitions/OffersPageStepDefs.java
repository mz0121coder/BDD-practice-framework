package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestSetup;

public class OffersPageStepDefs {
    private TestSetup testSetup;
    private String offersPageProductName;
    private OffersPage offersPage;
    private boolean isOnOffersPage;

    public OffersPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
    }

    @And("the user searches again for {string} on the Offers page")
    public void the_user_searches_again_for_on_the_offers_page(String string) throws InterruptedException {
        switchToOffersPage();
        offersPage = testSetup.getPageObjectManager().getOffersPage();
        offersPage.searchProduct(string);
        offersPageProductName = offersPage.getProductName();
    }

    @Then("the product {string} is displayed on both pages")
    public void the_product_is_displayed_on_both_pages(String string) {
        Assert.assertEquals(testSetup.getLandingPageProductName(), offersPageProductName);
    }

    public void switchToOffersPage() {
        isOnOffersPage = testSetup.getGenericUtils().getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        if (!isOnOffersPage) {
            LandingPage landingPage = testSetup.getPageObjectManager().getLandingPage();
            landingPage.selectTopDealsPage();
            testSetup.getGenericUtils().switchWindowToChild();
        }
    }
}
