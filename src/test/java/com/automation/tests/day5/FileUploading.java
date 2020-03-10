package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir") + "/pom.xml";

        // how to upload from computer: right click snd hold option button and than copy as a pathname
       // String file2Path = "/Users/mariialukianenko/Downloads/00 - Interview Prep editted by Albert.pdf"

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();  //click to upload

        BrowserUtils.wait(3);
        driver.quit();
    }
}
