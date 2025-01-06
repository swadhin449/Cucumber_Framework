package org.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.PageObjects.DataDrivenSearchPage;
import org.PageObjects.SearchPage;
import org.Utility.BrowserUtility;
import org.Utility.PropertiesFileReader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DataDrivenSearchStepDef {
    WebDriver driver;
    @Given("^Open chrome browser and enter URL$")
    public void openChromeBrowserAndEnterUrl() throws IOException {
        driver = BrowserUtility.openBrowser(driver, PropertiesFileReader.fetchBrowserPropertyValue("browser.name"),PropertiesFileReader.fetchBrowserPropertyValue("browser.baseUrl"));
    }
    @When("Search selenium tutorial {string}")
    public void searchSeleniumTutorial(String searchString) throws InterruptedException {
        new DataDrivenSearchPage(driver).enterTextOnSearchField(searchString);
        Thread.sleep(2000);
    }
    @Then("^Click on Search button$")
    public void clickOnSearchButton() throws InterruptedException {
        new DataDrivenSearchPage(driver).clickOnBtn();
        Thread.sleep(2000);
    }
    @Then("Validate search results {string}")
    public void validateSearchResults(String resultString) throws InterruptedException {
        new DataDrivenSearchPage(driver).clickOnList(resultString);
        Thread.sleep(2000);
        driver.quit();
    }

}
