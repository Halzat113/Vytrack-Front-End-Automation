package com.vytrack.stepDefs;

import com.utilities.Driver;
import static com.utilities.JsonReader.*;

import com.utilities.GlobalData;
import io.cucumber.java.*;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    GlobalData data = new GlobalData();
    @Before
    public void setupScenario(Scenario scenario){
        data.setScenarioName(scenario.getName());
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(getSingleString("url"));
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
