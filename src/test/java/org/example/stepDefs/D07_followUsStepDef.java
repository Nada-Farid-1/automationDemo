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
    }
    @When("user click on rss link")
    public void clickOnRss() {
        follow.rssLink().click();

    }
    @When("user click on youtube link")
    public void clickOnYoutube()  {
        follow.youtubeLink().click();
    }
    //assertion for each link
    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());
        if(tabs.size()>1) {
            Hooks.driver.switchTo().window(tabs.get(1));
            Assert.assertEquals(follow.redirectGetCurrenturl(),arg0);
            System.out.println(arg0);
        }
        else
        {
            System.out.println("befors Assertion");
            Assert.assertEquals(follow.redirectGetCurrenturl(),arg0);
            System.out.println(arg0);
        }

    }
}
