package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OutcomeNote {
    public static void main(String[] args) throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "POCO");
        desiredCapabilities.setCapability("udid", "219c0dcc");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset", true);

        //url
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        //instance android driver
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //mobile element income
        MobileElement addData = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
        addData.click();
//        MobileElement incomeBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btnIncome"));
//        incomeBtn.click();
//        MobileElement addDate = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tvDate"));
//        addDate.click();
//        MobileElement selectDate = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"14 Oktober 2023\"]"));
//        selectDate.click();
//        MobileElement okBtn = (MobileElement) driver.findElement(By.id("android:id/button1"));
//        okBtn.click();
//        MobileElement addCategory = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/spCategory"));
//        addCategory.click();
//        MobileElement selectCategory = (MobileElement) driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView"));
//        selectCategory.click();
        MobileElement sum = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etAmount"));
        sum.sendKeys("200000");
        MobileElement note = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etNote"));
        note.sendKeys("Pizza Hut");
        MobileElement save = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btSave"));
        save.click();

        MobileElement checkOutTrx = (MobileElement) driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[contains(@text, 'Bonus')]"));
        String OutTrx = checkOutTrx.getText();
        System.out.println(OutTrx);
        assertEquals(OutTrx, "Pizza Hut");

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