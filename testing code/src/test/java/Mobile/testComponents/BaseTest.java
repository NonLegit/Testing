
package Mobile.testComponents;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobile.Pages.StartingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import resources.GetData;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static web.constants.TestConstants.SCREENSHOT_PATH;

public class BaseTest {

    public AppiumDriverLocalService server;
    public AndroidDriver driver;
    public StartingPage startingPage;
    public GetData getData;

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

        startingPage = new StartingPage(driver);
        getData = new GetData();

       /* DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","EM_Fathi");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","13");



        cap.setCapability("app","C:\\Users\\fathi\\Videos\\app_relase_version.apk");


        URL url= null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url,cap);*/
    }


    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000));
    }



    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));

    }

    /**
     * this is a function that takes a screenshot and stores it and returns the path of the stored screenshot
     * @param testCaseName: this is the name of current test that requires this screenshot
     * @param driver: this is the driver through which we run the tests
     * @return String: this is the path of the taken image
     * @throws IOException: this exception is thrown if the file isn't found
     */
    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(SCREENSHOT_PATH + testCaseName + ".png");
        File file = new File(SCREENSHOT_PATH + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return SCREENSHOT_PATH + testCaseName + ".png";
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

        // stop the server
        server.stop();
    }

}

