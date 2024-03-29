package mobile.Pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Pages{

    @FindBy(xpath= "//android.widget.EditText")
    WebElement SearchBar;

    @FindBy(id="FirstCommunity")
    WebElement FirstCommunity;

    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void searchForUser(String CommunityName) {
        threadSleep(3);
        SearchBar.click();
        SearchBar.sendKeys(CommunityName);
        SearchBar.sendKeys("Enter");
        threadSleep(2);
        driver.findElement(By.xpath("(//android.view.View)[9]")).click();
        threadSleep(2);
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        threadSleep(2);
        driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
        threadSleep(2);
        //driver.findElement(By.xpath("(//android.widget.Button)[7]")).click();
        threadSleep(2);
        driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
        threadSleep(2);
       // driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
        threadSleep(2);
        driver.findElement(By.xpath("(//android.widget.Button)[4]")).click();
        threadSleep(2);
        driver.findElement(By.xpath("//android.view.View[@content-desc='Log out']")).click();
    }

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
