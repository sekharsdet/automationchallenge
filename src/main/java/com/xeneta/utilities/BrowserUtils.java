package com.xeneta.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;


public class BrowserUtils {

    private static final Logger logger = LoggerUtil.getLogger(BrowserUtils.class);

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static byte[] getScreenshot(String name) {
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        String path = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        logger.info("find screenshot here: " + path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot and save it as a file
        byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return image;
    }
}
