package web.pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import web.AbstractComponents.AbstractComponent;

import java.util.Iterator;
import java.util.Set;

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
    @FindBy(id = ":r5:")
    WebElement usernameInputText;

    /**
     * this is the continue with google account button
     */
    @FindBy(xpath = "//button[.='continue with google']")
    WebElement continueWithGoogleBtn;

    /**
     * this is the continue with facebook account button
     */
    @FindBy(xpath = "//button[.='continue with facebook']")
    WebElement continueWithFacebookBtn;

    /**
     * this is a button to click on forget username
     */
    @FindBy(xpath = "//a[@data-testid='login-forgetuser']")
    WebElement forgetUserNameBtn;

    /**
     * this is the input text through which we will enter the email address
     */
    @FindBy(id = ":r8:")
    WebElement  EmailAddrForget;

    /**
     * this is the input text through which we will enter user email in forget user pass
     */
    @FindBy(id = ":r9:")
    WebElement emailAddrForget;

    /**
     * this is the captcha in the forget username
     */
    @FindBy(id = "rc-anchor-container")
    WebElement forgetUsernameCaptcha;

    /**
     * this is the captcha related to forget username
     */
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement RecaptchaIframe;

    /**
     * this is the email me button
     */
    @FindBy(xpath = "//button[text()='Email Me']")
    WebElement emailMeBtn;

    /**
     * this is the reset password button
     */
    @FindBy(xpath = "//button[text()='Reset Password']")
    WebElement resetPassBtn;

    /**
     * this is a button to click on forget userpassword
     */
    @FindBy(xpath = "//a[@data-testid='login-forgetpass']")
    WebElement forgetUserPasswordBtn;


    /**
     * this is the google login email input text
     */
    @FindBy(name = "identifier")
    WebElement googleLoginEmail;

    /**
     * this is the facebook login email input text
     */
    @FindBy(id = "email")
    WebElement facebookLoginEmail;

    /**
     * this is the facebook login password input text
     */
    @FindBy(id = "pass")
    WebElement facebookLoginPassword;

    /**
     * this is the facebook login in button
     */
    @FindBy(name = "login")
    WebElement facebookLoginBtn;

    /**
     * this is the continue as button
     */
    @FindBy(css = "div[aria-label*='Continue as']")
    WebElement facebookContinueAs;

    /**
     * this is the button that switch to next page to continue login in with google
     */
    @FindBy(xpath = "(//span[@class='VfPpkd-vQzf8d'])[2]")
    WebElement googleNextBtn1;

    /**
     * this is the google login input password text
     */
    @FindBy(name = "password")
    WebElement googleLoginPassword;

    /**
     * just a small web element from the home page to test the login in success
     */
    @FindBy(css = "p[class='MuiTypography-root MuiTypography-body1 css-9fpt74-MuiTypography-root']")
    WebElement userNameIconProfileText;

    /**
     * this is the user password input text
     */
    @FindBy(id = ":r6:")
    WebElement passwordInputText;

    /**
     * this is the login into account button
     */
    @FindBy(id = ":r7:")
    WebElement loginIntoAccButton;

    /**
     * this is the iframe window of the login
     */
    @FindBy(xpath = LOGIN_POPUP_IFRAME_XPATH)
    WebElement loginPopupIframe;

    /**
     * this is the label web element that's the error state of the login
     */
    @FindBy(xpath = "//p[text()='Incorrect username or password' or text() = 'Username must be between 3 and 20 characters']")
    WebElement loginErrorMessageLabel;

    /**
     * this is the input text that take user email
     */
    @FindBy(id = USER_EMAIL_SIGNUP_ID)
    WebElement emailInputText;

    /**
     * complete signup button
     */
    @FindBy(xpath = "//button[.='Sign up']")
    WebElement completeSignUp;

    /**
     * error message 1
     */
    By error1 = By.xpath("//p[text()='Username must be between 3 and 20 characters']");

    /**
     * error message 2
     */
    By error2 = By.xpath("//p[text()='Password must be at least 8 characters long']");

    /**
     * error message 3
     */
    By error3 = By.xpath("//*[local-name()='svg' and @data-testid='PriorityHighIcon']");

    /**
     * error message 4
     */
    By error4 = By.xpath("//p[text()='the user already exists']");

    /**
     * error message 5
     */
    By error5 = By.xpath("//p[.=\"This Password isn't acceptable\"]");

    /**
     * error message 6
     */
    By error6 = By.xpath("//p[text()='That user already exists.']");

    /**
     * to refresh and get the suggested username
     */
    @FindBy(xpath = "//*[local-name()='svg' and @data-testid='PublishedWithChangesIcon']")
    WebElement refreshSuggestedName;

    /**
     * this the continue button in sign up page
     */
    @FindBy(xpath = CONTINUE_SIGNUP_XPATH)
    WebElement continueSignupButton;

    /**
     * this is the user password input text in the sign up page
     */
    @FindBy(xpath = "(//input[@type='password'])")
    WebElement passwordSignUpInputText;

    /**
     * this is the username input text in the sign up page
     */
    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement usernameSignupInputText;

    /**
     * this is the I am not a robot box
     */
    @FindBy(id = "recaptcha-anchor")
    WebElement captchaCheckBox;

    /**
     * this the signup error message
     */
    @FindBy(id = ":r5:-helper-text")
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
     * @return HomePage: object of the home page after login in
     */
    public HomePage NormalLogin(String username, String password){
        loginButton.click();
        waitForWebElementToAppear(usernameInputText, EXPLICIT_TIMEOUT_SECONDS);
        usernameInputText.sendKeys(username);
        passwordInputText.sendKeys(password);
        loginIntoAccButton.click();

        try {
            waitForWebElementToAppear(loginErrorMessageLabel, EXPLICIT_TIMEOUT_SECONDS);
        }catch (Exception e){
            return new HomePage(driver);
        }

        if(loginErrorMessageLabel!= null && loginErrorMessageLabel.isDisplayed())
            return null;
        else
            return new HomePage(driver);
    }

    /**
     * this is a function used to login using google and return the next page if success
     * @return HomePage: the home page in case of success
     */
    public HomePage googleLogin(String email, String password) throws InterruptedException {
        loginButton.click();
        waitForWebElementToAppear(continueWithGoogleBtn, EXPLICIT_TIMEOUT_SECONDS);
        Thread.sleep(3000);
        continueWithGoogleBtn.click();

        Set<String>windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        googleLoginEmail.sendKeys(email);
        googleNextBtn1.click();

        waitForWebElementToAppear(googleLoginPassword, EXPLICIT_TIMEOUT_SECONDS);
        googleLoginPassword.sendKeys(password);
        threadSleep(2);
        googleNextBtn1.click();
        threadSleep(1);
        driver.switchTo().window(parent);

        try {
            waitForWebElementToAppear(userNameIconProfileText, 10);
        }catch (Exception e){
            return null;
        }

        if(userNameIconProfileText!= null && userNameIconProfileText.isDisplayed())
            return new HomePage(driver);
        else
            return null;
    }

    /**
     * this is a function used to login using google and return the next page if success
     * @return HomePage: the home page in case of success
     */
    public HomePage googleSignUp(String email, String password) throws InterruptedException {
        signupButton.click();
        waitForWebElementToAppear(continueWithGoogleBtn, EXPLICIT_TIMEOUT_SECONDS);
        Thread.sleep(3000);
        continueWithGoogleBtn.click();

        Set<String>windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        googleLoginEmail.sendKeys(email);
        googleNextBtn1.click();

        waitForWebElementToAppear(googleLoginPassword, EXPLICIT_TIMEOUT_SECONDS);
        googleLoginPassword.sendKeys(password);
        threadSleep(2);
        googleNextBtn1.click();
        threadSleep(1);
        driver.switchTo().window(parent);

        try {
            waitForWebElementToAppear(userNameIconProfileText, 10);
        }catch (Exception e){
            return null;
        }

        if(userNameIconProfileText!= null && userNameIconProfileText.isDisplayed())
            return new HomePage(driver);
        else
            return null;
    }

    /**
     * this is a function used to login using facebook and return the next page if success
     * @return HomePage: the home page in case of success
     */
    public HomePage facebookLogin(String email, String password) throws InterruptedException {
        loginButton.click();
        waitForWebElementToAppear(continueWithFacebookBtn, EXPLICIT_TIMEOUT_SECONDS);
        Thread.sleep(3000);
        continueWithFacebookBtn.click();

        Set<String>windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);

        waitForWebElementToAppear(facebookLoginEmail, EXPLICIT_TIMEOUT_SECONDS);
        facebookLoginEmail.sendKeys(email);
        facebookLoginPassword.sendKeys(password);
        facebookLoginBtn.click();

        waitForWebElementToAppear(facebookContinueAs, EXPLICIT_TIMEOUT_SECONDS);
        facebookContinueAs.click();

        driver.switchTo().window(parent);

        try {
            waitForWebElementToAppear(userNameIconProfileText, 10);
        }catch (Exception e){
            return null;
        }

        if(userNameIconProfileText!= null && userNameIconProfileText.isDisplayed())
            return new HomePage(driver);
        else
            return null;
    }


    /**
     * this is a function used to login using facebook and return the next page if success
     * @return HomePage: the home page in case of success
     */
    public HomePage facebookSignUp(String email, String password) throws InterruptedException {
        signupButton.click();
        waitForWebElementToAppear(continueWithFacebookBtn, EXPLICIT_TIMEOUT_SECONDS);
        Thread.sleep(3000);
        continueWithFacebookBtn.click();

        Set<String>windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);

        waitForWebElementToAppear(facebookLoginEmail, EXPLICIT_TIMEOUT_SECONDS);
        facebookLoginEmail.sendKeys(email);
        facebookLoginPassword.sendKeys(password);
        facebookLoginBtn.click();

        waitForWebElementToAppear(facebookContinueAs, EXPLICIT_TIMEOUT_SECONDS);
        facebookContinueAs.click();

        driver.switchTo().window(parent);

        try {
            waitForWebElementToAppear(userNameIconProfileText, 10);
        }catch (Exception e){
            return null;
        }

        if(userNameIconProfileText!= null && userNameIconProfileText.isDisplayed())
            return new HomePage(driver);
        else
            return null;
    }

    /**
     * this is a function used to forget the username
     */
    public void forgetUserName(String email) throws InterruptedException {
        loginButton.click();

        waitForWebElementToAppear(forgetUserNameBtn, EXPLICIT_TIMEOUT_SECONDS);
        forgetUserNameBtn.click();

        waitForWebElementToAppear(EmailAddrForget, EXPLICIT_TIMEOUT_SECONDS);
        EmailAddrForget.sendKeys(email);

        waitForFrameToBeAvailable(RecaptchaIframe, 5);

        forgetUsernameCaptcha.click();
        driver.switchTo().parentFrame();
        emailMeBtn.click();
        waitForWebElementToDisappear(emailInputText, 6);
    }

    /**
     * this is a function used to forget the user password
     */
    public void forgetUserPassword(String email, String username) throws InterruptedException {
        loginButton.click();

        waitForWebElementToAppear(forgetUserPasswordBtn, EXPLICIT_TIMEOUT_SECONDS);
        forgetUserPasswordBtn.click();


        waitForWebElementToAppear(EmailAddrForget, EXPLICIT_TIMEOUT_SECONDS);
        EmailAddrForget.sendKeys(username);
        emailAddrForget.sendKeys(email);
        resetPassBtn.click();
        waitForWebElementToDisappear(resetPassBtn, 6);
    }

    /**
     * this function tries to sig up a randomized email and username to try and create a user
     */
    public HomePage RandomSignup(String username,String email, String password){
        signupButton.click();
        waitForWebElementToAppear(emailInputText, 5);
        emailInputText.sendKeys(email);
        threadSleep(1);
        continueSignupButton.click();
        threadSleep(1);
        waitForWebElementToAppear(usernameSignupInputText, EXPLICIT_TIMEOUT_SECONDS);
        usernameSignupInputText.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        usernameSignupInputText.sendKeys(username);
        threadSleep(1);
        passwordSignUpInputText.sendKeys(password);
        threadSleep(1);
        waitForFrameToBeAvailable(RecaptchaIframe, EXPLICIT_TIMEOUT_SECONDS);
        threadSleep(1);
        captchaCheckBox.click();
        driver.switchTo().parentFrame();
        threadSleep(1);
        completeSignUp.click();

        if(driver.findElements(error1).size() > 0  || driver.findElements(error2).size() > 0  || driver.findElements(error3).size() > 0 ||
        driver.findElements(error4).size() > 0 || driver.findElements(error5).size() > 0 || driver.findElements(error6).size() > 0)
            return null;
        else
            return new HomePage(driver);
    }

    /**
     * this function tries to sig up a email and suggested username to try and create a user
     */
    public String suggestedSignup(String email, String password){
        String suggestedUserName;
        signupButton.click();
        waitForWebElementToAppear(emailInputText, 5);
        emailInputText.sendKeys(email);
        threadSleep(1);
        continueSignupButton.click();
        threadSleep(1);
        waitForWebElementToAppear(usernameSignupInputText, EXPLICIT_TIMEOUT_SECONDS);
        refreshSuggestedName.click();
        threadSleep(1);
        suggestedUserName = usernameSignupInputText.getAttribute("value");
        System.out.println(suggestedUserName);
        threadSleep(1);
        passwordSignUpInputText.sendKeys(password);
        threadSleep(2);
        waitForFrameToBeAvailable(RecaptchaIframe, EXPLICIT_TIMEOUT_SECONDS);
        threadSleep(1);
        captchaCheckBox.click();
        driver.switchTo().parentFrame();
        threadSleep(10);
        completeSignUp.click();

        if(driver.findElements(error1).size() > 0  || driver.findElements(error2).size() > 0  || driver.findElements(error3).size() > 0 ||
                driver.findElements(error4).size() > 0 || driver.findElements(error5).size() > 0 || driver.findElements(error6).size() > 0)
            return null;
        else
            return suggestedUserName;
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
