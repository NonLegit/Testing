package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import web.pageObjects.PostDetails;
import web.testComponents.BaseTest;

import static web.constants.TestConstants.VALID_USER_NAME;
import static web.constants.TestConstants.VALID_USER_PASS;

public class PostsValidation extends BaseTest {

    /**
     * this test is used to test making a randomized comment on some random post in the home page
     */
    @Test(description = "making a random comment on some random post")
    public void makeRandomComment(){
        HomePage homePage = landingPage.login(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPost(2);
        String comment = getData.generateRandomString(15);
        postDetails.makeComment(comment);
        String resultComment = postDetails.getCommentOfUser(VALID_USER_NAME);
        Assert.assertEquals(resultComment, comment);
    }

    /**
     * this test is used to test making a share a post and check if the original url is subset of the shared one
     */
    @Test(description = "sharing some random post")
    public void sharePostTest(){
        HomePage homePage = landingPage.login(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPost(2);
        String sharedURL = postDetails.shareLink();
        Assert.assertNotEquals(sharedURL, null);
        Assert.assertTrue(driver.getCurrentUrl().contains(sharedURL));
    }




    //////////////////////////TODO
    /**
     * this test is used to test making upvote to a post
     */
    @Test(description = "upvoting some random post")
    public void upVotePostTest(){
        HomePage homePage = landingPage.login(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(3);

    }

}
