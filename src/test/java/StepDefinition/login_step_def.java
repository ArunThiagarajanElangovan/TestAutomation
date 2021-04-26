package StepDefinition;

import BaseDef.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.logIn;
import cucumber.api.java.en.Given;
import pages.logIn;
import pages.Tshirt;
import pages.personal_Information;



public class login_step_def extends BaseStepDef {

    private logIn login = new logIn();
    private Tshirt tshirt = new Tshirt();
    private personal_Information Personal = new personal_Information();


    @Given("^user lands on login page$")
    public void launchBroswer() throws Throwable {
        {
            getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        }
    }

    @When("^user enters email address and password$")
    public void logindetails() throws Throwable {
        login.emailaddress().sendKeys("arunthiagarajan17@gmail.com");
        login.password().sendKeys("automation@01");
        login.signButton().click();
    }

    @And("^clicked T Shirt link, selected T Shirt and added to cart by accpeting T&C$")
    public void Tshirt() throws Throwable {
        tshirt.tShirtLink().click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");
        Actions a1 = new Actions(getDriver());
        a1.moveToElement(tshirt.category());
        tshirt.proceedTocheckout().click();
        tshirt.proceedTocheckout().click();
        tshirt.proceedTocheckout().click();
        tshirt.termsAndConditions().click();
        tshirt.proceedTocheckout().click();
        ;
    }

    @Then("^make payment by Bank wire and confirm Order$")
    public void orderConfirmation() throws Throwable {
        tshirt.paymentBywire().click();
        tshirt.confirmOrder().click();
        ;
        tshirt.verifyorder();

    }

    @And("^Click on First name on right top corner$")
    public void clickPersonalDetails() throws Throwable {
        Personal.personalDetails().click();
    }

    @Then("^Changed personal information of first name$")
    public void Details() throws Throwable{
        Personal.myAccount().click();
        Personal.firstName().clear();
        Personal.firstName().sendKeys("Arun");
        Personal.currentPassword().sendKeys("automation@01");
        Personal.saveButton().click();
    }


}