package com.xeneta.step_definitions;

import com.xeneta.pages.DemoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class WatchVideosSteps {

    DemoPage demoPage = new DemoPage();

    @When("user clicks on watch now")
    public void user_clicks_on_watch_now() {
        demoPage.openWatchVideosForm();
    }

    @Then("watch videos form will render")
    public void watch_videos_form_will_render() {
        Assert.assertTrue("watch videos form is not displayed", demoPage.isWatchVideoFormDisplayed());

    }

    @Then("user submits the form")
    public void user_submits_the_form() {
        demoPage.submitWatchVideoForm();
    }

    @Then("user enters required fields on the watch videos from")
    public void user_enters_required_fields_on_the_watch_videos_from(DataTable dataTable) {
        List<String> userDetails = dataTable.asList();
        demoPage.fillWatchVideosForm(userDetails);
    }

    @Then("user submits the watch videos form")
    public void user_submits_the_watch_videos_form() {
        demoPage.submitWatchVideoForm();
    }

    @Then("all error messages should displayed on watch videos from")
    public void all_error_messages_should_displayed_on_watch_videos_from() {
        Assert.assertEquals("watch videos form error messages are not displayed", demoPage.getMandatoryFieldsErrorMessagesCount(), 5);

    }

}
