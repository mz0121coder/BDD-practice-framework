package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MainSteps {
    @Given("the user is on the NetBanking landing page")
    public void the_user_is_on_the_net_banking_landing_page() {
        System.out.println("the user is on the NetBanking landing page");
    }

    @When("the user logs in to the application with username {string} and password {string}")
    public void the_user_logs_in_to_the_application_with_username_and_password(String username, String password) {
        System.out.println("username is " + username + " and password is " + password);
    }

    @Then("NetBanking's home page is displayed")
    public void net_banking_s_home_page_is_displayed() {
        System.out.println("NetBanking's home page is displayed");
    }

    @Then("cards are displayed")
    public void cards_are_displayed() {
        System.out.println("cards are displayed");
    }

    @Given("the user is on practice landing page")
    public void the_user_is_on_practice_landing_page() {
        System.out.println("the user is on practice landing page");
    }

    @When("the user signs up")
    public void the_user_signs_up(List<String> data) {
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
    }

    @Given("entries are set up in the database")
    public void entriesAreSetUpInTheDatabase() {
        System.out.println("entries are set up in the database");
    }

    @And("the browser is launched from config variables")
    public void theBrowserIsLaunchedFromConfigVariables() {
        System.out.println("the browser is launched from config variables");
    }

    @And("hit the home page url of the banking site")
    public void hitTheHomePageUrlOfTheBankingSite() {
        System.out.println("hit the home page url of the banking site");
    }
}
