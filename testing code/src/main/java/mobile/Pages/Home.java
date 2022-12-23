package mobile.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home extends Pages{

    /**
     *This Is Home Page
     */

    @FindBy(id = "Home Page")
    WebElement Home;

    /**
     *This Is Options Button In Home Pages
     */

    @FindBy(xpath = "(//android.widget.Button)[1]")
    WebElement HomeOptionsButton;

    /**
     *This Is Recently Visited Button In Home Page -> Options
     */

    @FindBy(id = "Recently Visited")
    WebElement HomeRecentlyVisitedButton;

    /**
     *This Is Recently Visited See All
     */

    @FindBy(id = "Recently Visited See All")
    WebElement HomeRecentlyVisitedSeeAll;

    /**
     *This Is First Community In Recently Visited
     */

    @FindBy(id = "First Recently Visited")
    WebElement HomeFirstRecentlyVisited;

    /**
     *This Is Moderating Button In Home Page -> Options
     */

    @FindBy(id = "Moderating")
    WebElement HomeModeratingButton;

    /**
     *This Is First Community In Moderating Section
     */

    @FindBy(id = "First Moderating")
    WebElement HomeFirstModerating;

    /**
     *This Is Home -> Moderation -> Mod Feed Button
     */
//ml8ya
    @FindBy(id = "Mod Feed")
    WebElement HomeModeratingModFeedButton;

    /**
     *This Is Home -> Moderation -> Mod Queue Button
     */
//ml8ya
    @FindBy(id = "Mod Queue")
    WebElement HomeModeratingModQueueButton;

    /**
     *This Is Home -> Moderation -> Mod Mail Button
     */
//ml8ya
    @FindBy(id = "Mod Mail")
    WebElement HomeModeratingModMailButton;

    /**
     *This Is Home -> Options -> Favourite Button
     */

    @FindBy(id = "Favourites")
    WebElement HomeFavouritesButton;

    /**
     *This Is First Community in Favourites
     */

    @FindBy(id = "First Favourite")
    WebElement HomeFirstFavourite;

    /**
     *This Is Home -> Options -> Add To Favourites Button
     */

    @FindBy(id = "Add To Favourites")
    WebElement HomeAddToFavourites;


    /**
     *This Is Home -> Options -> Your Communities Button
     */

    @FindBy(id = "Your Communities")
    WebElement HomeYourCommunitiesButton;

    /**
     *This Is Home -> Options -> Your Communities -> Create Community Button
     * to Create Your Own Communities
     */

    @FindBy(xpath = "//android.view.View[@content-desc=\"Create a community\"]")
    WebElement HomeCreateCommunityButton;

    /**
     * this is to check the state of the post when clicked on there is error message or not
     */
    @FindBy(xpath = "(//android.view.View)[6]")
    WebElement errorScreen1;

    /**
     * these are the list of the posts
     */
    @FindBy(xpath = "//android.widget.ScrollView/android.view.View")
    List<WebElement> posts;

    /**
     *This Is Home -> Options -> Your Communities -> First Community
     */

    @FindBy(id = "First In Your Community")
    WebElement HomeFirstInYourCommunities;


    /**
     *This Is Home -> Options -> Following Button
     */

    @FindBy(id = "Following")
    WebElement HomeFollowinButton;


    /**
     *This Is Home -> Options -> Following -> First Community
     */

    @FindBy(id = "First In Following")
    WebElement HomeFirstFollowing;

    /**
     *This Is Home Drop-Down In The Top Of The Home Page
     */

    @FindBy(xpath = "(//android.widget.Button)[1]")
    WebElement HomeButtonUpper;

    /**
     *This Is Home Button In The Bottom Of The Home Page
     */

    @FindBy(id = "Second Home Button")
    WebElement HomeButtonLower;

    /**
     *This Is Search Button In The Home Page
     */

    @FindBy(id = "Search")
    WebElement HomeSearchButton;

    /**
     *This Is Profile Icon Button In The Home Page
     */

    @FindBy(id = "Avatar")
    WebElement HomeAvatarButton;

    /**
     *This Is Discover Button In The Home Page
     */

    @FindBy(id = "Discover")
    WebElement HomeDiscoverButton;

    /**
     *This Is Creates Post Button In The Home Page
     */

    @FindBy(id = "Create Post")
    WebElement HomeCreatePostButton;

    /**
     *This Is Chat Button In The Home Page
     */

    @FindBy(id = "Chat")
    WebElement HomeChatButton;

    /**
     *This Is Notifications Button In The Home Page
     */

    @FindBy(id = "Notifications")
    WebElement HomeNotificationsButton;


    /**
     *This Is Status Button In The Home Page
     */

    @FindBy(id = "Status")
    WebElement HomeStatusButton;

    /**
     *This Is My User-Name In The Home Page
     */

    @FindBy(id = "My Name")
    WebElement HomeUserName;

    /**
     *This Is My Profile Button In The Home Page
     */

    @FindBy(id = "My Profile")
    WebElement HomeMyProfileButton;


    /**
     *This Is Creates Community Button In The Profile Slider In Home Page
     */

    @FindBy(id = "Second Create Community")
    WebElement HomeCreateCommunity2Button;

    /**
     *This Is Saved Button In The Home Page
     */

    @FindBy(id = "Saved")
    WebElement HomeSavedButton;


    /**
     *This Is History Button In The Home Page
     */

    @FindBy(id = "History")
    WebElement HomeHistoryButton;


    /**
     *This Is Settings Button In The Home Page
     */
    @FindBy(id = "Settings")
    WebElement HomeSettingButton;

    /**
     * this is the scroll bar
     */
    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement scrollBar;

    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public Home(AndroidDriver driver) {
        super(driver);
    }


    public String gotoMyProfile() {
        try {
            HomeAvatarButton.click();
            HomeMyProfileButton.click();
        }catch(Exception ignore){
            return "fail";
        }
        return"success";
    }
    public void clickCreatePost(){
        HomeCreatePostButton.click();
    }

    public void openSearch() {
        HomeSearchButton.click();
    }


    public String getFirstRecentlyVisited() {
        HomeOptionsButton.click();
        /////make sure recently button is pressed
       return HomeFirstRecentlyVisited.getText();
    }

    public boolean clickFirstRecentlyVisited() {
        if(HomeFirstRecentlyVisited.isDisplayed()){
            HomeFirstRecentlyVisited.click();
            return true;
        }
        return false;
    }

    public CreateCommunity gotoCreateCommunity(){
        HomeOptionsButton.click();
        threadSleep(1);
        scrollToEndAction();
        HomeCreateCommunityButton.click();
        threadSleep(1);
        return new CreateCommunity(driver);
    }

    public boolean gotoYourCommunities(){
        try{
            HomeOptionsButton.click();
            //Home Your Communities is pressed
            HomeFirstInYourCommunities.click();
        }catch (Exception ignore){
            return false;
        }
        return true;
    }

    public boolean gotoFollowing(String Name)
    {
        try{
            HomeOptionsButton.click();
            if(Name!=HomeFirstFollowing.getText()){
                return false;
            }
            else{
                HomeFirstFollowing.click();
            }

        }catch (Exception e){
            return false;
        }
        return true;
    }

    public String addFavourite(){
        try {

            if(HomeFirstFollowing.isDisplayed()) {
                HomeAddToFavourites.click();
                return HomeFirstFollowing.getText();
            }
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public boolean gotoFavourite(String Name) {
        try {
            HomeOptionsButton.click();
            if (Name != HomeFirstFavourite.getText()) {
                return false;
            } else {
                HomeFirstFavourite.click();
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * this is the method used to go to the post details
     */
    public PostDetails checkPost(int postIndex){
        posts.get(postIndex).click();
        threadSleep(1);
        if (errorScreen1 != null && errorScreen1.isDisplayed())
            return null;
        else
            return new PostDetails(driver);
    }


}
