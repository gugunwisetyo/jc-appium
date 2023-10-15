package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "POCO");
        desiredCapabilities.setCapability("udid", "219c0dcc");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("noReset", true);

        //url
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        //instance android driver
        driver = new AndroidDriver(url, desiredCapabilities);
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test
    public void testAdd(){
        MobileElement satu = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        MobileElement dua = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement tambah = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement samaDengan = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
        satu.click();
        tambah.click();
        dua.click();
        samaDengan.click();
        MobileElement hasil = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String txtHasil = hasil.getText();
        System.out.println(txtHasil);
        Assert.assertEquals(txtHasil, "3");
    }

    @Test
    public void testSub(){
        MobileElement tiga = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement empat = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        MobileElement kurang = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
        MobileElement samaDengan = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
        tiga.click();
        kurang.click();
        empat.click();
        samaDengan.click();
        MobileElement hasil2 = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String txtHasil2 = hasil2.getText();
        System.out.println(txtHasil2);
        Assert.assertEquals(txtHasil2, "−1");
    }
}
