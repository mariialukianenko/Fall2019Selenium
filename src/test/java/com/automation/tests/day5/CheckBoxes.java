package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

       // checkBoxes.get(0).click();
        BrowserUtils.wait(1);

        for (int i = 0; i < checkBoxes.size() ; i++) {

            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled() && (!checkBoxes.get(i).isSelected())) {
                //if checkbox is not selected, click on it
                checkBoxes.get(i).click(); // click on the checkbox
                System.out.println(i+1 +" checkbox clicked!");
            } else{
                System.out.println(i+1 +" checkbox wasn't clicked!");
            }
        }
        BrowserUtils.wait(1);

        driver.quit();
    }
}
