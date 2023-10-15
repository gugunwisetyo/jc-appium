package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
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
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        //mobile element
        MobileElement satu = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        MobileElement dua = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement tiga = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement empat = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        MobileElement tambah = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement kurang = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
        MobileElement samaDengan = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
        satu.click();
        tambah.click();
        dua.click();
        samaDengan.click();
        MobileElement hasil = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String txtHasil = hasil.getText();
        System.out.println(txtHasil);
//        if (txtHasil.equals("3")){
//            System.out.println("Passed");
//        } else {
//            System.out.println("failed");
//        }

        assertEquals(txtHasil, "3");

        tiga.click();
        kurang.click();
        empat.click();
        samaDengan.click();
        MobileElement hasil2 = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String txtHasil2 = hasil2.getText();
        System.out.println(txtHasil2);
//        if (txtHasil2.equals("−1")){
//            System.out.println("Passed");
//        } else {
//            System.out.println("failed");
//        }

        assertEquals(txtHasil2, "−1");

        driver.quit();
    }

    public static void assertEquals (String actual, String expected){
        if (actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("failed");
        }
    }
}