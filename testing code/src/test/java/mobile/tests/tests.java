package mobile.tests;

import mobile.Pages.*;
import mobile.testComponents.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tests extends BaseTest {

    CreatePost CreatePost;
    MyProfilePage MyProfilePage;
    Home Home;
    Post Post;
    SearchPage Search;
    CommunityPage CmPage;
    CreateCommunity CrCM;
    OtherUsersPage User;


    /**
     * this is a test method to test the Post with username and password
     *
     * @param Title:         this is the title of the post
     * @param Text:          this is the Text you want to add to the post
     * @param Community:this is the Community you want to post in
     */
    @Test(description = "Create some Posts Post", dataProvider = "writePostExcelDataProvider")
    public void createPostTest(String Title, String Text, String Community, String expectedResult) {

        //make sure you are in home
        Home.clickCreatePost();
        if (expectedResult.equalsIgnoreCase("fail") && CreatePost.writePost(Title, Text, Community) == "fail") {
            Assert.assertTrue(true);
        } else if (expectedResult.equalsIgnoreCase("success") && CreatePost.writePost(Title, Text, Community) == "success") {
            if (Home.gotoMyProfile() == "success" && MyProfilePage.clickPost() == "success" && Post.seePost(Title, Text, Community) == "success") {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }

    /**
     * this is a test method to Search For An Existing Community And See If It Takes Me To The Right Community And Another Search For Non Existing Comm
     *
     * @param Community:this is the Community you want to post in
     */
    @Test(description = "Search For Communities in Search and in Recently Visited", dataProvider = "visitCommunityExcelDataProvider")
    public void visitCommunityTest(String Community, String expectedResult) {
        try {
            //make sure you are in home
            Home.openSearch();
            if(expectedResult.equalsIgnoreCase("fail")&&(!Search.searchForCommunity(Community)))
            {
                Assert.assertTrue(true);
            }else if (expectedResult.equalsIgnoreCase("success")&&(Search.searchForCommunity(Community))){
                if(CmPage.getCommunityName()!=Community){
                    Assert.fail();
                }else{
                    CmPage.returnHome();
                    if(Home.getFirstRecentlyVisited()==Community)
                    {
                        Assert.assertTrue(true);
                    }else{
                        Assert.fail();
                    }
                }
            }else {
                Assert.fail();
            }
        } catch (Exception i) {
            Assert.fail();
        }
    }
    /**
     * this is a test method to see if the communities in recently visited are right
     */
    @Test(description = "Search For Communities in Search and in Recently Visited")
    public void visitFromRecentlyVisited() {
        String CommName=Home.getFirstRecentlyVisited();
        if(Home.clickFirstRecentlyVisited()){
            if(CmPage.getCommunityName()==CommName){
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }
    }

    @Test(description = "Create sub-reddit",dataProvider = "createSubRedditExcel")
    public void createCommTest(String CommName, String Type, String NSFW, String expectedResult) {
        //in home
        if(Home.gotoCreateCommunity()) {
            if(expectedResult.equalsIgnoreCase("fail")&& !CrCM.createComm(CommName,Type,NSFW) ){
                Assert.assertTrue(true);

            }else if(expectedResult.equalsIgnoreCase("success")&&CrCM.createComm(CommName,Type,NSFW)&&Home.gotoYourCommunities()&& CmPage.checkForCommunityParameters(CommName,Type,NSFW) ) {
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }
    }

    @Test(description = "Following")
    public void followTest() {
        String UserName="Dummy User";
        Home.openSearch();
        Search.searchForCommunity(UserName);
        String Name=User.getUserName();
        if(User.followThenReturn()) {
            //in home
            if(Home.gotoFollowing(UserName)&&User.checkForUserName(UserName)) {
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }

        }else{
            Assert.fail();
        }
        //in home

    }

    @Test(description = "Test Favourite List")
    public void addToFavourite(){
        String CommName=Home.addFavourite();
        if(Home.gotoFavourite(CommName)&&CmPage.checkForName(CommName)) {
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test(description = "Join Community Test")
    public void joinCommunity(){
        String Name="Dummy Community";
        Home.openSearch();
       if(Search.searchForCommunity(Name)&& CmPage.joinCommunity()){
           if(Home.gotoYourCommunities()&& CmPage.checkForName(Name)&& !CmPage.isJoinEnable()){
               Assert.assertTrue(true);
           }else{
               Assert.fail();
           }
       }else{
           Assert.fail();
       }
    }

    @Test(description = "DiscardPost")
    public void DiscardPost(){
        Home.clickCreatePost();
        if(CreatePost.cancelPost("Dummy Title","Dummy Text Body")){
            if(CreatePost.isDiscardMessage()){
                CreatePost.discard();
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }
    }

    @Test(description = "dummy test")
    public void EnterUserNameAndPass() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("test");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.EditText[2]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("test");
        driver.hideKeyboard();
        Thread.sleep(11000);
    }
}



