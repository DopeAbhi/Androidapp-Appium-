package Androidapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

   public UiAutomator2Options options;
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    @BeforeClass

    public void appset() throws MalformedURLException {

//Server Start
//Appium 2.0.0-rc.5
//node   v18.15.0
//Java   20
        AppiumServiceBuilder builder=new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("appium.txt"))
                .withIPAddress("127.0.0.1");
        // .withArgument(GeneralServerFlag.BASEPATH,"wd/hub");  don't need to include current version doesn't support
        service=   AppiumDriverLocalService.buildService(builder);
        service.stop();
        service.start();

        System.out.println(service.getUrl());
        System.out.println(service.isRunning());




        options=new UiAutomator2Options();
        options.setAppPackage("com.akshya.shop_app");
        options.setAppActivity("com.akshya.shop_app.MainActivity");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().getImplicitWaitTimeout();


    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
        service.stop();
    }


}
