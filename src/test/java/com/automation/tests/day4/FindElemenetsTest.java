package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElemenetsTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);

       List<WebElement> links = driver.findElements(By.tagName("a"));

       for (WebElement link : links){
           System.out.println(link.getText());
           System.out.println(link.getAttribute("href"));
           System.out.println();
       }

        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();
            driver.navigate().back();
            //refresh list
           links = driver.findElements(By.tagName("a"));
        }

        driver.quit();

    }
}
