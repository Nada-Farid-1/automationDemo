package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {
    public WebElement registerlink() {return  Hooks.driver.findElement(By.className("ico-register"));}
    public WebElement genderSelector()
    {
        return Hooks.driver.findElement(By.id("gender-female"));
    }
    public WebElement firstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement dayOfBirth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement monthOfBirth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement yearOfBirth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement userEmail()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement companyName()
    {
        return Hooks.driver.findElement(By.id("Company"));
    }
    public WebElement password()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement registerButton()
    {
        return Hooks.driver.findElement(By.name("register-button"));
    }
    public WebElement statusMessage()
    {
        return Hooks.driver.findElement(By.className("result"));
    }
}
