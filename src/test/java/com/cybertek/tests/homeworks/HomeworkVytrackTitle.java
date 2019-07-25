package com.cybertek.tests.homeworks;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomeworkVytrackTitle {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        test1();
    }
    public static void getDriverB(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void test1() throws Exception {
        getDriverB();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user183");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);
        String name = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).getText();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();

        if(title.startsWith(name)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

        driver.close();


    }
}
