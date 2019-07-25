package com.cybertek.tests.day12_july16_waits;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTests {

    String helloWordMessageLocator = "#finish>h4";
    String startButtonLocator = "#start>button";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        //can handle NoSuchElementException within given time frame
        //(driver will wait up to 10 seconds)
        //no strictly 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void waitTest1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        String expectedResult = "Hello World!";
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        String actualResult = driver.findElement(By.cssSelector(helloWordMessageLocator)).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void waitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult = "Hello World!";
        String actualResult = driver.findElement(By.cssSelector(helloWordMessageLocator)).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
