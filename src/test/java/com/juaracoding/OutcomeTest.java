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
import java.util.concurrent.TimeUnit;

public class OutcomeTest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
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
        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void testOutcome(){
        MobileElement addData = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
        addData.click();
        MobileElement sum = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etAmount"));
        sum.sendKeys("200000");
        MobileElement note = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etNote"));
        note.sendKeys("Pizza Hut");
        MobileElement save = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btSave"));
        save.click();

        MobileElement checkOutTrx = (MobileElement) driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[contains(@text, 'Pizza Hut')]"));
        String OutTrx = checkOutTrx.getText();
        System.out.println(OutTrx);
        Assert.assertEquals(OutTrx, "Pizza Hut");
    }
}