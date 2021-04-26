package pages;
import utils.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class personal_Information extends AbstractPage {

    public WebElement personalDetails() {
        return waitForElementVisible(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"));

    }

    public WebElement myAccount(){

        return waitForElementVisible(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span"));

    }


    public WebElement firstName() {
        return waitForElementVisible(By.id("firstname"));

    }

   public WebElement currentPassword(){

       return waitForElementVisible(By.id("old_passwd"));
   }

    public WebElement saveButton(){

        return waitForElementVisible(By.xpath("//*[@id='center_column']/div/form/fieldset/div[11]/button/span"));

    }



}
