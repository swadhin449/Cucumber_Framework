package org.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Locate elements using @FindBy annotation
    @FindBy(xpath = "//textarea[@id='APjFqb']")
    WebElement searchTextBox;

    @FindBy(xpath = "//div[@class='iblpc']")
    WebElement searchBtn;
    @FindBy(xpath = "//div[@id='Alh6id']//li")
    List<WebElement> searchList;

    //Action Methods
    public void enterTextOnSearchBox(){
        searchTextBox.sendKeys("Selenium");
    }
    public void clickSearchBtn(){
        searchBtn.click();
    }
    public void clickOnSearchList(){
        for(WebElement ele:searchList){
            if(ele.getText().equalsIgnoreCase("Selenium")){
                ele.click();
                break;
            }
        }
    }
}