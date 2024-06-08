package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
    @Before("@NetBanking")
    public void netBankingSetup() {
        System.out.println("set up the entries in NetBanking database");
    }

    @Before("@Mortgage")
    public void mortgageSetup() {
        System.out.println("set up the entries in Mortgage database");
    }

    @After
    public void tearDown() {
        System.out.println("clear the entries");
    }
}
// Before -> Background -> Scenarios -> After