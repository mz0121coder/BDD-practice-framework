package stepDefinitions;

import io.cucumber.java.After;
import utils.TestSetup;

public class Hooks {
    private TestSetup testSetup;

    public Hooks(TestSetup testSetup) {
        this.testSetup = testSetup;
    }

    @After
    public void AfterScenario() throws InterruptedException {
        testSetup.getGenericUtils().quitDriver();
    }
}
