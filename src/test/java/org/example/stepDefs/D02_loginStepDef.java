package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class D02_loginStepDef {
    P02_login logtest = new  P02_login();
    SoftAssert softAss= new SoftAssert();
    @Given("user go to login page test")
    public void goLoginPage() throws InterruptedException {
        logtest.loginLink().click();
        Thread.sleep(2000);
    }

    @When("user login with {string} {string} and {string}")
    public void userLogin(String arg0, String arg1, String arg2) {
        System.out.println(arg0);
        logtest.emailField().sendKeys(arg1);
        logtest.passwordField().sendKeys(arg2);
    }

    @And("user press on login button")
    public void loginButton()
    {
        logtest.loginButton().click();
    }
    @Then("user login to the system successfully")
    public void verifySuccessLogin()
    {
        softAss.assertEquals(logtest.currentLoginURL(),"https://demo.nopcommerce.com/");
        logtest.myAccountlabel().isDisplayed();
        logtest.toggelLogoutButton().isDisplayed();
        softAss.assertAll();
    }
    @Then("user could not login to the system")
    public void verifyFaildLogin()
    {
        System.out.println("before");
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(logtest.faildLogin().getText());
        softAss.assertTrue(logtest.faildLogin().getText().contains("Login was unsuccessful."),"Softasseertion ist fail");
        System.out.println(Color.fromString(logtest.faildLogin().getCssValue("color")).asHex());
        softAss.assertEquals(Color.fromString(logtest.faildLogin().getCssValue("color")).asHex(),"#e4434b","Softassertion 2nd failed ");
        softAss.assertAll();
    }

}

