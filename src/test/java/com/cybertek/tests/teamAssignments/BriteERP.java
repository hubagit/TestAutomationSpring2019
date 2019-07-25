package com.cybertek.tests.teamAssignments;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BriteERP {

    private WebDriver driver = BrowserFactory.getDriver("chrome");

    String calendarButtonLocator = "(//span[@class='oe_menu_text'])[2]";
    String calendarDateBoxLocator = "(//td[@class='fc-widget-content'])[14]";
    String summaryBoxLocator = "(//input[@class='o_input'])";
    String dateBoxWithTextLocator = "(//div[@class='fc-bg'])[3]";
    String boxEditButtonLocator = "[class='btn btn-sm btn-primary']>span";
    String descriptionTextBoxLocator = "[name='description']";
    String saveButtonLocator = "[class='btn btn-sm btn-primary']>span";


    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }
    @Test (priority = 1)
    public void calendarTest1(){
        driver.findElement(By.id("login")).sendKeys("EventsCRM_Manager5@info.com");
        driver.findElement(By.id("password")).sendKeys("Ugh45wQ16", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(calendarButtonLocator))));

        driver.findElement(By.xpath(calendarButtonLocator)).click();
        driver.findElement(By.xpath(calendarDateBoxLocator)).click();
        driver.findElement(By.xpath(summaryBoxLocator)).sendKeys("meeting",Keys.ENTER);

        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(dateBoxWithTextLocator))));
        Assert.assertTrue(driver.findElement(By.xpath(dateBoxWithTextLocator)).isDisplayed());

    }
    @Test (priority = 2)
    public void calendarTest2(){
        driver.findElement(By.id("login")).sendKeys("EventsCRM_Manager5@info.com");
        driver.findElement(By.id("password")).sendKeys("Ugh45wQ16", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(calendarButtonLocator))));

        driver.findElement(By.xpath(calendarButtonLocator)).click();
        driver.findElement(By.xpath(dateBoxWithTextLocator)).click();
        driver.findElement(By.cssSelector(boxEditButtonLocator)).click();
        driver.findElement(By.cssSelector(descriptionTextBoxLocator)).sendKeys("meeting about demo");
        driver.findElement(By.cssSelector(saveButtonLocator)).click();

        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(dateBoxWithTextLocator))));
        Assert.assertTrue(driver.findElement(By.xpath(dateBoxWithTextLocator)).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
