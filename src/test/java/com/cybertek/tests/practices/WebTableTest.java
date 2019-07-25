package com.cybertek.tests.practices;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTableTest extends TestBase {

    @Test
    public void printTableTest(){
        WebElement table1Locator = driver.findElement(By.id("table1"));
        System.out.println(table1Locator.getText());
    }
    @Test
    public void printHeaderRow(){
        WebElement locator = driver.findElement(By.xpath("//table[1]/thead"));
        System.out.println(locator.getText());
    }
    @Test
    public void countOfRowsTest(){
        List<WebElement> rows = driver.findElements(By.cssSelector("#table1>tbody tr"));
        System.out.println("Size: "+rows.size());

    }
    @Test
    public void countOfRowsTest2(){
        List<WebElement> allRows = driver.findElements(By.cssSelector("#table2 tr"));
        System.out.println(allRows.size());
        Assert.assertEquals(allRows.size(),5);
    }
    @Test
    public void printTable1Headers(){
        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));
        for (WebElement header : headers){
            System.out.println(header.getText());
        }
    }
    @Test
    public void printSpecificRow(){
        int rowNumber = 3;
        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1>tbody tr:nth-of-type("+rowNumber+")"));
        for (WebElement cell : allCells){
            System.out.print(cell.getText()+" ");
        }
    }
    @Test
    public void getColumnTest(){
        System.out.println(getColumn("Email"));
    }

    @Test
    public void verifyThatNameDisplays(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tr[3]//td[1]";

        String actualFirstName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();
        Assert.assertEquals(actualFirstName,firstName);
        Assert.assertEquals(actualLastName,lastName);

    }

    @Test
    public void verifyThatNameRecordHasBeenDeleted(){
        String lastName = "Doe";
        String locator = "//table[1]//td[text()='"+lastName+"']";
        String deleteLocator = "//table[1]//td[text()='"+lastName+"']/following-sibling::td//a[text()='delete']";
        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(locator)).isEmpty());




    }
    public List<String> getColumn(String columnName){
        List<String> values = new ArrayList<>();
        int columnIndex = 0;
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (int i = 0; i<columnNames.size(); i++){
            if(columnNames.get(i).getText().equals(columnName)){
                columnIndex = i+1;
                break;
            }
        }
        List<WebElement> cells = driver.findElements(By.xpath("//table[1]/tbody//td["+columnIndex+"]"));
        for (WebElement cell : cells){
            values.add(cell.getText());
        }
        return values;
    }
}
