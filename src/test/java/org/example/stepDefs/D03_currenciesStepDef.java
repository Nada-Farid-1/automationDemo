package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage  currency = new P03_homePage();

    @Given("verify user go to Home page")
    public void homePage()  {
        String expectedText="Welcome to our store";
        String actualText= currency.hometext().getText();
        Assert.assertEquals(actualText,expectedText);
    }
    @When("user select currency type")

    public void selectCurrency() throws InterruptedException {

        Select droplist =new Select(currency.customerCurrency());
        Thread.sleep(2000);
        droplist.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    @Then("user can show the changed currency")
    public void verifySwitchCurrency()
    {

        String actualCurrency = currency.selectedCurrency().getText();
        Assert.assertEquals(actualCurrency,"Euro");

    }
    @And("user showed the Euro Symbol \\(€) is shown on the four products displayed in Home page")
    public void verifyCurrencyPrice() {
        for (int i = 0; i < currency.itemPrice().size(); i++) {
            System.out.println(currency.itemPrice().get(i).getText());
            Assert.assertTrue(currency.itemPrice().get(i).getText().contains("€"));
        }
    }

}
