package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {

    public static void main(String[] args) {

       WebDriver driver = DriverFactory.createDriver("chrome");

       driver.get("http://practice.cybertekschool.com/radio_buttons");
       driver.manage().window().maximize();
        BrowserUtils.wait(1);

      WebElement blackButton =  driver.findElement(By.id("black"));
      if (blackButton.isDisplayed() && blackButton.isEnabled()){
          blackButton.click();
      }

      //verify that button clicked
        if (blackButton.isSelected()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        driver.quit();
    }
}
