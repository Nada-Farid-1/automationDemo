package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D04_searchStepDef {
    P03_homePage testsearch = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();
    String subtitlesearch;
    @When("user click on search field")
    public void goSearchPage1() throws InterruptedException {
        Thread.sleep(2000);
        testsearch.searchField().click();
    }
    String keyword;
    @And("user enter product name {string} in search field")
    public void userEnterProductNameSearch(String arg0) {
        testsearch.searchField().sendKeys(arg0);
        keyword = arg0;
    }
    @And("user click on enter to show search result")
    public void enterSearch1()
    {
        testsearch.searchField().sendKeys(Keys.ENTER);
    }

    @And("user enter product sku {string} in search field")
    public void userEnterProductSkuSearch(String arg0) throws InterruptedException {
        testsearch.searchField().sendKeys(arg0);
        Thread.sleep(5000);
        testsearch.searchresultonfield().click();
        Thread.sleep(2000);
        keyword=arg0;
    }


    @Then("user can show the search result")
    public void showResult1()
    {
       String actualSearchName = testsearch.redirectGetCurrenturl();
        String expectedSearchUrlName =keyword;
        softAssert.assertTrue(actualSearchName.contains(expectedSearchUrlName));
        for(int i= 0;i<testsearch.searchItemsCount();i++)
        {
          softAssert.assertTrue((testsearch.searchItems().get(i).getText()).toLowerCase().contains(keyword));
        }
        softAssert.assertAll();
    }
    @Then("user can show the PDP for entered sku")
    public void showPDP()
    {
        String actualskuValue= testsearch.skuPDP().getText();
        Assert.assertEquals(actualskuValue,keyword);
    }

}
