package com.cybertek.tests.day6_july2;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class radioButtonsTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openRadioButtonPage();
        //test1();
        //test2();
        //test3();
        test4();
        driver.close();
    }
    public static void openRadioButtonPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    public static void test1(){
        WebElement blueBtn = driver.findElement(By.id("blue"));

        if(blueBtn.isSelected()){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        SeleniumUtils.waitPlease(2);
    }
    public static void test2(){
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement greenBtn = driver.findElement(By.id("green"));
        if(blackBtn.isEnabled() && (!greenBtn.isEnabled())){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        SeleniumUtils.waitPlease(2);
    }

    public static void test3(){
        WebElement blueBtn = driver.findElement(By.id("blue"));

        if(blueBtn.isSelected()){
           SeleniumUtils.waitPlease(2);
            WebElement blackBtn =driver.findElement(By.id("black"));
            blackBtn.click();
            if(blackBtn.isSelected() && !blueBtn.isSelected()){
                System.out.println("Passed!");
            }
        }else{
            System.out.println("Failed!");
        }
        SeleniumUtils.waitPlease(2);


    }
    public static void test4(){
        // Step 1. Let's find all radio buttons
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        //let's create counter, to count
        //how many selected radio buttons
        int counter = 0;
        //we will go through list of web elements
        //and check one by one
        //which radio button is selected
        //if radio button is selected
        //increase counter
        for(WebElement radioButton: listOfRadioButtons){
            if(radioButton.isSelected()){
                //get id of selected radio button
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }
        }
        System.out.println(counter);
    }
}
