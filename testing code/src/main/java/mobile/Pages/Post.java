package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Post extends Pages{
    @FindBy(id="Post Title")
    WebElement PostTitle;

    @FindBy(id="Community Name")
    WebElement CommunityName;

    @FindBy(id="Post Body")
    WebElement PostBodyName;

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
