package com.xeneta.pages;

import com.xeneta.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method will help you to click on element with the help of explicit wait
     *
     * @param element
     */
    public void waitAndClick(WebElement element) {
        waitForElement(element);
        element.click();
    }

    /**
     * This method will help you to enter text with the help of explicit wait
     *
     * @param element
     * @param value
     */
    public void waitAndEnterValue(WebElement element, String value) {
        waitForElement(element);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * JavaScript click , where normal java selenium click is not working
     *
     * @param element
     */
    public static void waitAndClickWithJavaScript(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will helpful
     * driver to wait for specific time
     *
     * @param milliSeconds
     */
    public void waitForSomeTime(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
