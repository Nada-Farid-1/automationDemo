package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D01_registerStepDef {
    Random rand = new Random(); //instance of random class
    int upperbound = 150;
    //generate random values from 0-24
    int int_random = rand.nextInt(upperbound);
    SoftAssert softAssert = new SoftAssert();
    P01_register regr = new P01_register();
    @Given("user goto register page")
    public void goToRegisterPage() throws InterruptedException {
        regr.registerlink().click();
        Thread.sleep(2000);
    }
    @When("user select a gender type")

    public void selectAGender() throws InterruptedException {
        regr.genderSelector().click();
        Thread.sleep(2000);
    }

    @And("user enter first name {string} and last name {string} field")
    public void userEnterFirstNameAndLastNameField(String arg0, String arg1) {
        regr.firstName().sendKeys(arg0);
        regr.lastName().sendKeys(arg1);
    }

    @And("user enter the date of birth")
    public void enterBirth() throws InterruptedException {
        Select droplistDay = new Select(regr.dayOfBirth());
        Select droplistMonth =new Select(regr.monthOfBirth());
        Select droplistYear= new Select(regr.yearOfBirth());
        Thread.sleep(2000);
        droplistDay.selectByValue("18");
        Thread.sleep(2000);
        droplistMonth.selectByValue("8");
        Thread.sleep(2000);
        droplistYear.selectByValue("1940");

    }

    @And("user enter email {string}")
    public void userEnterEmail(String arg0) {
        regr.userEmail().sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string} fields")
    public void userFillsPasswordFieldsFields(String arg0, String arg1) {
        regr.password().sendKeys(arg0);
        regr.confirmPassword().sendKeys(arg1);
    }
    @And("user clicks on the register button")
    public void registerBtn()
    {
        regr.registerButton().click();
    }
    @Then("verify success message is displayed")
    public void verifymessage()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String successExpectedMessage="Your registration completed";
        String actualMessage=regr.statusMessage().getText();
        System.out.println(actualMessage);
        System.out.println(regr.statusMessage().getCssValue("color"));
        softAssert.assertEquals(successExpectedMessage,actualMessage);
        softAssert.assertEquals(regr.statusMessage().getCssValue("color"),"rgba(76, 177, 124, 1)");
      //  regr.statusMessage().getCssValue("background-color")
        softAssert.assertAll();
    }
}
