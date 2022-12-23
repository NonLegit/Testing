package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import web.pageObjects.web_Profile;
import web.pageObjects.web_Settings;
import web.testComponents.BaseTest;

public class SettingsTests extends BaseTest {


    @Test
    public void gotoSettings() {
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);

        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        if (Settings.checkForSettingsPage()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @Test(description = "this test used to test changing gender from male to female")
    public void changeGender() {
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);

        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        if (Settings.setGender()) {
            Assert.assertTrue(true);
        }
        Assert.fail();

    }

    @Test(description = "this test used to test changing Password ")
    public void changePassword() {
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);


        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        Settings.changePassword("Aa_12345678_Aa", "Aa_123456789_Aa");
        home.reLogin("bola", "Aa_12345678_Aa");
        home.gotoMyProfile();
        Prof.checkName("u/bola");


    }

    @Test(description = "this test used to test changing country ")
    public void changeCountry() {
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);


        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        if (Settings.changeCountry()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @Test(description = "this test used to test display name and add description")
    public void changeDisplayNameAndAbout() {
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);


        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        Settings.displayedName("bolfat", "Hi There iam testing");
        home.gotoMyProfile();
        if (Prof.checkNameAbout("bolfat", "Hi There iam testing")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test(description = "this test used to test Make my Profile NSFW")
    public void makeProfileNSFW(){
        web_Profile Prof = new web_Profile(driver);
        HomePage home = new HomePage(driver);
        web_Settings Settings = new web_Settings(driver);


        landingPage.dummyLogIn("bola", "Aa_12345678_Aa");
        home.gotoSettings();
        Settings.makeNFSW();
        Settings.returnHome();
        home.reLogin("bolt","Aa_123456789_Aa");


    }


}


