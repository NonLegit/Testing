package mobile.Pages;


import io.appium.java_client.android.AndroidDriver;

/**
 * This class for NoNlegit app starting page with activity""
 */

public class StaringPage extends Pages{
    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public StaringPage(AndroidDriver driver) {
        super(driver);
    }
    /**
     *  declare the driver which used to access elements
     */
    //AppiumDriver<MobileElement> driver;

}