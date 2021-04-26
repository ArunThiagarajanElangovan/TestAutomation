package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class WebDriverDiscovery extends EventFiringWebDriver {


    public static RemoteWebDriver remoteWebDriver = setDriver();

    public WebDriverDiscovery() {
        super(remoteWebDriver);
    }

    public static RemoteWebDriver getRemoteWebDriver() {
        return remoteWebDriver;
    }

    private static RemoteWebDriver setDriver() {
        switch (System.getProperty("driverType")) {
            case "firefox":
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();
            case "chrome":
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }

}