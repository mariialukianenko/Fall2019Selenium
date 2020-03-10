package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);

        driver.switchTo().frame("frame-top");    // use name or id
        driver.switchTo().frame("frame-middle"); // use name or id

        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame(); // go to top frame
        driver.switchTo().frame("frame-right"); // switch to the right frame

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        //to go to the bottom frame, you need to switch to the default content
        //because, top frame is a sibling for bottom frame, but not a parent
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.quit();
    }
}
