package mobile.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Pages{
    @FindBy(id = "SearchBar")
    MobileElement SearchBar;

    @FindBy(id="FirstCommunity")
    MobileElement FirstCommunity;

    public boolean searchForCommunity(String CommunityName) {

        SearchBar.sendKeys(CommunityName);
        SearchBar.sendKeys("Enter");

        if(  FirstCommunity.isDisplayed())
        {
            FirstCommunity.click();
            return true;
        }
    return false;
    }



}
