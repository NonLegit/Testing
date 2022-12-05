package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class CreatePost extends Pages {

    /**
     * This Is Crete Post Page Title
     */
    @FindBy(id = "Create Post")
    MobileElement CreatePostPage;

    /**
     * This is Cancel Button In Create Post Page
     */
    @FindBy(id = "Cancel")
    MobileElement CreatePostCancelButton;

    /**
     * This Is Next Button In Create Post Page
     */
    @FindBy(id = "Next")
    MobileElement CreatePostNextButton;

    /**
     * This Is The Title Of  Your Post
     */

    //Send "Enter" to end text
    @FindBy(id = "Title")
    MobileElement CreatePostTitleText;

    /**
     * This Is Add Image Button
     */


    @FindBy(id = "Add Image")
    MobileElement CreatePostAddImageButton;

    /**
     * This Is First Image Added To The Post
     */

    @FindBy(id = "First Image")
    MobileElement CreatePostFirstImage;

    /**
     * This Is Cancel Image Button To Delete Specific Image
     */

    @FindBy(id = "Delete This Image")
    MobileElement CreatePostDeleteImageButton;

    /**
     * This Is Add Another Image Button
     */

    @FindBy(id = "Add Another Image")
    MobileElement CreatePostAddAnotherImageButton;


    /**
     * This IS Add video Button
     */
    @FindBy(id = "Add Video")
    MobileElement CreatePostAddVideoButton;

    /**
     * This IS Add Body Text Button
     */
    @FindBy(id = "Add Text")
    MobileElement CreatePostAddTextButton;

    /**
     * This IS  Body Text Button
     */
    @FindBy(id = "Add Text")
    MobileElement CreatePostTextarea;

    /**
     * This IS Add Link Button
     */
    @FindBy(id = "Add Link")
    MobileElement CreatePostAddLinkButton;

    /**
     * This IS Add Poll Button
     */
    @FindBy(id = "Add Poll")
    MobileElement CreatePostAddPollButton;

    /**
     * This IS Add Talk Button
     */
    @FindBy(id = "Add Talk")
    MobileElement CreatePostAddVoiceButton;


    @FindBy(id = "Search For Cumm")
    MobileElement CreatePostSearchCommunity;

    @FindBy(id = "First Community in Search")
    MobileElement CreatePostFirstCommunity;

    @FindBy(id = "PostButton")
    MobileElement PostButton;


    @FindBy(id="Discard Message")
    MobileElement DiscardMessage;

    @FindBy(id="Discard")
    MobileElement DiscardButton;

/////Will ADd Flare and post schedule after finishing them

    public String writePost(String Title, String Text, String CommunityName) {
        try {
            CreatePostTitleText.sendKeys(Title);
            CreatePostAddTextButton.click();
            /// MinimizeKB().click()
            CreatePostTextarea.sendKeys(Text);
            CreatePostNextButton.click();
            CreatePostSearchCommunity.sendKeys(CommunityName);
            CreatePostFirstCommunity.click();
            PostButton.click();
        } catch (Exception ex) {
            return "fail";
        }
        return "success";
    }

    public boolean cancelPost(String Title, String Text) {
        try {
            CreatePostTitleText.sendKeys(Title);
            CreatePostAddTextButton.click();
            /// MinimizeKB().click()
            CreatePostTextarea.sendKeys(Text);
            CreatePostCancelButton.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDiscardMessage(){
        return DiscardMessage.isDisplayed();
    }

    public void discard(){
        DiscardButton.click();
    }







}
