package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class CommunityPage extends Pages {

    @FindBy(id = "Community Name")
    MobileElement CommunityName;

    @FindBy(id="Home Button")
    MobileElement CommunityHomeButton;

    @FindBy(id="Community Type")
    MobileElement CommunityType;

    @FindBy(id="Community NSFW")
    MobileElement CommunityNSFW;

    @FindBy(id="Join")
    MobileElement JoinButton;

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
