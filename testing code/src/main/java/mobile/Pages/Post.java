package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class Post extends Pages{
    @FindBy(id="Post Title")
    MobileElement PostTitle;

    @FindBy(id="Community Name")
    MobileElement CommunityName;

    @FindBy(id="Post Body")
    MobileElement PostBodyName;

    public String seePost(String Title,String Text,String Community){
        try {
            if (Title == PostTitle.getText() && CommunityName.getText() == Community && Text == PostBodyName.getText())
                return "success";
            else
                return "fail";
        }catch(Exception ex){
            return "fail";

        }
    }
}
