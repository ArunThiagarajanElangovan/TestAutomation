package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import java.util.List;


public abstract class AbstractPage {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
    private int DRIVER_WAIT_TIME = 10;
    private static final int DEBUG_WAIT = 1000;
    private static final String LOG_CONTEXT = "context";
    public static RemoteWebDriver getDriver;
    public HashMap<String, WebElement> commonElements = new HashMap<>();

    public AbstractPage() {
        getDriver = WebDriverDiscovery.getRemoteWebDriver();
    }


    public WebElement findElement(By by)
    {
        return getDriver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver.findElements(by);
    }

    public WebElement waitForUnstableElement(By by) {
        try {
            Thread.sleep(DEBUG_WAIT);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
        return waitForElementPresent(by);
    }

    public WebElement waitForElementPresent(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, DRIVER_WAIT_TIME);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (UnhandledAlertException | NoAlertPresentException e) {
            LOG.info(LOG_CONTEXT, e);
            getDriver.switchTo().alert().dismiss();
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }


    public WebElement waitForElementToBeClickableAndReturnElement(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, DRIVER_WAIT_TIME, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return getDriver.findElement(by);
    }

    public WebElement waitForExpectedElement(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, timeout);
        wait.until(visibilityOfElementLocated(by));
        return getDriver.findElement(by);
    }


    public WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    Thread.sleep(DEBUG_WAIT);
                } catch (InterruptedException e) {
                    LOG.error(e.getMessage());
                }
                WebElement element = getDriver.findElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }


    public List<WebElement> waitForElementsVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }



    public void btnClick(WebElement btn)
    {
        getDriver.executeScript("arguments[0].click();", btn);
    }



}
