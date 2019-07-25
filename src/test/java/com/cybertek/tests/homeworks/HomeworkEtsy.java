package com.cybertek.tests.homeworks;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomeworkEtsy {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        test1();
    }
    public static void getDriverB(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void test1() {
        getDriverB();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("wooden spoon", Keys.ENTER);
        String results = driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div/div[1]/h1")).getText();
        driver.findElement(By.xpath("//*[@id=\"w3\"]/li[1]/ul/li[1]/ul/li/a/span")).click();
        String allResults = driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div/div[1]/h1")).getText();


            int resultsAsNumber=0 ;
            String a ="";
            if(Character.isDigit(results.charAt(0))) {
                a = results.substring(0, 1);
            }
            resultsAsNumber = Integer.parseInt(a);


            int allResultsAsNumber=0 ;
            String b ="";
            if(Character.isDigit(allResults.charAt(0))) {
                b = results.substring(0, 1);
            }
                allResultsAsNumber = Integer.parseInt(b);


        if(allResultsAsNumber>resultsAsNumber){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }

        driver.navigate().back();
        if(driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).isDisplayed()){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        driver.navigate().back();
        if(!driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).isSelected()){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }
        driver.close();

    }



}
