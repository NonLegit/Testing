package web.pageObjects;


import web.AbstractComponents.AbstractComponent;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static web.constants.PageConstants.*;


/**
 * this is the webpage with the link <a href="https://www.reddit.com/">https://www.reddit.com/</a>
 */
public class LandingPage extends AbstractComponent {

    /**
     * this is the webDriver through which we can run the tests
     */
    WebDriver driver;

    /**
     * this is the username input text
     */
    @FindBy(id = LOGIN_USERNAME_ID)
    WebElement usernameInputText;

    /**
     * this is the user password input text
     */
    @FindBy(id = LOGIN_PASSWORD_ID)
    WebElement passwordInputText;

    /**
     * this is the login into account button
     */
    @FindBy(xpath = LOGIN_INTO_ACC_BUTTON_XPATH)
    WebElement loginIntoAccButton;

    /**
     * this is the iframe window of the login
     */
    @FindBy(xpath = LOGIN_POPUP_IFRAME_XPATH)
    WebElement loginPopupIframe;

    /**
     * this is the label web element that's the error state of the login
     */
    @FindBy(css = ERROR_LOGIN_CSS)
    WebElement loginErrorMessageLabel;

    /**
     * this is the input text that take user email
     */
    @FindBy(id = USER_EMAIL_SIGNUP_ID)
    WebElement emailInputText;

    /**
     * this the continue button in sign up page
     */
    @FindBy(xpath = CONTINUE_SIGNUP_XPATH)
    WebElement continueSignupButton;

    /**
     * this is the user password input text in the sign up page
     */
    @FindBy(id = PASSWORD_SIGNUP_ID)
    WebElement passwordSignUpInputText;

    /**
     * this is the username input text in the sign up page
     */
    @FindBy(id = USERNAME_SIGNUP_ID)
    WebElement usernameSignupInputText;

    /**
     * this is the I am not a robot box
     */
    @FindBy(xpath = IAM_NOT_ROBOT_SIGNUP_IFRAME_XPATH)
    WebElement captchaCheckBox;

    /**
     * this the signup error message
     */
    @FindBy(xpath = SIGNUP_ERROR_MESSAGE_XPATH)
    WebElement errorMessageSignUpText;

    /**
     * this is the constructor of the Landing Page
     * @param driver: used to initialize the data member of the Landing Page
     */
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * used to visit the landing page
     * @param url: the url of the first page in reddit
     */
    public void goTo(String url){
        driver.get(url);
    }

    /**
     * this is a function used to login and return the next page if success
     */
    public String login(String username, String password){
        loginButton.click();
        waitForFrameToBeAvailable(loginPopupIframe, EXPLICIT_TIMEOUT_SECONDS);
        //driver.switchTo().frame(LOGIN_FRAME_INDEX);
        usernameInputText.sendKeys(username);
        passwordInputText.sendKeys(password);
        loginIntoAccButton.click();
        /*TODO: edit this return value of the function*/
        return "";
    }

    /**
     * this function tries to generate a randomized email and username to try and create a user
     */
    public String signup(String username,String email, String password){
        signupButton.click();
        waitForFrameToBeAvailable(loginPopupIframe, EXPLICIT_TIMEOUT_SECONDS);
        //driver.switchTo().frame(LOGIN_FRAME_INDEX);
        emailInputText.sendKeys(email);
        continueSignupButton.click();
        waitForWebElementToAppear(usernameSignupInputText, EXPLICIT_TIMEOUT_SECONDS);
        usernameSignupInputText.clear();
        usernameSignupInputText.sendKeys(username);
        passwordSignUpInputText.sendKeys(password);
        waitForFrameToBeAvailable(captchaCheckBox, EXPLICIT_TIMEOUT_SECONDS);
        driver.switchTo().frame(captchaCheckBox);
        captchaCheckBox.click();

        /*TODO: edit this return value of the function*/
        return "";


    }

    /**
     * this function gets the error string produced by the signup
     * @return String: which is the error message due to analogousness of username
     */
    public String getSignUpErrorMessage(){
        if(errorMessageSignUpText.isDisplayed())
            return errorMessageSignUpText.getText();
        else
            return null;
    }

    /**
     * this method returns the error message of the login page
     * @return String: that represents the error message
     */
    public String getLoginErrorMessage(){
        try {
            String dummy = usernameInputText.getAttribute("validationMessage").isEmpty() ? passwordInputText.getAttribute("validationMessage") : usernameInputText.getAttribute("validationMessage");
            System.out.println("dummy = " + dummy);
            if (dummy.isEmpty()){
                waitForWebElementToAppear(loginErrorMessageLabel, 1);
                return loginErrorMessageLabel.getText();
            }else{
                return dummy;
            }
        }catch (TimeoutException e){
            return "success";
        }

    }

}
