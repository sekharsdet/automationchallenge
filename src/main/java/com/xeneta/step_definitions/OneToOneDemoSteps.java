package com.xeneta.step_definitions;

import com.xeneta.pages.DemoPage;
import com.xeneta.utilities.Driver;
import com.xeneta.utilities.LoggerUtil;
import com.xeneta.utilities.ReadDataFormProperties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class OneToOneDemoSteps {
    private static final Logger logger = LoggerUtil.getLogger(OneToOneDemoSteps.class);

    DemoPage demoPage = new DemoPage();

    @Given("user is on the demo page")
    public void user_is_on_the_demo_page() {
        String demoUrl = ReadDataFormProperties.getProperty("testUrl");
        logger.info("URL :: " + demoUrl);
        Driver.getDriver().get(demoUrl);
    }

    @When("user clicks on schedule now")
    public void user_clicks_on_schedule_now() {
        demoPage.openOneToOneDemoForm();
    }

    @Then("one to one demo form will render")
    public void one_to_one_demo_form_will_render() {
        Assert.assertTrue("one to one demo form is not displayed", demoPage.isOneToOneDemoFormDisplayed());
    }

    @Then("user enters required fields on the from")
    public void user_enters_required_fields_on_the_from(DataTable dataTable) {
        List<String> userDetails = dataTable.asList();
        demoPage.fillOneToOneDemoForm(userDetails);
    }

    @When("user clicks on get one to one demo")
    public void user_clicks_on_get_one_to_one_demo() {
        demoPage.submitOneToOneForm();
    }

    @Then("one to one demo should scheduled")
    public void one_to_one_demo_should_scheduled() {
        //Through selenium we cannot automate recaptcha
    }


    @Then("all error messages should displayed")
    public void all_error_messages_should_displayed() {
        Assert.assertEquals("one to one demo form error messages are not displayed", demoPage.getMandatoryFieldsErrorMessagesCount(), 9);
    }
}