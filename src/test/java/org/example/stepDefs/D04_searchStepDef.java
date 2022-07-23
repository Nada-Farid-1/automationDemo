package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class D04_searchStepDef {
    P03_homePage testsearch = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();
    String subtitlesearch;
    @When("user click on search field1")
    public void goSearchPage1() throws InterruptedException {
        Thread.sleep(2000);
        testsearch.searchField().click();
    }
    String keyword;
    @And("user enter product name {string} search")
    public void userEnterProductNameSearch(String arg0) {
        testsearch.searchField().sendKeys(arg0);
        keyword = arg0;
    }

    @And("user enter product sku {string}search")
    public void userEnterProductSkuSearch(String arg0) throws InterruptedException {
        testsearch.searchField().sendKeys(arg0);
        Thread.sleep(5000);
        subtitlesearch =testsearch.searchresultonfield().getText();
        subtitlesearch=subtitlesearch.replace('&',' ').trim();
        subtitlesearch=subtitlesearch.replace('(',' ').trim();
        subtitlesearch=subtitlesearch.replace(')',' ').trim();
        subtitlesearch=subtitlesearch.replaceAll("\\s+"," ").trim();
        subtitlesearch=subtitlesearch.replace(' ','-').toLowerCase(Locale.ROOT);
        testsearch.searchresultonfield().click();
        Thread.sleep(2000);
        keyword=arg0;
    }

    @And("user click on enter to show search result1")
    public void enterSearch1()
    {
        testsearch.searchField().sendKeys(Keys.ENTER);
    }
    @Then("user can show the search result1")
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
    @Then("user can show the PDP for enter sku")
    public void showPDP()
    {
        String actualskuValue= testsearch.skuPDP().getText();
        Assert.assertEquals(actualskuValue,keyword);
    }

}
