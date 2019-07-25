package com.cybertek.tests.day14_july20_Properties;

import com.cybertek.pages.vytrack.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
     LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1(){
        //DEMO for reading credentials from properties file
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }

}
