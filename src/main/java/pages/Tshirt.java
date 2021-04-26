package pages;

import utils.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class Tshirt extends AbstractPage {

    public WebElement tShirtLink() {
        return waitForElementVisible(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"));
    }

    public WebElement addTocart() {
        return waitForElementVisible(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"));

    }

    public WebElement proceedTocheckout() {

        return waitForElementVisible(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
    }


    public WebElement category() {

        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='category']"));
    }

    public WebElement termsAndConditions() {

        return waitForElementToBeClickableAndReturnElement(By.id("order"));
    }

    public WebElement paymentBywire() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));

    }

    public WebElement confirmOrder() {

        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='cart_navigation']/button/span[1]"));

    }

    public WebElement verifyorder() {

        return waitForElementPresent(By.xpath("//*[@id='center_column']/div/p/strong"));

    }
}

