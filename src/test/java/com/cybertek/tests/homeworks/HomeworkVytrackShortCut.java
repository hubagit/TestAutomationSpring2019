package com.cybertek.tests.homeworks;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomeworkVytrackShortCut {
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
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager216");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(4000);
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("dashboard")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a/i")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[21]/td[1]/a")).click();
        Thread.sleep(4000);

        String title1 = driver.getTitle();

                if(title1.equalsIgnoreCase("Open Opportunities - Opportunities - Sales")){
                    System.out.println("Passed!");
                }else{
                    System.out.println("Failed");
                }
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[8]/a/span")).click();
        Thread.sleep(2000);
        String errorMessageActual = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText();
        String errorMessageExpected = "You do not have permission to perform this action.";

        if(errorMessageActual.equalsIgnoreCase(errorMessageExpected)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }

        String title2 = driver.getTitle();
        Thread.sleep(2000);

        if(title2.equalsIgnoreCase("Open Opportunities - Opportunities - Sales")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
            System.out.println(title2);
        }

        driver.close();



    }
}
