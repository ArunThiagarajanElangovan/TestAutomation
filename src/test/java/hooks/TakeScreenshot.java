package hooks;

import BaseDef.BaseStepDef;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeScreenshot extends BaseStepDef {

    protected static final Logger LOG = LoggerFactory.getLogger(TakeScreenshot.class);

    @After()
    public void afterTest(Scenario scenario) throws InterruptedException {
        LOG.info("Taking screenshot IF Test Failed");
        System.out.println("Taking screenshot IF Test Failed (sysOut)");
        if (scenario.isFailed()) {
            try {
                System.out.println("Scenario FAILED... screen shot taken");
                scenario.write(getDriver().getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    @Before()
    public void beforeScenario() {
        getDriver().manage().window().maximize();
    }

}