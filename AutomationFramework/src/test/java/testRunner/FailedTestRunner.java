package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "stepDefinitions", monochrome = true, plugin = {"pretty", "html:target/reports/report.html", "json:target/reports/report.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt"}, dryRun = false
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
