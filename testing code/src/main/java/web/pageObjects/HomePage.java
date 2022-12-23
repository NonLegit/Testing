package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.AbstractComponents.AbstractComponent;
import web.constants.PageConstants;

import java.util.List;

import static web.constants.PageConstants.EXPLICIT_TIMEOUT_SECONDS;

public class HomePage extends AbstractComponent {

    /**
     * this the driver that's used to to automate the tests
     */
    //WebDriver driver;

    /**
     * these are the list of posts that are showing the home page
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    List<WebElement> posts;

    /**
     * this is the selector of comment button on a post
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By commentButton;

    /**
     * this is the create post input in the home page
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    WebElement createPost;

    /**
     * this is the create community button
     */
    @FindBy(xpath = "//button[text()='create community']")
    WebElement createCommunityBtn;

    /**
     * this is the final create community button
     */
    @FindBy(xpath = "//button[text()='Create community']")
    WebElement createCommunityBtn2;

    /**
     * this is the input text through which we will take the name of the community
     */
    @FindBy(id = "name")
    WebElement communityNameInput;

    /**
     * this is the community type
     */
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> communityTypeList;

    /**
     * this is the check button for NSFW content
     */
    @FindBy(id = "myCheck")
    WebElement isNSFWCheckButton;


    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public HomePage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    /**
     *
     */
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/ul/div")
    WebElement MyNameButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/ul/div[2]/div/div/div/div[1]/div[2]/span")
    WebElement MyStuff;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/ul/div[2]/div/div/div/div[3]")
    WebElement Profile;

    @FindBy(xpath = "")
    WebElement FirstPost;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/div[2]/div[1]/div[2]/a")
    WebElement FirstPostOwner;

    @FindBy(xpath = "/html/body/div/header/div/div[2]/ul/div[2]/div/div/div/div[5]/a/div/span")
    WebElement SettingsButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/input")
    WebElement CreatePostsButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[3]/a[2]/button")
    WebElement CreateCommunityButton;

    @FindBy(xpath = "/html/body/div/header/div/div[1]/div/div[2]/input")
    WebElement SearchBar;



    public void setSearchBar (String Search){
        waitForWebElementToAppear(SearchBar,5);
        SearchBar.click();
        SearchBar.sendKeys(Search);
        SearchBar.sendKeys("Enter");
    }

    public void gotoCreateCommunity(){
        waitForWebElementToAppear(CreateCommunityButton,5);
        CreateCommunityButton.click();
    }

    public void gotoCreatePost(){
        waitForWebElementToAppear(CreatePostsButton,5);
        CreatePostsButton.click();
    }
    public void gotoSettings(){
        threadSleep(5);
        waitForWebElementToAppear(MyNameButton,1);
        MyNameButton.click();
        waitForWebElementToAppear(SettingsButton,1);
        if(SettingsButton.isDisplayed()){
            SettingsButton.click();
        }
    }



    public void gotoMyProfile() {

        waitForWebElementToAppear(MyNameButton, 5);
        MyNameButton.click();
        waitForWebElementToAppear(Profile, 5);
        Profile.click();

    }
    /**
     * this function is used to create a community
     * for community type:  - 0:public
     *                      - 1:Restricted
     *                      - 2:private
     */
    public CommunityPage createCommunity(String communityName, boolean isNSFW, int communityType){
        waitForWebElementToAppear(createCommunityBtn, EXPLICIT_TIMEOUT_SECONDS);
        createCommunityBtn.click();
        waitForWebElementToAppear(communityNameInput, EXPLICIT_TIMEOUT_SECONDS);
        communityNameInput.sendKeys(communityName);
        communityTypeList.get(communityType).click();

        if(isNSFW)
            isNSFWCheckButton.click();

        createCommunityBtn2.click();
        threadSleep(2);

        return new CommunityPage(driver);
    }



    /**
     * this methods clicks on one of the post to enter into it
     * @param postIndex: this is the index of the post in the home page
     * @return PostDetails: which is the object of view of the post details
     */
    public PostDetails checkPost(int postIndex){
        try {
            posts.get(postIndex).click();
            return new PostDetails(driver);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * this methods visits a post with at least specific number of comments
     * @param commentsNum: the at least number needed for post to be visited
     * @return PostDetails: which is the object of view of the post details
     */
    public PostDetails checkPostWithAtLeastNumOfComments(int commentsNum){
        for (WebElement element : posts){
            if(Integer.parseInt(element.findElement(commentButton).getText()) >= commentsNum){
                element.click();
                return new PostDetails(driver);
            }
        }
        return null;
    }

    public String gotoFirstPostOwner(){
    waitForWebElementToAppear(FirstPostOwner,1);
        if(FirstPostOwner.isDisplayed()){
            String Name =FirstPostOwner.getText();
            threadSleep(1);
            FirstPostOwner.click();
            return Name;
        }else{
            return null;
        }
    }

    public void reLogin(String Username, String Password){
        threadSleep(1);
        waitForWebElementToAppear(MyNameButton,5);
        MyNameButton.click();
        threadSleep(2);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/ul/div[2]/div/div/div/div[9]/div[2]/span")).click();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/button[2]")).click();
        threadSleep(1);
        //driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/form/div[1]/div/input")).click();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/form/div[1]/div/input")).sendKeys(Username);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/form/div[2]/div/input")).sendKeys(Password);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/form/button")).click();
    }


}
