package web.constants;

/**
 * this is a class which contains some constants used by All pageObjects
 */
public class PageConstants {


    /**
     * this is the excel path where the test data are stored
     */
    public static final String EXCEL_PATH = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\data.xlsx";


    public static final String NULL_LOCATOR = "";


    /**
     * this is the sheetName that contains login data
     */
    public static final String LOGIN_TEST_DATA = "loginTestData";

    //*************************************************************************************************************/
    //constants related to the common bar among all pages
    //*************************************************************************************************************/

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>icon through which if you click on it, it will take you to the home page</b>
     */
    public static final String HOMEPAGE_ICON_CSS =  "a[aria-label*='Home']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the drop down list through which you can choose one of the communities</b>
     */
    public static final String COMMUNITIES_SELECT_XPATH = "//div[@role='navigation']/button";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the search bar through which we can search for something</b>
     */
    public static final String SEARCHBAR_ID = "SearchDropdown";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>popular tab as it will take you to what's currently popular</b>
     */
    public static final String POPULAR_CSS = "i[class='icon icon-popular']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>coins icon</b>
     */
    public static final String COINS_ICON_CSS = "i[class*='icon icon-coins']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>currently online talks</b>
     */
    public static final String HAPPEN_NOW_XPATH = "//a[contains(@href,'now')]";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>moderation icon that will take you to moderation page</b>
     */
    public static final String MODERATION_CSS = "button[aria-label='Moderation']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>icon that will open the chat page</b>
     */
    public static final String CHAT_XPATH = "//div[@id='change-username-tooltip-id']/span[2]";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>icon that will show notification page</b>
     */
    public static final String NOTIFICATION_XPATH = "//div[@id='change-username-tooltip-id']/span[3]";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>icon through which you can create a post</b>
     */
    public static final String CREATE_POST_XPATH = "//div[@id='change-username-tooltip-id']/span[4]";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>icon through which you can advertise to something</b>
     */
    public static final String ADVERTISE_XPATH = "//div[@id='change-username-tooltip-id']/span[5]";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the drop-down list that will show user information</b>
     */
    public static final String USER_DATA_XPATH = "//button[@id='USER_DROPDOWN_ID']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the going to the popular things right now if not signed in</b>
     */
    public static final String POPULAR_NOW_CSS = "a[aria-label*='Home']+div button";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the login in button if not signed in</b>
     */
    public static final String LOGIN_BUTTON_XPATH = "//a[@role='button'][text()='Log In']";

    /**
     * this is a locator for one of the elements of the common bar at the above, you can see that bar in all pages
     * it represents the <b>the sign up button if not signed in</b>
     */
    public static final String SIGNUP_BUTTON_XPATH = "//a[@role='button'][text()='Sign Up']";


    //*************************************************************************************************************/
    //constants related to landing page or the page you see when you hop into the home link in reddit before sign in
    //*************************************************************************************************************/

    /**
     * this is the web element locator of the iframe of the login
     */
    public static final String LOGIN_POPUP_IFRAME_XPATH = "//div[@id='SHORTCUT_FOCUSABLE_DIV']/div[3]/div/div/iframe";

    /**
     * this is the index of the iframe that's used to sign into the account
     */
    public static final int LOGIN_FRAME_INDEX = 1;

    /**
     * this is the user input text field to put his username
     */
    public static final String LOGIN_USERNAME_ID = "loginUsername";

    /**
     * this is the user input text field to put his password
     */
    public static final String LOGIN_PASSWORD_ID = "loginPassword";

    /**
     * this is the button that's pressed after putting username and password to login
     */
    public static final String LOGIN_INTO_ACC_BUTTON_XPATH = "//button[@type='submit'][contains(text(),'Log')]";

    /**
     * this is the standard explicit Timeout in seconds to wait explicitly on web element
     */
    public static final int EXPLICIT_TIMEOUT_SECONDS = 3;

    /**
     * this is the error label showed when user enters his data
     */
    public static final String ERROR_LOGIN_CSS =  "div[class='AnimatedForm__errorMessage']";

    /**
     * this is the user email input text through which he can make a new account
     */
    public static final String USER_EMAIL_SIGNUP_ID = "regEmail";

    /**
     * this is the continue button in the sign up popup window
     */
    public static final String CONTINUE_SIGNUP_XPATH = "//button[@data-step='email']";

    /**
     * this is password input text in the sign up page
     */
    public static final String PASSWORD_SIGNUP_ID = "regPassword";

    /**
     * this is the username input text in the sign up page
     */
    public static final String USERNAME_SIGNUP_ID = "regUsername";

    /**
     * this is the the Captcha (I am not a robot inside the sign up page
     */
    public static final String IAM_NOT_ROBOT_SIGNUP_IFRAME_XPATH = "//iframe[@title='reCAPTCHA']";

    /**
     * this is the signup error message
     */
    public static final String SIGNUP_ERROR_MESSAGE_XPATH = "//input[@id='regUsername']/following-sibling::div[3]";


}
