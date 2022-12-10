package mobile.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Pages{
    @FindBy(id = "SearchBar")
    WebElement SearchBar;

    @FindBy(id="FirstCommunity")
    WebElement FirstCommunity;

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
