package Androidapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

   public UiAutomator2Options options;
    public AndroidDriver driver;
    @BeforeClass
    public void appset() throws MalformedURLException {
        options=new UiAutomator2Options();
        options.setAppPackage("com.akshya.shop_app");
        options.setAppActivity("com.akshya.shop_app.MainActivity");
        options.setDeviceName("emulator-5554");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().getImplicitWaitTimeout();


    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }


}
