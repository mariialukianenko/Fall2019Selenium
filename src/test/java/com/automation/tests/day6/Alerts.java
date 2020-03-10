package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();  //to click on the first button
        BrowserUtils.wait(1);
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept();  //to click OK

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        //it will fail, because there is a typo
        if (expected.equals(actual)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


        buttons.get(1).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if (expected2.equals(actual2)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }



        buttons.get(2).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Hello, World!");
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();

        String expected3 = "Hello, World!";
        String actual3 = driver.findElement(By.id("result")).getText();
        if (actual3.endsWith(expected3)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


        BrowserUtils.wait(2);
        driver.quit();
    }
}
