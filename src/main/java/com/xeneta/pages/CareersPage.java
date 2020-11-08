package com.xeneta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//a[text()='Visit']")
    private List<WebElement> companyLocationsLinks;

    @FindBy(xpath = "//h4[contains(text(),'Open application')]")
    private WebElement openApplicationText;

    @FindBy(css = "a[href*='xeneta.bamboohr.com']")
    private WebElement applyHereLink;


    public int getCompanyLocationVisitLinks() {
        waitForElement(companyLocationsLinks.get(0));
        return companyLocationsLinks.size();
    }


    public void selectOpenApplication() {
        waitAndClick(openApplicationText);
    }

    public boolean isApplyHereLinkDisplayed() {
        waitForElement(applyHereLink);
        return applyHereLink.isDisplayed();
    }

}
