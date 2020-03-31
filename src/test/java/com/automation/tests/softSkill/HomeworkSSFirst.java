package com.automation.tests.softSkill;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkSSFirst {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void teardown(){

        driver.quit();
    }

    @Test
    public void vehicleContractsPage (){
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(2);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains (text(), 'Fleet')]"))).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//span[@class='title title-level-2' and contains (text(), 'Vehicle Contracts')]")).click();
        BrowserUtils.wait(2);

        String expected = "You do not have permission to perform this action.";
        String actual = driver.findElement(By.xpath("//div[@class='message' and contains (text(), 'You do not have permission')]")).getText();
        Assert.assertEquals(expected, actual);
    }




}
