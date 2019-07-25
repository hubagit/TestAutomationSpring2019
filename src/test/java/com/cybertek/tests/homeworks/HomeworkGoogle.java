package com.cybertek.tests.homeworks;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomeworkGoogle {

    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
         test1();

    }
    public static void getDriverB(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void test1(){
        getDriverB();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("java", Keys.ENTER);

        WebElement firstURL = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite"));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite")).click();
        String actualFirstURL = driver.getCurrentUrl();

        if(firstURL.equals(actualFirstURL)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }
        driver.navigate().back();
        driver.navigate().back();

        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("JUnit", Keys.ENTER);

        WebElement firstURL1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/div/cite"));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/h3")).click();
        String actualFirstURL1 = driver.getCurrentUrl();

        if(firstURL1.equals(actualFirstURL1)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }
        driver.navigate().back();
        driver.navigate().back();

        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("REST Assured", Keys.ENTER);

        WebElement firstURL2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div[1]/a/div/cite"));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div[1]/a/h3")).click();
        String actualFirstURL2 = driver.getCurrentUrl();

        if(firstURL2.equals(actualFirstURL2)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }


        driver.close();
    }
}
