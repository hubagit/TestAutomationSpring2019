package com.cybertek.tests.day6_july2;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //test1();
        test2();
    }
    public static void openCheckBoxesPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBoxesLogo = driver.findElement(By.tagName("h3"));
        if(checkBoxesLogo.isDisplayed()){
            System.out.println("Check box logo is visible");
        }else{
            System.out.println("Check box logo is not visible");
        }
    }

    public static void test1(){
        openCheckBoxesPage();
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type][2]"));
        if(!checkBox1.isSelected() && checkBox2.isSelected()){
            System.out.println("Passed!");
            System.out.println("Check box 1 is NOT checked!");
            System.out.println("Check box 2 is checked!");
        }else{
            System.out.println("Failed!");
        }
        driver.close();
    }
    public static void test2(){
        openCheckBoxesPage();
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type][2]"));
        SeleniumUtils.waitPlease(2);
        checkBox1.click();
        SeleniumUtils.waitPlease(2);
        checkBox2.click();
        SeleniumUtils.waitPlease(2);
        if(checkBox1.isSelected() && !checkBox2.isSelected()){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        driver.close();
    }

}
