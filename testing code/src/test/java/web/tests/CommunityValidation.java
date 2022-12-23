package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.CommunityPage;
import web.pageObjects.HomePage;
import web.testComponents.BaseTest;

public class CommunityValidation extends BaseTest {

    /**
     * this test is used to go and create your own community
     */
    @Test(description = "this is a test used to create a community")
    public void createCommunity(){
        HomePage page = landingPage.NormalLogin("Immediate_Rhubarb_75","Abdo@1357");
        Assert.assertNotNull(page);
        String communityRandomName = getData.generateRandomString(10);
        CommunityPage communityPage = page.createCommunity(communityRandomName, false, 0);
        System.out.println(communityPage.getCommunityName());
        System.out.println(communityRandomName);
        Assert.assertTrue(communityPage.getCommunityName().contains(communityRandomName));
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
