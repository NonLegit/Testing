package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class OtherUsersPage {

    @FindBy(id = "User Name")
    MobileElement UserName;

    @FindBy(id = "Follow")
    MobileElement OtherUsersFollowButton;

    @FindBy(id = "Home")
    MobileElement Home;

    public String getUserName() {
        return UserName.getText();
    }

    public boolean followThenReturn() {
        try {
            OtherUsersFollowButton.click();
            Home.click();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkForUserName(String Name) {
        try {
            if (Name==UserName.getText()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}


