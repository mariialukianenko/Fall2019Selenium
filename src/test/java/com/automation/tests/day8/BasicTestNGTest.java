package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTest {

    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }


    //runs only oncein the class
    @BeforeClass
    public void beforeClass(){
        //something that should be done only oncein the class before all tests
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    //runs before every test automatically
    @BeforeMethod
    public void setup(){
        System.out.println("before method");
    }

    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("after method");
    }

    @Test
    public void test1(){
        System.out.println("test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        System.out.println("test 2");
        int num1 = 5;
        int num2 = 10;
        //it calls hard assertion.
        Assert.assertTrue(num1<num2);

    }

}
