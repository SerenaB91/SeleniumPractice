/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniumtest;

import java.awt.RenderingHints;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author MABCO
 */
public class AutomatedCampusLogin {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        
        //open website
        chromeDriver.navigate().to("https://www.du.se");
        //close pop-up
        chromeDriver.findElement(By.id("wsalayerclose")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        
        //Login
        chromeDriver.findElement(By.id("LoginButton")).click();
        chromeDriver.findElement(By.id("username")).sendKeys("XXXX");
        chromeDriver.findElement(By.id("password")).sendKeys("XXXX");
        chromeDriver.findElement(By.className("btn-submit")).click();
        
        //switch to english
        chromeDriver.navigate().to("https://www.du.se/en");
        
        //open library
        chromeDriver.navigate().to("https://www.du.se/en/library");
        
        //search for something
        //chromeDriver.findElement(By.className("PSAutoComplete")).sendKeys("Data Mining");
        //chromeDriver.findElement(By.className("PSAutoComplete")).sendKeys(Keys.ENTER);
        
        //search for something in library
        chromeDriver.findElement(By.xpath("//*[@id=\"PolySearch\"]/div[2]/div[2]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"PSTabBibCat\"]/div/div[1]/input")).sendKeys("Artificial Intelligence");
        chromeDriver.findElement(By.xpath("//*[@id=\"PSTabBibCat\"]/div/div[1]/input")).sendKeys(Keys.ENTER);
        
        //wait 5 seconds and close the browser
        TimeUnit.SECONDS.sleep(5);
        chromeDriver.close();
        chromeDriver.quit();
        } catch (InterruptedException ex) {
            Logger.getLogger(AutomatedCampusLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
}
