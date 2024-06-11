package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestSetup;

public class CheckoutPageStepDefs {
    private TestSetup testSetup;
    private boolean isOnCheckoutPage;
    private CheckoutPage checkoutPage;

    public CheckoutPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
    }

    @Then("the user sees the quantity {string} of the product {string} in their cart")
    public void the_user_sees_the_quantity_of_the_product_in_their_cart(String amountString, String productString) throws InterruptedException {
        switchToCheckoutPage();
        checkoutPage = testSetup.getPageObjectManager().getCheckoutPage();
        String productName = checkoutPage.getProductName();
        int quantity = checkoutPage.getQuantity();
        Assert.assertTrue(Integer.parseInt(amountString) == quantity && productString.equalsIgnoreCase(productName));
    }

    @Then("can enter a promo code and place the order")
    public void can_enter_a_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
    }

    public void switchToCheckoutPage() throws InterruptedException {
        isOnCheckoutPage = testSetup.getGenericUtils().getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        if (!isOnCheckoutPage) {
            LandingPage landingPage = testSetup.getPageObjectManager().getLandingPage();
            landingPage.selectCartIcon();
            landingPage.goToCheckout();
            testSetup.getGenericUtils().switchWindowToChild();
        }
    }
}
