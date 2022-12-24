package Mobile.tests;

import Mobile.testComponents.BaseTest;
import mobile.Pages.Home;
import mobile.Pages.MyProfilePage;
import mobile.Pages.SettingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Settings extends BaseTest {
    @Test
    public void settingsTest(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");

        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();

    }

    @Test(description = "This test Tests Change Password in profile Settings")
    public void changePass(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");
        MyProfilePage Prof=new MyProfilePage(driver);
        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();
        setting.changePassword("Aa_12345678_Aa","Aa_123456789_Aa");
        Home.gotoMyProfile();
        if(Prof.checkName("u/bola"))
        {
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
    }

    @Test
    public void changeCountry(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");
        MyProfilePage Prof=new MyProfilePage(driver);
        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();
        setting.changeCounty();
    }

    @Test(description = "test change gender")
    public void changeGender(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");
        MyProfilePage Prof=new MyProfilePage(driver);
        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();
        setting.changeGender();
    }

    @Test(description = "test unblock ")
    public void unblockTest(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");
        MyProfilePage Prof=new MyProfilePage(driver);
        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();
        setting.unblock();
    }

    @Test(description = "test ")
    public void allowFollow(){
        Home Home=new Home(driver);
        Home.dummylogin("bola","Aa_12345678_Aa");
        MyProfilePage Prof=new MyProfilePage(driver);
        SettingPage setting = new SettingPage(driver);

        setting.gotoSettings();
        setting.allowFollow();
    }
}
