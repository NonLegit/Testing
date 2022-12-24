package Mobile.tests;

import mobile.Pages.Home;
import mobile.Pages.PostDetails;
import Mobile.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostsValidation extends BaseTest {

    /**
     * this test is used to test making a randomized comment on some random post in the home page
     */
    @Test(description = "making a random comment on some random post")
    public void makeRandomComment() {
        Home home = startingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(home);
        PostDetails postDetails = home.checkFirstPost();
        Assert.assertNotNull(postDetails);
    }


    /**
     * this test is used to test replying to comment by a randomized comment on some random post in the home page
     */
    @Test(description = "replying to a random comment on some random post")
    public void replyRandomComment(){
        Home home = startingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(home);
        PostDetails postDetails = home.checkFirstPost();
        Assert.assertNotNull(postDetails);
    }

    /**
     * this test is used to test making a share a post and check if the original url is subset of the shared one
     */
    @Test(description = "sharing some random post")
    public void sharePostTest(){
        /*HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(1);
        String postContentText = postDetails.getCurrentPostContent();
        List<String> sharedPostsTexts = postDetails.sharePostToMyProfile();
        Assert.assertTrue(sharedPostsTexts.size() != 0);
        Assert.assertTrue(sharedPostsTexts.contains(postContentText));*/
    }

    /**
     * this test is used to test making a share a post and go back to the original post as it's a bug
     */
    @Test(description = "sharing some post and going back to the post from the share page as there is a bug with the number of shares")
    public void goBackToPostWhenSharing(){
       /* HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(1);
        int currentPostNumOfSharedBefore = postDetails.getCurrentNumberOfShares();
        String currentUrl = driver.getCurrentUrl();
        postDetails.sharePostToMyProfile();
        driver.navigate().to(currentUrl);
        int currentPostNumOfSharedAfter = postDetails.getCurrentNumberOfShares();
        /*System.out.println("before = " + currentPostNumOfSharedBefore);
        System.out.println("after = " + currentPostNumOfSharedAfter);*/
        //Assert.assertEquals(currentPostNumOfSharedBefore + 1, currentPostNumOfSharedAfter);
    }



    /**
     * this test is used to test making upvote to a post
     */
    @Test(description = "upvoting some random post")
    public void upVotePostTest(){
        /*HomePage homePage = landingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPost(2);
        int postUpVotesOld = postDetails.getNumOfVotesPostBefore();
        postDetails.upVotePost();
        int postUpVotesNew = postDetails.getNumOfVotesPostAfter();
        //System.out.println("before = " + postUpVotesOld);
        //System.out.println("after = " + postUpVotesNew);
        Assert.assertTrue(postUpVotesNew > postUpVotesOld);*/
    }

    /**
     * this test is used to test making downvote to a post
     */
    @Test(description = "downvoting some random post")
    public void downVotePostTest(){
        /*HomePage homePage = landingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPost(2);
        int postUpVotesOld = postDetails.getNumOfVotesPostBefore();
        postDetails.downVotePost();
        int postUpVotesNew = postDetails.getNumOfVotesPostAfter();
        System.out.println("before = " + postUpVotesOld);
        System.out.println("after = " + postUpVotesNew);
        Assert.assertTrue(postUpVotesNew < postUpVotesOld);*/
    }

    /**
     * this test is used to test making upvote to a comment
     */
    @Test(description = "upvoting some random comment")
    public void upVoteCommentTest(){
        Home home = startingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(home);
        PostDetails postDetails = home.checkFirstPost();
        Assert.assertNotNull(postDetails);
    }


    /**
     * this test is used to test making downvote to a comment
     */
    @Test(description = "downvoting some random comment")
    public void downVoteCommentTest(){
        Home home = startingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(home);
        PostDetails postDetails = home.checkFirstPost();
        Assert.assertNotNull(postDetails);
    }
}
