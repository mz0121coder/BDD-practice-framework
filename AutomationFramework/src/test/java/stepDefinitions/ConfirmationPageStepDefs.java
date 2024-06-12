package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import utils.TestSetup;

public class ConfirmationPageStepDefs {
    private TestSetup testSetup;
    private boolean isOnConfirmationPage;
    private ConfirmationPage confirmationPage;

    public ConfirmationPageStepDefs(TestSetup testSetup) {
        this.testSetup = testSetup;
        this.confirmationPage = testSetup.getPageObjectManager().getConfirmationPage();
    }

    @Then("agrees to the terms & conditions and selects the country {string}")
    public void agrees_to_the_terms_conditions_and_selects_the_country(String string) throws InterruptedException {
        switchToConfirmationPage();
        confirmationPage.selectCheckbox();
        confirmationPage.selectCountry(string);
        confirmationPage.selectProceedBtn();
    }

    @Then("proceeds to view a confirmation of the order")
    public void proceeds_to_view_a_confirmation_of_the_order() {
        String orderConfirmText = confirmationPage.getConfirmationText();
        Assert.assertTrue(orderConfirmText.toLowerCase().contains("your order has been placed"));
    }

    @Then("the user is redirected to the GreenKart landing page")
    public void the_user_is_redirected_to_the_green_cart_landing_page() throws InterruptedException {
        Assert.assertTrue(confirmationPage.isOnLandingPage());
    }

    public void switchToConfirmationPage() throws InterruptedException {
        isOnConfirmationPage = testSetup.getGenericUtils().getCurrentUrl()
                .equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/country");
        if (!isOnConfirmationPage) {
            CheckoutPage checkoutPage = testSetup.getPageObjectManager().getCheckoutPage();
            checkoutPage.placeOrder();
            testSetup.getGenericUtils().switchWindowToChild();
        }
    }
}
