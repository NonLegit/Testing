package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtherUsersPage {

    @FindBy(id = "User Name")
    WebElement UserName;

    @FindBy(id = "Follow")
    WebElement OtherUsersFollowButton;

    @FindBy(id = "Home")
    WebElement Home;

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


