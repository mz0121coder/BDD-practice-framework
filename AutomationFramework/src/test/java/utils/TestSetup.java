package utils;

import pageObjects.PageObjectManager;

public class TestSetup {
    private String landingPageProductName;
    private PageObjectManager pageObjectManager;
    private TestBase testBase;
    private GenericUtils genericUtils;

    public TestSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }

    public String getLandingPageProductName() {
        return landingPageProductName;
    }

    public void setLandingPageProductName(String landingPageProductName) {
        this.landingPageProductName = landingPageProductName;
    }

    public GenericUtils getGenericUtils() {
        return genericUtils;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
