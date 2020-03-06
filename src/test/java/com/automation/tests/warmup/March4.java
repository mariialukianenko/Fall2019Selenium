package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) {

        ebayTest();
        amazonTest();
        wikiTest();

    }

    public static void ebayTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book", Keys.ENTER);
        String numberResult = driver.findElement(By.tagName("h1")).getText();
        System.out.println(numberResult);
        driver.close();
    }

    public static void amazonTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        driver.quit();
    }

    public static void wikiTest (){
      driver = DriverFactory.createDriver("chrome");
        driver.get("http://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        String link = driver.getCurrentUrl();
        if (link.endsWith("Selenium_(software)")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driver.quit();
    }

}
/*
Go to ebay
enter search term
click on search button
print number of results
go to amazon

Go to amazon
enter search term
click on search button
verify title contains search term

Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
 */