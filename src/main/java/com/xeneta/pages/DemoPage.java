package com.xeneta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoPage extends BasePage {

    @FindBy(xpath = "(//a[@href='#form-popup-1' and text()='Schedule Now'])[2]")
    private WebElement scheduleNowButton;

    @FindBy(xpath = "//a[@href='#form-popup-2' and text()=' Watch Now']")
    private WebElement watchNowButton;

    @FindBy(xpath = "(//a[@href='#form-popup-3' and text()='Sign up here'])[2]")
    private WebElement signUpHereButton;

    @FindBy(xpath = "(//input[@name='firstname'])[3]")
    private WebElement firstNameFiled;

    @FindBy(xpath = "(//input[@name='lastname'])[3]")
    private WebElement lastNameFiled;

    @FindBy(xpath = "(//input[@name='company'])[3]")
    private WebElement companyNameField;

    @FindBy(xpath = "(//input[@name='email'])[3]")
    private WebElement businessEmailField;

    @FindBy(name = "phone")
    private WebElement phoneNumberField;

    @FindBy(xpath = "(//input[@name='jobtitle'])[2]")
    private WebElement jobTitleField;

    @FindBy(xpath = "(//select[@name='type_of_prospect'])[2]")
    private WebElement companyTypeSelect;

    @FindBy(xpath = "(//select[@name='i_ship_'])[2]")
    private WebElement companyShipSelect;

    @FindBy(xpath = "(//input[@name='confirm_opt_in'])[3]")
    private WebElement agreePrivacyPolicyCheckbox;

    @FindBy(css = "[value='Get 1-to-1 Demo']")
    private WebElement get1to1DemoButton;

    @FindBy(css = "label.hs-error-msg")
    private List<WebElement> mandatoryFieldsErrorMessages;

    @FindBy(css = "[value='WATCH VIDEOS']")
    private WebElement watchVideosButton;

    /**
     * fill One To One Demo Form at once
     * @param userDetails
     */
    public void fillOneToOneDemoForm(List<String> userDetails) {
        waitAndEnterValue(firstNameFiled, userDetails.get(0));
        waitAndEnterValue(lastNameFiled, userDetails.get(1));
        waitAndEnterValue(companyNameField, userDetails.get(2));
        waitAndEnterValue(businessEmailField, userDetails.get(3));
        waitAndEnterValue(phoneNumberField, userDetails.get(4));
        waitAndEnterValue(jobTitleField, userDetails.get(5));
        waitAndEnterValue(firstNameFiled, userDetails.get(0));
        Select companyType = new Select(companyTypeSelect);
        companyType.selectByValue(userDetails.get(6));
        Select shipType = new Select(companyShipSelect);
        shipType.selectByValue(userDetails.get(7));
        waitAndClick(agreePrivacyPolicyCheckbox);
    }

    /**
     * open OneToOneDemo Form
     */
    public void openOneToOneDemoForm() {
        waitAndClick(scheduleNowButton);
    }

    public void submitOneToOneForm() {
        waitAndClick(get1to1DemoButton);
    }

    public boolean isOneToOneDemoFormDisplayed() {
        waitForElement(get1to1DemoButton);
        return get1to1DemoButton.isDisplayed();
    }

    public int getMandatoryFieldsErrorMessagesCount() {
        waitForElement(mandatoryFieldsErrorMessages.get(0));
        return mandatoryFieldsErrorMessages.size();
    }

    public void openWatchVideosForm() {
        waitAndClick(watchNowButton);
    }

    public void submitWatchVideoForm() {
        waitAndClick(watchVideosButton);
    }

    public boolean isWatchVideoFormDisplayed() {
        waitForElement(watchVideosButton);
        return watchVideosButton.isDisplayed();
    }

    /**
     * fill watch video form at once
     * @param userDetails
     */
    public void fillWatchVideosForm(List<String> userDetails) {
        waitAndEnterValue(firstNameFiled, userDetails.get(0));
        waitAndEnterValue(lastNameFiled, userDetails.get(1));
        waitAndEnterValue(companyNameField, userDetails.get(2));
        waitAndEnterValue(businessEmailField, userDetails.get(3));
        waitAndClick(agreePrivacyPolicyCheckbox);
    }
}
