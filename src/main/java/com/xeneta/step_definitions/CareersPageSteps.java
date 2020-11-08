package com.xeneta.step_definitions;

import com.xeneta.pages.CareersPage;
import com.xeneta.utilities.Driver;
import com.xeneta.utilities.LoggerUtil;
import com.xeneta.utilities.ReadDataFormProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class CareersPageSteps {

    private static final Logger logger = LoggerUtil.getLogger(CareersPage.class);

    CareersPage careersPage = new CareersPage();

    @Given("user is on the careers page")
    public void user_is_on_the_careers_page() {
        String careersUrl = ReadDataFormProperties.getProperty("qaUrl");
        logger.info("URL :: " + careersUrl);
        Driver.getDriver().get(careersUrl);
    }

    @Then("user look for company locations")
    public void user_look_for_company_locations() {
        logger.info("verifying the locations count ");
        Assert.assertEquals("location visit links are not displayed", 3, careersPage.getCompanyLocationVisitLinks());

    }


    @When("user opens a open application")
    public void user_opens_a_open_application() {
        logger.info("selecting the open application ");
        careersPage.selectOpenApplication();
    }

    @Then("user should see apply here link")
    public void user_should_see_apply_here_link() {
        Assert.assertTrue("apply here option is not displayed", careersPage.isApplyHereLinkDisplayed());
    }
}
