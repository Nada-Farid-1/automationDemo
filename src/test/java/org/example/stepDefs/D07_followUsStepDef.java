package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage follow =new P03_homePage();


    @Given("user in home page and follow us links appeared")
    public void verifyHomeFollowUsPage() {
        follow.hometext().isDisplayed();
        follow.followUs().isDisplayed();
    }
    @When("user click on facebook link")
    public void clickOnFacebook()  {
        follow.facebookLink().click();

    }
    @When("user click on twitter link")
    public void clickOnTwitter() throws InterruptedException {
        follow.twitterLink().click();
        Thread.sleep(10000);
      // Hooks.driver.switchTo().window(tabs.get(1));

     //   follow.switchtap();
      //  Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @When("user click on rss link")
    public void clickOnRss() {
        follow.rssLink().click();

    }
    @When("user click on youtube link")
    public void clickOnYoutube() throws InterruptedException {
        follow.youtubeLink().click();
    }
    /*
    @Then("user redirect to the facebook website")
    public void redirectFacebook() throws InterruptedException {
        Thread.sleep(2000);
        Hooks.driver.switchTo().window(tabs.get(1));
        String expectedLink ="https://www.facebook.com/nopCommerce";
        String actualLink= follow.redirectGetCurrenturl();
        Assert.assertEquals(actualLink,expectedLink);
    }
    @Then("user redirect to the twitter website")
    public void redirectTwitter() throws InterruptedException {
        String expectedLink ="https://twitter.com/nopCommerce";
        Thread.sleep(2000);
        String actualLink= follow.redirectGetCurrenturl();
        Assert.assertEquals(actualLink,expectedLink);
    }
    @Then("user redirect to the rss website")
    public void redirectRss() {
        String expectedLink ="https://demo.nopcommerce.com/new-online-store-is-open";
        String actualLink= follow.redirectGetCurrenturl();
        Assert.assertEquals(actualLink,expectedLink);
    }
    @Then("user redirect to the youtube website")
    public void redirectYoutube() {
        String expectedLink ="https://www.youtube.com/user/nopCommerce";
        String actualLink= follow.redirectGetCurrenturl();
        Assert.assertEquals(actualLink,expectedLink);
    }

     */

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(follow.redirectGetCurrenturl(),arg0);
    }
}
