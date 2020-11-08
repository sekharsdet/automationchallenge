package com.xeneta.step_definitions;

import com.xeneta.utilities.BrowserUtils;
import com.xeneta.utilities.Driver;
import com.xeneta.utilities.LoggerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

public class TestHooks {
    private static final Logger logger = LoggerUtil.getLogger(TestHooks.class);

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] image = BrowserUtils.getScreenshot(scenario.getName());
            logger.info("attaching the screenshot to feature file");
            scenario.attach(image, "image/png", scenario.getName());
        }
        logger.info("Test clean up");
        Driver.closeDriver();
    }
}
