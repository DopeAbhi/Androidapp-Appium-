package Androidapp;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

//Used this only for experiments
public class experiments extends Base {


    @Test
     public void start() throws InterruptedException {

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max12@gmail.com");

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).click();

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).sendKeys("Test@123");

         driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();


     }


}
