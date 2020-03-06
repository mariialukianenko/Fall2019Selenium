package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    //Interview question:
    //how to verify if element doesn't exist any more in the DOM (document object model)

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.id("disappearing_button")).click();

       // List<WebElement> list = driver.findElements(By.id("disappearing_button"));  or like that
        if (driver.findElements(By.id("disappearing_button")).size()==0){      // or list.size
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button : buttons){
            //click on every button
            button.click();
        }

        driver.quit();
    }

}
