package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    P03_homePage cat = new P03_homePage();
    String expectedCat;
    @Given ("user in Home Page and there are 3 main categories contains sub-categories")
    public void HomeHasCategoriy() {
        cat.hometext().isDisplayed();
        cat.mainCategory1().isDisplayed();
    }
    @When("user select a category by hover on on it")
    public void hoverMainCat() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(cat.mainCategory1()).perform();
        Thread.sleep(4000);
    }
    @And("user select a subcatgoriy by click on it")
    public void clickSubCat()
    {
        expectedCat= cat.subCategory1().getText();
        cat.subCategory1().click();
    }
    @And ("user get the name if the page title")
    public String pageTitle()
    {
     return  cat.pageCategoryTitle().getText();
    }

    @Then("user verify that the sub-category title as the the selected random sub-category")
    public void verifyTitle() {Assert.assertEquals(pageTitle(),expectedCat);}
}
