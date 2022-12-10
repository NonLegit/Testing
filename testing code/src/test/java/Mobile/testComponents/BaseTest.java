package mobile.testComponents;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

public class BaseTest {

    public AppiumDriverLocalService server;
    public AndroidDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void ConfigureAppium() {

        //code to start the server
        /*to be changed according to the device*/
        server = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\abdo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        server.start();

        // AndroidDriver, IOSDriver
        // Appium code -> Appium Server -> mobile
        UiAutomator2Options  options = new UiAutomator2Options();

        /*to be changed according to the device*/
        options.setDeviceName("Rahulemulator");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\app.apk");


        driver = new AndroidDriver(server , options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore = true;
        while(canScrollMore) {
            canScrollMore =  (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

        // stop the server
        server.stop();
    }

}
