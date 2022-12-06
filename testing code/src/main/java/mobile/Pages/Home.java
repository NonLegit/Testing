package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Pages{

    /**
     *This Is Home Page
     */

    @FindBy(id = "Home Page")
    MobileElement Home;

    /**
     *This Is Options Button In Home Pages
     */

    @FindBy(id = "Options")
    MobileElement HomeOptionsButton;

    /**
     *This Is Recently Visited Button In Home Page -> Options
     */

    @FindBy(id = "Recently Visited")
    MobileElement HomeRecentlyVisitedButton;

    /**
     *This Is Recently Visited See All
     */

    @FindBy(id = "Recently Visited See All")
    MobileElement HomeRecentlyVisitedSeeAll;

    /**
     *This Is First Community In Recently Visited
     */

    @FindBy(id = "First Recently Visited")
    MobileElement HomeFirstRecentlyVisited;

    /**
     *This Is Moderating Button In Home Page -> Options
     */

    @FindBy(id = "Moderating")
    MobileElement HomeModeratingButton;

    /**
     *This Is First Community In Moderating Section
     */

    @FindBy(id = "First Moderating")
    MobileElement HomeFirstModerating;

    /**
     *This Is Home -> Moderation -> Mod Feed Button
     */
//ml8ya
    @FindBy(id = "Mod Feed")
    MobileElement HomeModeratingModFeedButton;

    /**
     *This Is Home -> Moderation -> Mod Queue Button
     */
//ml8ya
    @FindBy(id = "Mod Queue")
    MobileElement HomeModeratingModQueueButton;

    /**
     *This Is Home -> Moderation -> Mod Mail Button
     */
//ml8ya
    @FindBy(id = "Mod Mail")
    MobileElement HomeModeratingModMailButton;

    /**
     *This Is Home -> Options -> Favourite Button
     */

    @FindBy(id = "Favourites")
    MobileElement HomeFavouritesButton;

    /**
     *This Is First Community in Favourites
     */

    @FindBy(id = "First Favourite")
    MobileElement HomeFirstFavourite;

    /**
     *This Is Home -> Options -> Add To Favourites Button
     */

    @FindBy(id = "Add To Favourites")
    MobileElement HomeAddToFavourites;


    /**
     *This Is Home -> Options -> Your Communities Button
     */

    @FindBy(id = "Your Communities")
    MobileElement HomeYourCommunitiesButton;

    /**
     *This Is Home -> Options -> Your Communities -> Create Community Button
     * to Create Your Own Communities
     */

    @FindBy(id = "Create Community")
    MobileElement HomeCreateCommunityButton;

    /**
     *This Is Home -> Options -> Your Communities -> First Community
     */

    @FindBy(id = "First In Your Community")
    MobileElement HomeFirstInYourCommunities;


    /**
     *This Is Home -> Options -> Following Button
     */

    @FindBy(id = "Following")
    MobileElement HomeFollowinButton;


    /**
     *This Is Home -> Options -> Following -> First Community
     */

    @FindBy(id = "First In Following")
    MobileElement HomeFirstFollowing;

    /**
     *This Is Home Drop-Down In The Top Of The Home Page
     */

    @FindBy(id = "First Home Button")
    MobileElement HomeButtonUpper;

    /**
     *This Is Home Button In The Bottom Of The Home Page
     */

    @FindBy(id = "Second Home Button")
    MobileElement HomeButtonLower;

    /**
     *This Is Search Button In The Home Page
     */

    @FindBy(id = "Search")
    MobileElement HomeSearchButton;

    /**
     *This Is Profile Icon Button In The Home Page
     */

    @FindBy(id = "Avatar")
    MobileElement HomeAvatarButton;

    /**
     *This Is Discover Button In The Home Page
     */

    @FindBy(id = "Discover")
    MobileElement HomeDiscoverButton;

    /**
     *This Is Creates Post Button In The Home Page
     */

    @FindBy(id = "Create Post")
    MobileElement HomeCreatePostButton;

    /**
     *This Is Chat Button In The Home Page
     */

    @FindBy(id = "Chat")
    MobileElement HomeChatButton;

    /**
     *This Is Notifications Button In The Home Page
     */

    @FindBy(id = "Notifications")
    MobileElement HomeNotificationsButton;


    /**
     *This Is Status Button In The Home Page
     */

    @FindBy(id = "Status")
    MobileElement HomeStatusButton;

    /**
     *This Is My User-Name In The Home Page
     */

    @FindBy(id = "My Name")
    MobileElement HomeUserName;

    /**
     *This Is My Profile Button In The Home Page
     */

    @FindBy(id = "My Profile")
    MobileElement HomeMyProfileButton;


    /**
     *This Is Creates Community Button In The Profile Slider In Home Page
     */

    @FindBy(id = "Second Create Community")
    MobileElement HomeCreateCommunity2Button;

    /**
     *This Is Saved Button In The Home Page
     */

    @FindBy(id = "Saved")
    MobileElement HomeSavedButton;


    /**
     *This Is History Button In The Home Page
     */

    @FindBy(id = "History")
    MobileElement HomeHistoryButton;


    /**
     *This Is Settings Button In The Home Page
     */

    @FindBy(id = "Settings")
    MobileElement HomeSettingButton;




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

    public boolean gotoCreateCommunity(){
        try{
            HomeOptionsButton.click();
            HomeCreateCommunityButton.click();
        }catch (Exception i){
            return false;
        }
        return true;
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






}