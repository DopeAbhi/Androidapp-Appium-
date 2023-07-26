package Androidapp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Mainapp extends Base {
    @Test
    public void Test() throws InterruptedException {
//      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("text1")));
//        //Login



        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max4@gmail.com");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");
        driver.hideKeyboard();

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();


        String[] selecteditem=new String[2];
        String[] favitem=new String[2];

        //Adding products in favourite and verifying in favourites

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Red Shirt']/android.widget.Button[1]")).click();

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Red Shirt']/android.widget.ImageView")).click();

        selecteditem[0]= driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Red Shirt']")).getAttribute("content-desc");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));



            ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 1783,
                    "direction", "down",
                    "percent",  10.0
            ));


        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Slow Cooker']/android.widget.Button[1]")).click();

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Slow Cooker']/android.widget.ImageView")).click();

        selecteditem[1]= driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Slow Cooker']")).getAttribute("content-desc");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));


        //opening favourites and verifying products

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='2']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Only Favourites']")).click();


        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Red Shirt']/android.widget.ImageView")).click();

        favitem[0]=driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Red Shirt']")).getAttribute("content-desc");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));




        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Slow Cooker']/android.widget.ImageView")).click();

        favitem[1]= driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Slow Cooker']")).getAttribute("content-desc");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //Verifying fav products are the same product which we selected
        for(int i=0; i<2;i++)
        {
            Assert.assertEquals(selecteditem[i],favitem[i]);
        }


    }
}
