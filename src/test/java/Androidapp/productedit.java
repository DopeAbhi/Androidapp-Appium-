package Androidapp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class productedit extends Base
{
    @Test
    public void verification() throws InterruptedException {
        //Login Process

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max5@gmail.com");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();

        //Navigating to Manage products and Deleting Product

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Open navigation menu']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Manage Products']")).click();
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1728,
                "direction", "down",
                "percent",  100.0,
                "speed", 800
        ));

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Electric Can Opener']/android.widget.Button[2]")).click();


        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 538,
                "direction", "up",
                "percent",  40.0,
                "speed", 500
        ));
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Instant Pot']/android.widget.Button[2]")).click();

        //Editing Products

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Trousers']/android.widget.Button[1]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Trousers']")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='']")).sendKeys("Abhay Pant");
      String producttext=  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Abhay Pant']")).getText();
        System.out.println(producttext);




    }

}
