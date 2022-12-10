package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for declare my profile page components
 */
public class MyProfilePage extends Pages{

    /**
     * declare driver which used to access elements
     */
    //AppiumDriver<WebElement> driver;


    /**
     * Post Button In My Profile
     */
   @FindBy(xpath ="//android.view.View[@content-desc='Posts Tab 1 of 3']")
    WebElement MyProfilePostsButton;

    public void clickMyProfilePostsButton(){
        MyProfilePostsButton.click();
    }

    /**
     * NoNlegit App : Comments Button In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Comments Tab 2 of 3'")
    WebElement MyProfileCommentsButton;

    public void clickMyProfileCommentsButton(){
        MyProfileCommentsButton.click();
    }

    /**
     * NoNlegit App : About Button In My Profile
     */
    @FindBy(xpath =	"//android.view.View[@content-desc='About Tab 3 of 3']")
    WebElement MyProfileAboutButton;

    public void clickMyProfileAboutButton(){
        MyProfileAboutButton.click();
    }

    /**
     * NoNlegit App : Edit Button In My Profile
     */
    @FindBy(xpath ="//android.widget.Button[@content-desc='Edit']")
    WebElement MyProfileEditButton;

    public void clickMyProfileEditButton(){
        MyProfileCommentsButton.click();
    }



    /**
     * NoNlegit App : User Name In My Profile
     */
    @FindBy(xpath ="(//android.view.View)[13]")
    WebElement MyProfileUserName;

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
    WebElement MyProfileFollowers;

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
    WebElement MyProfileSortBy;

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
    WebElement MyProfileSortByWindow;



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
    WebElement MyProfileSortByWindowHot;

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
    WebElement MyProfileSortByWindowNew;

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
    WebElement MyProfileSortByWindowTop;

    /**
     *
     */
    public void clickMyProfileSortByWindowTop(){
        MyProfileSortByWindowTop.click();
    }


    @FindBy(id="First Post")
    WebElement MyProfileFirstPost;

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
