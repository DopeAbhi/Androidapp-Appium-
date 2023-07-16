package Androidapp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Mainapp extends Base {
    @Test
    public void Test() throws InterruptedException {
        //Login
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max1@gmail.com");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();
        Thread.sleep(5000);

        //Adding products in favourite and verifying in favourites

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Red Shirt']/android.widget.Button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Electric Kettle']/android.widget.Button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Coffee Grinder']/android.widget.Button[1]")).click();


            ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 1883,
                    "direction", "down",
                    "percent",  10.0
            ));
            Thread.sleep(2000);



        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Electric Grill']/android.widget.Button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Electric Can Opener']/android.widget.Button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Slow Cooker']/android.widget.Button[1]")).click();





    }
}
