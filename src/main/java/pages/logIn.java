package pages;

import utils.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class logIn extends AbstractPage {

    public WebElement emailaddress()
    {
        return waitForUnstableElement(By.id("email"));
    }

    public WebElement password()
    {
        return waitForUnstableElement(By.id("passwd"));
    }

    public WebElement signButton()
    {
        return waitForUnstableElement(By.id("SubmitLogin"));
    }

}

