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
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPost(2);
        String comment = getData.generateRandomString(15);
        postDetails.makeComment(comment);
        String resultComment = postDetails.getCommentOfUser(VALID_USER_NAME);
        Assert.assertEquals(resultComment, comment);
    }


    /**
     * this test is used to test replying to comment by a randomized comment on some random post in the home page
     */
    @Test(description = "replying to a random comment on some random post")
    public void replyRandomComment(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(2);
        String comment = getData.generateRandomString(15);
        String userName = postDetails.getUserNameOfIndex(1);
        postDetails.replyToComment(comment, userName);
        String resultComment = postDetails.getCommentOfUser(userName);
        Assert.assertEquals(resultComment, comment);
    }

    /**
     * this test is used to test making a share a post and check if the original url is subset of the shared one
     */
    @Test(description = "sharing some random post")
    public void sharePostTest(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPost(2);
        String sharedURL = postDetails.shareLink();
        Assert.assertNotEquals(sharedURL, null);
        Assert.assertTrue(driver.getCurrentUrl().contains(sharedURL));
    }

    /**
     * this test is used to test making upvote to a post
     */
    @Test(description = "upvoting some random post")
    public void upVotePostTest(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(3);
        int postUpVotesOld = postDetails.getNumOfVotesPost();
        postDetails.upVotePost();
        int postUpVotesNew = postDetails.getNumOfVotesPost();
        Assert.assertEquals(postUpVotesOld + 1, postUpVotesNew);
    }

    /**
     * this test is used to test making downvote to a post
     */
    @Test(description = "downvoting some random post")
    public void downVotePostTest(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(3);
        int postUpVotesOld = postDetails.getNumOfVotesPost();
        postDetails.downVotePost();
        int postUpVotesNew = postDetails.getNumOfVotesPost();
        Assert.assertEquals(postUpVotesOld - 1, postUpVotesNew);
    }

    /**
     * this test is used to test making upvote to a comment
     */
    @Test(description = "upvoting some random comment")
    public void upVoteCommentTest(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(3);
        String username = postDetails.getUserNameOfIndex(1);
        int commentUpVotesOld = postDetails.getNumOfVotesComment(username);
        postDetails.upVoteComment(username);
        int commentUpVotesNew = postDetails.getNumOfVotesComment(username);
        Assert.assertEquals(commentUpVotesOld + 1, commentUpVotesNew);
    }


    /**
     * this test is used to test making downvote to a comment
     */
    @Test(description = "downvoting some random comment")
    public void downVoteCommentTest(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(3);
        String username = postDetails.getUserNameOfIndex(1);
        int commentUpVotesOld = postDetails.getNumOfVotesComment(username);
        postDetails.downVoteComment(username);
        int commentUpVotesNew = postDetails.getNumOfVotesComment(username);
        Assert.assertEquals(commentUpVotesOld - 1, commentUpVotesNew);
    }

    /**
     * this test is used to test posting Text
     */
    @Test(description = "posting some random post")
    public void textPosting(){
        HomePage homePage = landingPage.NormalLogin(VALID_USER_NAME, VALID_USER_PASS);
        Assert.assertNotEquals(homePage, null);
    }

    /**
     * this test is used to test editing a post in profile
     */
    public void editPostText(){

    }

}
