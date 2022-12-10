package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityPage extends Pages {

    @FindBy(id = "Community Name")
    WebElement CommunityName;

    @FindBy(id="Home Button")
    WebElement CommunityHomeButton;

    @FindBy(id="Community Type")
    WebElement CommunityType;

    @FindBy(id="Community NSFW")
    WebElement CommunityNSFW;

    @FindBy(id="Join")
    WebElement JoinButton;

    public void returnHome() throws Exception{
        CommunityHomeButton.click();
    }
    public String getCommunityName(){
        ///////////////Labelllllllll
        return CommunityName.getText() ;
    }
    public boolean checkForCommunityParameters(String CommName,String CommType,String CommNSFW){
        try{
            if(CommName==CommunityName.getText()&&CommNSFW==CommunityNSFW.getText()&&CommType==CommunityType.getText()){
                return true;
            }else{
                return false;
            }
        }catch(Exception ignore){
            return true;
        }
    }
    public boolean checkForName(String Name){
        try{
            if(Name==CommunityName.getText()){
                return true;
            }else{
                return false;
            }
        }catch(Exception ignore){
            return true;
        }
    }
    public  boolean joinCommunity(){
        try {
            JoinButton.click();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean isJoinEnable(){
        try {
            if(JoinButton.isEnabled()==true){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
