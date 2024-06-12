package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ConfirmationPage {
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By agreeCheckbox = By.cssSelector(".chkAgree");
    private By selectOptions = By.cssSelector("select");
    private By proceedBtn = By.cssSelector(".wrapperTwo > button");
    private By confirmationMessage = By.cssSelector(".wrapperTwo > span");

    public void selectCheckbox() {
        driver.findElement(agreeCheckbox).click();
    }

    public void selectCountry(String country) {
        Select countries = new Select(driver.findElement(selectOptions));
        countries.selectByVisibleText(country);
    }

    public void selectProceedBtn() throws InterruptedException {
        driver.findElement(proceedBtn).click();
        Thread.sleep(500);
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationMessage).getText();
    }

    public boolean isOnLandingPage() throws InterruptedException {
        Thread.sleep(5000);
        return driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
}
