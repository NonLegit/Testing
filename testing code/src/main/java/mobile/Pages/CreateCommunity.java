package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCommunity extends Pages{

    /**
     *
     */
    @FindBy(xpath="//android.view.View[@content-desc='Create a community'")
    WebElement CreateCommunityPageName;


    /**
     *
     */
    @FindBy(xpath="(//android.widget.EditText)[1]")
    WebElement CreateCommunityNameTextBox;


    /**
     *
     */
    @FindBy(xpath="(//android.view.View)[11]")
    WebElement CreateCommunityNSFWButton;


    /**
     *
     */
    @FindBy(xpath="//android.view.View[@content-desc='Community type'")
    WebElement CreateCommunityTypeWindow;


    /**
     *
     */
    @FindBy(xpath="//android.view.View[@content-desc='Public Anyone can view,post,and comment to this community']")
    WebElement CreateCommunityTypePublic;


    /**
     *
     */
    @FindBy(xpath="//android.view.View[@content-desc='Restricted Anyone can view this community,but only approved users can post']")
    WebElement CreateCommunityTypeRestricted;

    /**
     *
     */
    @FindBy(xpath="//android.view.View[@content-desc='Private Only approved users can view and submit to this community']")
    WebElement CreateCommunityTypePrivate;

    @FindBy(id = "Create")
    WebElement CreateCommunityButton;
    public boolean  createComm(String Comm,String Type,String NSFW) {
        try {
            CreateCommunityNameTextBox.sendKeys(Comm);
            CreateCommunityTypeWindow.click();
            if(Type=="private") {
                CreateCommunityTypePrivate.click();
            }else if(Type=="public"){
                CreateCommunityTypePublic.click();
            }else {
                CreateCommunityTypeRestricted.click();
            }
            if(NSFW=="+18"){
                CreateCommunityNSFWButton.click();
            }else{

            }
            if(CreateCommunityButton.isDisplayed()){
                CreateCommunityButton.click();
            }
            else{
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean makeItPrivate(){
        try{
            CreateCommunityTypeWindow.click();
            CreateCommunityTypePrivate.click();
        }catch(Exception i){
             return false;
        }
        return true;
    }
}
