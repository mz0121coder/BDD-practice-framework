package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestSetup;

public class LandingPageStepDefs {
    private TestSetup testSetup;
    private LandingPage landingPage;

    public LandingPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
        this.landingPage = testSetup.getPageObjectManager().getLandingPage();
    }

    @Given("the user is on the GreenKart landing page")
    public void the_user_is_on_the_green_cart_landing_page() {
        String url = testSetup.getGenericUtils().getCurrentUrl();
        Assert.assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/", url);
    }

    @When("the user searches for {string} on the Home page")
    public void the_user_searches_for_on_the_home_page(String string) throws InterruptedException {
        landingPage.searchItem(string);
        if (landingPage.getProductName() != null)
            testSetup.setLandingPageProductName(landingPage.getProductName());
    }

    @When("the user adds {string} of the product to their cart and goes to checkout")
    public void the_user_adds_of_the_product_to_their_cart_and_goes_to_checkout(String string)
            throws InterruptedException {
        int quantity = Integer.parseInt(string);
        landingPage.incrementItem(quantity);
        landingPage.addToCart();
        landingPage.selectCartIcon();
        landingPage.goToCheckout();
    }
}
