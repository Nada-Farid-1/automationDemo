package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class P03_homePage {
    WebDriverWait wait=new WebDriverWait(Hooks.driver,30);
    SoftAssert softAssert =new SoftAssert();
    ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());


    public WebElement hometext() {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"topic-block-title\"]"));
    }

    //F03_Currencies----------------------------------------------------------------------------------------------------------------------------------
    public WebElement customerCurrency() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }
    public WebElement selectedCurrency() {
        return Hooks.driver.findElement(By.xpath("//option[@selected]"));
    }
    public List<WebElement> itemPrice(){return Hooks.driver.findElements(By.xpath("(//span[@class=\"price actual-price\"])"));}

    //F04_Search-----------------------------------------------------------------------------------------------------------------------------------
    public WebElement searchField() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchresultonfield() {return  Hooks.driver.findElement(By.className("ui-menu-item-wrapper"));}
    public WebElement skuPDP()
    {
        if ((Hooks.driver.findElements(By.xpath("//span[@class=\"value\"]")).size())==3)
        {
            System.out.println(Hooks.driver.findElements(By.xpath("//span[@class=\"value\"]")).size());
            return Hooks.driver.findElement(By.xpath("(//span[@class=\"value\"])[3]"));
        } else if ((Hooks.driver.findElements(By.xpath("//span[@class=\"value\"]")).size())==2) {
            return Hooks.driver.findElement(By.xpath("(//span[@class=\"value\"])[2]"));
        }else {
            return Hooks.driver.findElement(By.xpath("//span[@class=\"value\"]"));
        }
    }
    public int searchItemsCount()
    {
       int count = Hooks.driver.findElements(By.xpath("//div[@class=\"item-box\"]")).size();
        return count;
    }
    public List<WebElement> searchItems()
    {
        return Hooks.driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
    }
    //F05_HoverCategories-----------------------------------------------------------------------------------------------------------------------
    public WebElement mainCategory1() {
        return Hooks.driver.findElement(By.xpath("(//a[@href=\"/computers\"])[1]"));
    }

    public WebElement subCategory1() {
        return Hooks.driver.findElement(By.xpath("(//a[@href=\"/desktops\"])[1]"));
    }
    public WebElement pageCategoryTitle() {
        return Hooks.driver.findElement(By.className("page-title"));
        //div[@class="page-title"]
    }
    public WebElement nameSubCat()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/desktops\"]"));
    }
    //F06_homeSlider----------------------------------------------------------------------------------------------------------------------------------
    public WebElement dot1st()
    {
        return Hooks.driver.findElement(By.xpath("//a[@rel=\"0\"]"));
    }
    public WebElement nokiaSlider()
    {
        return  Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[1]"));
        //Hooks.driver.findElement(By.xpath("//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.jpg\"]"));
                //Hooks.driver.findElement(By.cssSelector("a[href=\"http://demo.nopcommerce.com/\"][1]"));
    }
    public WebElement dot2nd()
    {
        return Hooks.driver.findElement(By.xpath("//a[@rel=\"1\"]"));
    }
    public WebElement iphoneSlider()
    {
        //img[@src="https://demo.nopcommerce.com/images/thumbs/0000080_banner_2.jpg.jpg"]
        return Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a[2]"));
                //Hooks.driver.findElement(By.cssSelector("a[href=\"http://demo.nopcommerce.com/\"][2]"));
    }
    //F07_followUs--------------------------------------------------------------
    public WebElement followUs() {
        return Hooks.driver.findElement(By.xpath("(//div[@class=\"title\"])[4]"));
    }
    public WebElement facebookLink() {
        return Hooks.driver.findElement(By.className("facebook"));
    }

    public WebElement twitterLink() {
        return Hooks.driver.findElement(By.className("twitter"));
    }

    public WebElement rssLink() {
        return Hooks.driver.findElement(By.className("rss"));
    }

    public WebElement youtubeLink() {
        return Hooks.driver.findElement(By.className("youtube"));
    }

    public String redirectGetCurrenturl() {
        return Hooks.driver.getCurrentUrl();
    }

    //F08_wishlist-------------------------------------------------------------------------------
    public WebElement wishlistqty()
    {
        return Hooks.driver.findElement(By.className("wishlist-qty"));
    }
    public WebElement wishlistTab()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        return Hooks.driver.findElement(By.className("wishlist-label"));
    }
    public WebElement prodcutlist()
    {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"]"));
    }

    public WebElement sucessColor()
    {
        return Hooks.driver.findElement(By.className("bar-notification"));
    }
    public WebElement successWishlist()
    {
         wait = new WebDriverWait(Hooks.driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        return Hooks.driver.findElement(By.className("content"));
    }
    public WebElement closeSuccessMsg()
    {
        return Hooks.driver.findElement(By.className("close"));
    }
    public WebElement titelWishlist()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }
    //public WebElement visiblityElement(){return ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]"));}
    public List<WebElement> wishlistbtns ()
    {
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public  String countWishlist() {return Hooks.driver.findElement(By.className("qty-input")).getAttribute("value");};
}
