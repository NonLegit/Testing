package web.testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.pageObjects.LandingPage;
import resources.GetData;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static web.constants.TestConstants.*;

/**
 * this class contains methods which are common among all methods and used by many of them
 */
public class BaseTest {


    /**
     * this is the driver which is used to run test scripts
     */
    public WebDriver driver;

    /**
     * this is the object of the landing page which is the login page
     */
    protected LandingPage landingPage;

    /**
     * this is the object through which we can extract data that will be input to the text
     */
    protected GetData getData = new GetData();

    /**
     * this function is used to initialize and configure the driver for you
     * @param path: this is path to the file through which we will read the general configured properties
     * @param implicitTimeOutInSeconds: this is the implicit timeout in seconds to wait on element to appear
     * @return WebDriver: this is the created driver
     * @throws IOException: if the file to be loaded into properties isn't found
     */
    public WebDriver initializeDriver(String path, int implicitTimeOutInSeconds) throws IOException {

        String browserName = getData.getBrowserName(path);

        if (browserName.equalsIgnoreCase(BROWSER_CHROME)){
            driver = WebDriverManager.chromedriver().arch64().enableRecording().create();
        }
        else if (browserName.equalsIgnoreCase(BROWSER_FIREFOX)){
            driver = WebDriverManager.firefoxdriver().arch64().enableRecording().create();
        }
        else if (browserName.equalsIgnoreCase(BROWSER_MSEDGE)){
            driver = WebDriverManager.edgedriver().arch64().enableRecording().create();
        }
        else{
            /*default one is chrome*/
            driver = WebDriverManager.chromedriver().arch64().enableRecording().create();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOutInSeconds));
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * this method will launch the app and initialize the driver and do things that are required to do that
     * @return LandingPage: returns object of the Landing page which is be default the first page you saw when you visit the home link
     * @throws IOException: throws this exception if the properties file isn't found when initializing
     */
    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApp() throws IOException {
        driver = initializeDriver(PROP_PATH, IMPLICIT_TIMEOUT_SECONDS);
        landingPage = new LandingPage(driver);
        landingPage.goTo(HOME_URL);
        return landingPage;
    }

    /**
     * used in closing the driver after the end of the test
     */
   @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
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
        File file = new File(SCREENSHOT_PATH + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return SCREENSHOT_PATH + testCaseName + ".png";
    }

    /**
     * this method is used to get the text of an webElement
     * @param webElement: this is the webElement to get the text of
     * @return String: that's is the text of that web element
     */
    public String getWebElementText(WebElement webElement){
        return webElement.getText();
    }

    /**
     * this method is used to get the text of alert
     * @return String: which is the string content of an alert
     */
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

}
