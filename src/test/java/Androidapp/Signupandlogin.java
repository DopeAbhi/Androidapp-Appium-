package Androidapp;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Signupandlogin extends Base {

    @Test
    public void TestCase() throws InterruptedException {
//-------------------------Signup Test Cases-----------------------

        //Without data signup
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGNUP INSTEAD']")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();
        Thread.sleep(1000);

        String withoutemail=  driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Invalid email!']")).getAttribute("content-desc");

        System.out.println("Error message of email for without data singup="+ withoutemail);
        Assert.assertEquals("Invalid email!",withoutemail);
        Thread.sleep(1000);

        String passmsg=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Password is too short!']")).getAttribute("content-desc");
        Assert.assertEquals("Password is too short!",passmsg);
        System.out.println("Error message of passwordfor without password signup="+passmsg);


        //Signup without any error case
        //Change email and password every time you run in below case and existing user case

        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max12@gmail.com");

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");

         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).sendKeys("Test@123");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();
        Thread.sleep(3000);

        //------Signup with same emailid and error case handling------

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Open navigation menu']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Logout']")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGNUP INSTEAD']")).click();
        Thread.sleep(2000);

        //Without password signup and getting error message

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max5@gmail.com");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();
        Thread.sleep(1000);
        String passerrormsg=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Password is too short!']")).getAttribute("content-desc");
        Assert.assertEquals("Password is too short!",passerrormsg);
        System.out.println("Error message for without password signup="+passerrormsg);
        Thread.sleep(2000);

        // Different Password and Confirm Password

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).sendKeys("Tes");
        Thread.sleep(1000);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();
        Thread.sleep(1000);
        String passnotmatch=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Passwords do not match!']")).getAttribute("content-desc");
        Assert.assertEquals("Passwords do not match!",passnotmatch);
        System.out.println("Error message when password didn't match"+passnotmatch);


        //Invalid email

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max1");
        Thread.sleep(1000);
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();

        String invalidemail=  driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Invalid email!']")).getAttribute("content-desc");
      Assert.assertEquals("Invalid email!",invalidemail);
        System.out.println("Error message for invalid message"+ invalidemail);


        //Signup with existing user email address
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max7@gmail.com");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='2']")).sendKeys("Test@123");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='SIGN UP']")).click();
        Thread.sleep(3000);

        String popuperrormsg=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='This email address is already in use.']")).getAttribute("content-desc");
        Assert.assertEquals("This email address is already in use.",popuperrormsg);
        System.out.println("Pop error message="+popuperrormsg);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Okay']")).click();
        Thread.sleep(2000);
        driver.hideKeyboard();

//------------------------------------------Login Test Cases--------------------------------------

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN INSTEAD']")).click();

        //Login without entering any data

        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();
        String loginerrormsg=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Invalid email!']")).getAttribute("content-desc");
        System.out.println("Error message of email while login"+ loginerrormsg);
        Assert.assertEquals("Invalid email!",loginerrormsg);
        Thread.sleep(1000);
        String loginerrormsg1=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Password is too short!']")).getAttribute("content-desc");
        System.out.println("Error message of email while login"+ loginerrormsg1);
        Assert.assertEquals("Invalid email!",loginerrormsg);
        driver.hideKeyboard();

        //Login without password

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max1@gmail.com");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();


        //Login with User that doesn't exist

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("maxt1@gmail.com");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();

        Thread.sleep(2000);
        String usernotexist=driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Could not find a user with that email.']")).getAttribute("content-desc");
        Assert.assertEquals("Could not find a user with that email.",usernotexist);
        System.out.println("Error message when user didn't exist="+usernotexist);
        Thread.sleep(2000);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Okay']")).click();



        //User Login

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']")).sendKeys("max1@gmail.com");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).clear();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='1']")).sendKeys("Test@123");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='LOGIN']")).click();
        Thread.sleep(5000);

















    }

}
