package org.StepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PageObjects.SearchPage;
import org.Utility.BrowserUtility;
import org.Utility.PropertiesFileReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SearchStepDef {
    WebDriver driver;
    //SearchPage sp;
    @Given("^Open chrome browser and enter url$")
    public void openChromeBrowserAndEnterUrl() throws IOException {
        driver = BrowserUtility.openBrowser(driver, PropertiesFileReader.fetchBrowserPropertyValue("browser.name"),PropertiesFileReader.fetchBrowserPropertyValue("browser.baseUrl"));
    }
    @When("^Enter search criteria$")
    public void enterSearchCriteria() throws InterruptedException {
        new SearchPage(driver).enterTextOnSearchBox();
        Thread.sleep(2000);
    }
    @Then("^Click on search button$")
    public void clickOnSearchButton() throws InterruptedException {
        new SearchPage(driver).clickSearchBtn();
        Thread.sleep(2000);
        new SearchPage(driver).clickOnSearchList();
        Thread.sleep(3000);
        driver.quit();
    }

}
