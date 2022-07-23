package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D08_WishlistStepDef {
    P03_homePage wishlistTest = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();
    @Given("user in Home page and there are product list")
    public void homewish() {wishlistTest.hometext().isDisplayed();}
    @When("User click on heart for item")
    public void clickWishlist() throws InterruptedException {
        wishlistTest.wishlistbtns().get(2).click();
        //wishlist.wishlistButton().click();
      //  Thread.sleep(2000);
    }

    @Then("user show success message The product has been added to your wishlist with green background color")
    public void userWillSeeSuccessMessageTheProductHasBeenAddedToYourWishlistWithGreenBackgroundColor() throws InterruptedException {
        Thread.sleep(2000);

        wishlistTest.successWishlist().isDisplayed();
        String actualColor= wishlistTest.sucessColor().getCssValue("background-color");
        System.out.println(actualColor);
        String hexActualColor = Color.fromString(actualColor).asHex();
        System.out.println(hexActualColor);
        String expectedColor= "#4bb07a";

        softAssert.assertEquals(hexActualColor ,expectedColor);
        softAssert.assertAll();
    }

    @And("wait until this success message with green color to disappear then click on Wishlist Tab")
    public void waitUntilThisSuccessMessageWithGreenColorToDisappearThenClickOnWishlistTab() {
       //WebDriverWait wait = new WebDriverWait(Hooks.driver,30);
       // wait.until(ExpectedConditions.elementToBeClickable(wishlistTest.wishlist()));
     //   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        wishlistTest.wishlistTab().click();


    }



    @Then("get Qty value and verify it's bigger than zero")
    public void getQtyValueAndVerifyItSBiggerThanZero() {
      //  System.out.println(wishlistTest.wishlistqty().getAttribute("value"));
        int countint= Integer.parseInt(wishlistTest.countWishlist());
        Assert.assertTrue(countint>0);
    }


}
