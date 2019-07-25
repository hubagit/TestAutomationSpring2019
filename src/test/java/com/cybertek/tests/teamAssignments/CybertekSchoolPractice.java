package com.cybertek.tests.teamAssignments;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CybertekSchoolPractice {

    public static void main(String[] args) throws Exception {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("mustafa");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        String actual = driver.findElement(By.id("flash")).getText();
        String expected = "Your username is invalid!\n" + "×";

        SeleniumUtils.verifyEquals(expected,actual);
        driver.close();

    }
}
