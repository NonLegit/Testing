package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import web.pageObjects.web_OtherUserProFile;
import web.pageObjects.web_Profile;
import web.pageObjects.web_Settings;
import web.testComponents.BaseTest;

public class ProfileTests extends BaseTest {



    @Test
    public void ownMyProfile() {

        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);


        home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");
        home.gotoMyProfile();
        if (Prof.checkName("u/Immediate_Rhubarb_77")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void getFollowedTest() {

        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);

        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_75", "Abdo@1357");
        Home.gotoMyProfile();
        String NoFollowers = Prof.getFollowers();
        //log out and login with different account
        Home = landingPage.NormalLogin("Immediate_Rhubarb_75", "Abdo@1357");
        String FollowingName = Home.gotoFirstPostOwner();
        if (Prof.checkName(FollowingName)) {
            if(O_Prof.toggleFollowButton()) {
                //Home.logout;
                //should be the use u just followed
                Home = landingPage.NormalLogin("Immediate_Rhubarb_75", "Abdo@1357");
                Home.gotoMyProfile();
                if (Prof.checkFollowers(FollowingName)) {
                    /*if(Prof.getFollowers()==NoFollowers+1){
                        Assert.assertTrue(true);
                     */
                }else{
                    Assert.fail();
                }
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }
    }

    @Test
    public void testOverView(){

        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);


        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");
        Home.gotoMyProfile();
        if( Prof.checkOverViewButton()) {
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

    @Test
    public void switchToPosts(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);


        home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");
        home.gotoMyProfile();
       if( Prof.checkPostsButton()) {
           Assert.assertTrue(true);
       }else{
           Assert.fail();
       }
    }

    @Test
    public void switchToComments(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        //signup
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoMyProfile();
       if(Prof.checkCommentsButton()){
           Assert.assertTrue(true);
       }else{
           Assert.fail();
       }
    }

    @Test
    public void switchToHistory(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        //signup
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");
        home.gotoMyProfile();
        if(Prof.checkHistoryButton()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void switchToSaved(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        //signup
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoMyProfile();
        if(Prof.checkSavedButton()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void switchToHidden(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        //signup
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoMyProfile();
        if(Prof.checkHiddenButton()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void switchToUpVoted(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        //signup
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoMyProfile();
        if(Prof.checkUpVotedButton()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void switchToDownVoted(){
        web_Profile Prof=new web_Profile(driver);
        web_OtherUserProFile O_Prof=new web_OtherUserProFile(driver);
        HomePage home=new HomePage(driver);
        home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoMyProfile();
        if(Prof.checkDownVotedButton()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }


    @Test(description = "This Test Tests The Setting Button Appears In Profile")
    public void gotoSettingTest(){
        web_Profile Prof=new web_Profile(driver);
        HomePage home=new HomePage(driver);
        web_Settings Settings=new web_Settings(driver);
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        Prof.gotoSettings();
        if(Settings.checkForSettingsPage()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test(description = "This Test Tests The Functionality Of Social Link")
    public void checkAddSocialLink(){

    }

    @Test(description = "This Tests The NFSW Setting")
    public void makyMyProfileNSFWTest(){

        web_Profile Prof=new web_Profile(driver);
        HomePage home=new HomePage(driver);
        web_Settings Settings=new web_Settings(driver);
        home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        home.gotoSettings();


    }
}
