package Androidapp;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.Test;

import java.io.File;

public class AppiumServer {


    @Test
     public static void start()
     {
         AppiumDriverLocalService service;
         AppiumServiceBuilder builder=new AppiumServiceBuilder();
         builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                 .usingDriverExecutable(new File("/usr/local/bin/node"))
                 .usingPort(4723)
                 .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                 .withLogFile(new File("appium.txt"))
                 .withIPAddress("127.0.0.1");
                // .withArgument(GeneralServerFlag.BASEPATH,"wd/hub")
      service=   AppiumDriverLocalService.buildService(builder);
    // service.start();
         System.out.println(service.getUrl());
         System.out.println(service.isRunning());
         service.stop();
         System.out.println(service.isRunning());


     }


}
