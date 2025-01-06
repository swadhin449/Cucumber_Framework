package org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DataDrivenSearchPage {
    WebDriver driver;
    // Constructor
    public DataDrivenSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements
    }
    // Locate elements using @FindBy annotation
    @FindBy(xpath = "//textarea[@id='APjFqb']")
    WebElement searchText;

    @FindBy(xpath = "//div[@class='iblpc']")
    WebElement clickBtn;
    @FindBy(xpath = "//div[@id='Alh6id']//li")
    List<WebElement> searchLists;

    //Action Methods
    public void enterTextOnSearchField(String searchData){
        searchText.sendKeys(searchData);
    }
    public void clickOnBtn(){
        clickBtn.click();
    }
    public void clickOnList(String resultString){
        for(WebElement ele:searchLists){
            if(ele.getText().equalsIgnoreCase(resultString)){
                ele.click();
                break;
            }
        }
    }
}
