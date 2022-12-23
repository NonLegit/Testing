package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.AbstractComponents.AbstractComponent;

public class web_Settings extends AbstractComponent {

    @FindBy(xpath = "/html/body/div[1]/section/section/h3")
    WebElement UserSettingsPage;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[1]/a/div/div[1]")
    WebElement HomeIconButton;


    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public web_Settings(WebDriver driver) {
        super(driver);
    }

    public boolean checkForSettingsPage() {
        waitForWebElementToAppear(UserSettingsPage, 1);

        if (UserSettingsPage.getText().equals("User settings")) {
            return true;
        }else {
            return false;
        }
    }

    public boolean setGender(){
        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/button")).getText());
        if(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/button")).getText().equals("Male")){
          threadSleep(5);
          driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/button")).click();
          driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/ul/div[2]/div/span")).click();
          threadSleep(5);
          System.out.println(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/button")).getText());

          if(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[3]/div[2]/div/button")).getText().equals("Female")){
              return true;
          }

        }
        return false;
    }

    /**
     * This function changes the password through settings
     * @param OldPass old pass to be change
     * @param NewPass the new password
     */
    public void changePassword(String OldPass,String NewPass){
        threadSleep(1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div[2]/div[2]/div")).click();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/form/div[1]/div/input")).sendKeys(OldPass);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/form/div[2]/div/input")).sendKeys(NewPass);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/form/div[3]/div/input")).sendKeys(NewPass);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/form/button")).click();
    }

    public boolean changeCountry(){
       threadSleep(1);
       if(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[4]/div[2]/div/button")).getText().equals("Egypt")){
           threadSleep(1);
           driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[4]/div[2]/div/button")).click();
           threadSleep(1);
           driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[4]/div[2]/div/ul/div[1]/div/div")).click();
           if(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[4]/div[2]/div/button")).getText().equals("Afghanistan")){
               return true;
           }
           return false;
       }
        return false;
    }

    /**
     * This Function used to test displayed name and about in the porfile
     * @param NewName The new name to be displayed in profile
     * @param About the describtion
     */
    public void displayedName(String NewName,String About){
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/section/nav/div/a[2]")).click();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/input")).clear();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/input")).sendKeys(NewName);
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/textarea")).clear();
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/textarea")).sendKeys(About);
    }

    public void makeNFSW(){
        threadSleep(1);
        driver.findElement(By.xpath("/html/body/div[1]/section/section/nav/div/a[2]")).click();
        scroll(1000);

       // waitForWebElementToAppear(driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[5]/div[2]/span/span[1]/input")),5);
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[5]/div[2]/span/span[1]/input")).click();
    }

    public void returnHome(){
       // waitForWebElementToAppear(HomeIconButton,5);
        threadSleep(1);
        HomeIconButton.click();
    }


}
