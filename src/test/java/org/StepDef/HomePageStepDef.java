package org.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PageObjects.HomePage;
import org.Utility.BrowserUtility;
import org.Utility.Generics;
import org.Utility.PropertiesFileReader;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePageStepDef {
    WebDriver driver;
    HomePage hp ;
    @Given("Open chrome browser and Open OpenCart Webpage")
    public void openChromeBrowser() throws IOException {
        driver = BrowserUtility.openBrowser(driver,
                PropertiesFileReader.fetchBrowserPropertyValue("browser.name"),
                PropertiesFileReader.fetchBrowserPropertyValue("browser.baseUrl"));
    }
    @When("Validate OpenCart Logo")
    public void validateOpenCartLogo() throws InterruptedException {
        hp = new HomePage(driver);
        hp.visibleOpenCartLogo();
        Thread.sleep(2000);
        hp.enterTextOnSearchField();
        Thread.sleep(2000);
        hp.clickOnSearchBtn();
        Thread.sleep(10000);
        Generics.scrollPage(driver);
    }
    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
