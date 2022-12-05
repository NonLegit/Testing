package mobile.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for declare my profile page components
 */
public class MyProfilePage extends Pages{

    /**
     * declare driver which used to access elements
     */
    AppiumDriver<MobileElement> driver;


    /**
     * Post Button In My Profile
     */
   @FindBy(xpath ="//android.view.View[@content-desc='Posts Tab 1 of 3']")
   MobileElement MyProfilePostsButton;

    public void clickMyProfilePostsButton(){
        MyProfilePostsButton.click();
    }

    /**
     * NoNlegit App : Comments Button In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Comments Tab 2 of 3'")
    MobileElement MyProfileCommentsButton;

    public void clickMyProfileCommentsButton(){
        MyProfileCommentsButton.click();
    }

    /**
     * NoNlegit App : About Button In My Profile
     */
    @FindBy(xpath =	"//android.view.View[@content-desc='About Tab 3 of 3']")
    MobileElement MyProfileAboutButton;

    public void clickMyProfileAboutButton(){
        MyProfileAboutButton.click();
    }

    /**
     * NoNlegit App : Edit Button In My Profile
     */
    @FindBy(xpath ="//android.widget.Button[@content-desc='Edit']")
    MobileElement MyProfileEditButton;

    public void clickMyProfileEditButton(){
        MyProfileCommentsButton.click();
    }



    /**
     * NoNlegit App : User Name In My Profile
     */
    @FindBy(xpath ="(//android.view.View)[13]")
    MobileElement MyProfileUserName;

    /**
     *
     * @return This Function Returns The User-Name Appears In My Profile
     */
    public String readMyProfileUserName(){
       return MyProfileCommentsButton.getText();
    }



    /**
     * NoNlegit App : Number Of Followers In My Profile
     */
    @FindBy(xpath ="(//android.widget.Button)[3]")
    MobileElement MyProfileFollowers;

    /**
     *
     */
    public void clickMyProfileFollowers(){
        MyProfileFollowers.click();
    }

    /**
     *
     * @return This Function Returns The Number Of Followers Appears In My Profile
     */

    public String getNumberOfFollowers(){
        return MyProfileFollowers.getText();
    }

    /**
     * NoNlegit App : Sort By tab In My Profile
     */
    @FindBy(xpath ="(//android.widget.Button)[4]")
    MobileElement MyProfileSortBy;

    /**
     * This Function Click The Drop-Down Menu Of the Sort By
     */
    public void clickMyProfileSortBy(){
       MyProfileSortBy.click();
    }

    /**
     * NoNlegit App : Sort By Window In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='SORT POSTS BY']")
    MobileElement MyProfileSortByWindow;



    /**
     *
     * @return This Function Return The Name Of The Popped Window When Pressing The Sort By Tab
     */

    public String readMyProfileSortBy(){
        return MyProfileSortByWindow.getText();
    }

    /**
     * NoNlegit App : Sort By Window : Hot Tab In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Hot']")
    MobileElement MyProfileSortByWindowHot;

    /**
     * This Function chooses Hot Post
     */
    public void clickMyProfileSortByWindowHot(){
        MyProfileSortByWindowHot.click();
    }

    /**
     * NoNlegit App : Sort By Window : New Button In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='New']")
    MobileElement MyProfileSortByWindowNew;

    /**
     *
     */
    public void clickMyProfileSortByWindowNew(){
        MyProfileSortByWindowNew.click();
    }


    /**
     * NoNlegit App : Sort By Window : Top In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Top']")
    MobileElement MyProfileSortByWindowTop;

    /**
     *
     */
    public void clickMyProfileSortByWindowTop(){
        MyProfileSortByWindowTop.click();
    }


    @FindBy(id="First Post")
    MobileElement MyProfileFirstPost;

    ///Make it general Post
    public String clickPost(){
        try{
            MyProfileFirstPost.click();
        }catch(Exception i){
            return"fail";
        }
            return "success";
    }

}
