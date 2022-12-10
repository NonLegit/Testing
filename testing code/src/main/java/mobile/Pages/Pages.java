package mobile.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class Pages {
   protected AppiumDriver<MobileElement> driver;
    public Pages()  {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","AOSP on IA Emulator");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","13");
        cap.setCapability("app","C:\\Users\\fathi\\Videos\\app.apk");

//        cap.setCapability("appPackage","com.reddit.frontpage");
//        cap.setCapability("appActivity","com.reddit.frontpage.StartActivity");


        try{
            URL url=new  URL("http://127.0.0.1:4723/wd/hub");
            driver=new AppiumDriver<MobileElement>(url,cap);

        }catch(Exception ignore){

        }



    }

}
