package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
//        WebElement password = driver.findElement(By.name("password"));
//        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }



        // let's click on logout button.   <a> means link
        // if you have couple space in the text, use patrialLinkText
        //linkText = equals()
        //partialLinkText = cantains() - complete match doesn't require
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));

        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);
        logout.click();

        Thread.sleep(2000);


        // let's enter invalid credential

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);
        WebElement errorMsg = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMsg.getText());

        Thread.sleep(2000);


        driver.quit();

    }
}
