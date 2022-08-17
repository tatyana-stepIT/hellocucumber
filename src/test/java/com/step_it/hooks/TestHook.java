package com.step_it.hooks;

import com.step_it.utils.PropertyReader;
import io.cucumber.java.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.step_it.utils.LocalWebDriverManager.getDriver;
import static com.step_it.utils.LocalWebDriverManager.quitDriver;

@Slf4j
@AllArgsConstructor
public class TestHook {

    @Before(order = 0, value = "@Start")
    public void startBrowser() {
        getDriver().get(PropertyReader.getConfigProperty("url"));
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Starting scenario: {}", scenario.getName());
        log.info("Scenario tag {}", scenario.getSourceTagNames());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed");
        }
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        log.info("Finished scenario: {}", scenario.getName());
    }

    @After(value = "@Stop")
    public void driverTearDown(Scenario scenario) {
        log.info("Quitting the driver");
        quitDriver();
    }
}
