package com.cybertek.tests.day5_june30;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassname {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        test1();
    }

    public static void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> examples = driver.findElements(By.className("list-group-item"));

        int count = 0;
        for(WebElement element: examples){
            System.out.println(element.getText());
            count++;
        }
        System.out.println("Count of elements: "+count);
        driver.close();
    }
}
