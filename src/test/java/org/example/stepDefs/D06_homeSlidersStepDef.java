package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {
    P03_homePage slider = new P03_homePage();
    @When("click on First Slider")
    public void firstClick()
    {
        slider.dot1st().click();
        slider.nokiaSlider().click();
    }
    @When("click on Second Slider")
    public void secondClick()
    {
        slider.dot2nd().click();
        slider.iphoneSlider().click();
    }
    @Then("user redirect to url1 Nokia")
    public void verify1stSlider()
    {
       String actual1stSliderurl= slider.redirectGetCurrenturl();
       String expected1stSliderurl="https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(actual1stSliderurl,expected1stSliderurl);
    }
    @Then("user redirect to url2 iphone")
    public void verify2ndSlider()
    {
        String actual2ndSliderurl= slider.redirectGetCurrenturl();
        String expected2ndSliderurl="https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(actual2ndSliderurl,expected2ndSliderurl);

    }

}
