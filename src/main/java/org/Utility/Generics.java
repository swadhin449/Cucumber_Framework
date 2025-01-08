package org.Utility;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Generics {
    public static void scrollPage(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        // Wait for additional content to load
        try {
            Thread.sleep(2000); // Pause for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
