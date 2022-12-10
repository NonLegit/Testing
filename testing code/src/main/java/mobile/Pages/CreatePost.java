package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePost extends Pages {

    /**
     * This Is Crete Post Page Title
     */
    @FindBy(id = "Create Post")
    WebElement CreatePostPage;

    /**
     * This is Cancel Button In Create Post Page
     */
    @FindBy(id = "Cancel")
    WebElement CreatePostCancelButton;

    /**
     * This Is Next Button In Create Post Page
     */
    @FindBy(id = "Next")
    WebElement CreatePostNextButton;

    /**
     * This Is The Title Of  Your Post
     */

    //Send "Enter" to end text
    @FindBy(id = "Title")
    WebElement CreatePostTitleText;

    /**
     * This Is Add Image Button
     */


    @FindBy(id = "Add Image")
    WebElement CreatePostAddImageButton;

    /**
     * This Is First Image Added To The Post
     */

    @FindBy(id = "First Image")
    WebElement CreatePostFirstImage;

    /**
     * This Is Cancel Image Button To Delete Specific Image
     */

    @FindBy(id = "Delete This Image")
    WebElement CreatePostDeleteImageButton;

    /**
     * This Is Add Another Image Button
     */

    @FindBy(id = "Add Another Image")
    WebElement CreatePostAddAnotherImageButton;


    /**
     * This IS Add video Button
     */
    @FindBy(id = "Add Video")
    WebElement CreatePostAddVideoButton;

    /**
     * This IS Add Body Text Button
     */
    @FindBy(id = "Add Text")
    WebElement CreatePostAddTextButton;

    /**
     * This IS  Body Text Button
     */
    @FindBy(id = "Add Text")
    WebElement CreatePostTextarea;

    /**
     * This IS Add Link Button
     */
    @FindBy(id = "Add Link")
    WebElement CreatePostAddLinkButton;

    /**
     * This IS Add Poll Button
     */
    @FindBy(id = "Add Poll")
    WebElement CreatePostAddPollButton;

    /**
     * This IS Add Talk Button
     */
    @FindBy(id = "Add Talk")
    WebElement CreatePostAddVoiceButton;


    @FindBy(id = "Search For Cumm")
    WebElement CreatePostSearchCommunity;

    @FindBy(id = "First Community in Search")
    WebElement CreatePostFirstCommunity;

    @FindBy(id = "PostButton")
    WebElement PostButton;


    @FindBy(id="Discard Message")
    WebElement DiscardMessage;

    @FindBy(id="Discard")
    WebElement DiscardButton;

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
