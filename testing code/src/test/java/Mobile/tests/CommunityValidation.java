package Mobile.tests;

import mobile.Pages.CreateCommunity;
import mobile.Pages.Home;
import Mobile.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommunityValidation extends BaseTest {

    /**
     * this test is used to go and create your own community
     */
    @Test(description = "this is a test used to create a community")
    public void createCommunity(){
        Home home = startingPage.NormalLogin("Immediate_Rhubarb_75", "Abdo@1357");
        Assert.assertNotNull(home);
        String communityRandomName = getData.generateRandomString(10);
        CreateCommunity communityPage = home.gotoCreateCommunity();
        boolean test = communityPage.createComm(communityRandomName, "public", "none");
        Assert.assertTrue(test);
    }

    /**
     * this test is used to go and create your own post in some community
     */
    @Test(description = "this is a test used to make a post in the community")
    public void createPostInCommunity(){

    }

    /**
     * this test is used to join a community
     */
    @Test(description = "this is a test used to join some random community")
    public void joinCommunity(){

    }

    /**
     * this test is used to go and report some random community
     */
    @Test(description = "this is a test used to report random some random community")
    public void reportCommunity(){

    }



}
