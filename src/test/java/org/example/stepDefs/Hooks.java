package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public  static WebDriver driver = null;

    @Before
    public static void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver","/home/nada/IdeaProjects/demo1/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
