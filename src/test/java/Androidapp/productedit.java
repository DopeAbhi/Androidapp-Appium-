package Androidapp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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


       // driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Yellow Scarf']/android.widget.Button[2]")).click();

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1783,
                "direction", "down",
                "percent",  10.0
        ));
        Thread.sleep(1000);



        //Editing Products and verifying edit on main app

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Abhay Pant']/android.widget.Button[1]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Abhay Pant']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Abhay Pant']")).clear();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='']")).sendKeys("Abhay Pant");
        Thread.sleep(2000);
      String producttext=  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Abhay Pant']")).getText();
        System.out.println(producttext);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='100.0']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='100.0']")).clear();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='']")).sendKeys("100");
        Thread.sleep(2000);
        String pricetext=  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='100']")).getText();
        System.out.println(pricetext);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='3']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Open navigation menu']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Shop']")).click();
        Thread.sleep(2000);


        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1728,
                "direction", "down",
                "percent",  100.0,
                "speed", 800
        ));

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Abhay Pant']/android.widget.ImageView")).click();
        String valtext=driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Abhay Pant']")).getAttribute("content-desc");
        String valprice=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='₹100.0']")).getAttribute("content-desc");
      ;

        Assert.assertEquals(producttext,valtext);
        System.out.println("Price "+valprice);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //Adding new product

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Open navigation menu']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Manage Products']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='2']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("Ather");

          driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("999");

          driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).sendKeys("Very Good Scooter");

  driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='3']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='3']")).sendKeys("https://cdni.autocarindia.com/utils/imageresizer.ashx?n=https://cms.haymarketindia.net/model/uploads/modelimages/Ather-450X-170120221250.png");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@index='3']")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Open navigation menu']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Shop']")).click();



    }

}
