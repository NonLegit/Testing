package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import web.pageObjects.web_Profile;
import web.pageObjects.web_Settings;
import web.testComponents.BaseTest;

public class SettingsTests extends BaseTest {



    @Test
    public void gotoSettings(){
        web_Profile Prof=new web_Profile(driver);
        HomePage home=new HomePage(driver);
        web_Settings Settings= new web_Settings(driver);

        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");
        home.gotoSettings();
        if(Settings.checkForSettingsPage()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

}
