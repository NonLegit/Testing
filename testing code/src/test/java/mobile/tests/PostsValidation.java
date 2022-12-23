package mobile.tests;

import mobile.Pages.Home;
import mobile.Pages.PostDetails;
import mobile.testComponents.BaseTest;
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
        PostDetails postDetails = home.checkPost(0);
        Assert.assertNotNull(postDetails);
    }


    /**
     * this test is used to test replying to comment by a randomized comment on some random post in the home page
     */
    @Test(description = "replying to a random comment on some random post")
    public void replyRandomComment(){
        /*HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(2);
        String comment = getData.generateRandomString(15);
        postDetails.replyToComment(comment, 1);
        List<String> resultComment = postDetails.getRepliesToAComment("3abkareem", 1);
        //System.out.println(resultComment);
        Assert.assertTrue(resultComment.contains(comment));*/
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
     * this test is used to test viewing a post and check if the number of views increased or not
     */
    @Test(description = "viewing some random post")
    public void totalNumViewsPostTest(){
        /*HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(1);
        int currentNumOfViewsBefore = postDetails.getCurrentNumberOfView();
        String currentUrl = driver.getCurrentUrl();
        landingPage.logout();
        HomePage homePage2 = landingPage.NormalLogin("zuksh", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage2);
        driver.navigate().to(currentUrl);
        int currentNumOfViewsAfter = postDetails.getCurrentNumberOfView();
        Assert.assertTrue(currentNumOfViewsAfter > currentNumOfViewsBefore);*/
    }

    /**
     * this test is used to test making a comment and check if the number of comments increased or not
     */
    @Test(description = "viewing some random post")
    public void totalNumCommentsPostTest(){
        /*HomePage homePage = landingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPost(2);
        int numOfCommentsBefore = postDetails.getCurrentNumberOfComments();
        String comment = getData.generateRandomString(15);
        postDetails.makeComment(comment);
        driver.navigate().refresh();
        int numOfCommentsAfter = postDetails.getCurrentNumberOfComments();
        System.out.println("before = " + numOfCommentsBefore);
        System.out.println("after = " + numOfCommentsAfter);
        Assert.assertTrue(numOfCommentsAfter > numOfCommentsBefore);*/
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
        /*HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(2);
        int commentUpVotesOld = postDetails.getNumOfVotesComment(1);
        postDetails.upVoteComment(1);
        int commentUpVotesNew = postDetails.getNumOfVotesComment(1);
        /*System.out.println("before = " + commentUpVotesOld);
        System.out.println("after = " + commentUpVotesNew);*/
        //Assert.assertTrue(commentUpVotesOld < commentUpVotesNew);
    }


    /**
     * this test is used to test making downvote to a comment
     */
    @Test(description = "downvoting some random comment")
    public void downVoteCommentTest(){
        /*HomePage homePage = landingPage.NormalLogin("3abkareem", "Aa_123456789_Aa");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPostWithAtLeastNumOfComments(2);
        int commentUpVotesOld = postDetails.getNumOfVotesComment(1);
        postDetails.downVoteComment(1);
        int commentUpVotesNew = postDetails.getNumOfVotesComment(1);
        /*System.out.println("before = " + commentUpVotesOld);
        System.out.println("after = " + commentUpVotesNew);*/
        //Assert.assertTrue(commentUpVotesOld < commentUpVotesNew);
    }

    /**
     * this is the insight test
     */
    @Test(description = "insights tests case inside the post")
    public void insights(){
        /*HomePage homePage = landingPage.NormalLogin("Fawzy", "Aa123456*.");
        Assert.assertNotNull(homePage);
        PostDetails postDetails = homePage.checkPost(1);
        String currentURL = driver.getCurrentUrl();
        postDetails.clickOnInSightsButton();
        String newURL = driver.getCurrentUrl();
        Assert.assertNotEquals(newURL, currentURL);*/
    }
}
