package com.cybertek.tests.day6_july2;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Warmup {

    public static void main(String[] args) {
            test1();
            test2();
    }
    public static void test1(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("Selenium webdriver");
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a")).click();
        String url = driver.getCurrentUrl();

        if(url.endsWith("x")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
        driver.close();
    }
    public static void test2() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.className("nav-input")).click();
        String title = driver.getTitle();

        if (title.contains("iphone")) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        driver.close();
    }
}
