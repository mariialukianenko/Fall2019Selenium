package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        //create a webelement object for dropdown first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1995");
        selectMonth.selectByVisibleText("January");
        selectDay.selectByVisibleText("14");

        //select all month one by one
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month : months ){
            selectMonth.selectByVisibleText(month.getText());
            System.out.println(month.getText());
           // BrowserUtils.wait(1);
        }

        BrowserUtils.wait(1);
        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("Minnesota");

        // option that is currently selected
        String selected = selectState.getFirstSelectedOption().getText();
        System.out.println("Selected: " + selected);

        if (selected.equals("Minnesota")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        System.out.println();

        List<WebElement> states = selectState.getOptions();
        for (WebElement stateOption : states){
            System.out.println(stateOption.getText());
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}
