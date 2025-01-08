package org.PageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@title='Your Store']")
    WebElement openCartLogo;
    @FindBy(name = "search")
    WebElement searchTextBox;
    @FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
    WebElement searchBtn;

    public void visibleOpenCartLogo(){
        boolean value = openCartLogo.isDisplayed();
        System.out.println("OpenCart Logo is displayed: "+value);
    }
    public void enterTextOnSearchField(){
        searchTextBox.sendKeys("iPhone");
    }
    public void clickOnSearchBtn(){
        searchBtn.click();
    }

}
