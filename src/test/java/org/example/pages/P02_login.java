package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class P02_login {
    public WebElement loginLink() {return  Hooks.driver.findElement(By.className("ico-login"));}
    public WebElement emailField()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement passwordField()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
    }
    public WebElement toggelLogoutButton()
    {
        return Hooks.driver.findElement(By.className("ico-logout"));
    }
    public WebElement faildLogin()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
    }
    public String currentLoginURL()
    {
        return Hooks.driver.getCurrentUrl();
    }
    public WebElement myAccountlabel()
    {
        return Hooks.driver.findElement(By.className("ico-account"));
    }
}
