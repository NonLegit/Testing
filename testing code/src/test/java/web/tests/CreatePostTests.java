package web.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetData;
import web.pageObjects.*;
import web.testComponents.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static web.constants.TestConstants.EXCEL_PATH;

public class CreatePostTests extends BaseTest {

    @Test(description = "This Test Tries To Create Some Posts And Check For Them",dataProvider = "TitlesExcelSheet")
    public void createPostTest(String Title ,String CommunityName,String ExpectedResults){
        HomePage home =new HomePage(driver);

        landingPage.dummyLogIn("3abkareem","Aa_123456789_Aa");
        web_CreatePost CrPost=new web_CreatePost(driver);
        web_Profile Prof=new web_Profile(driver);
        web_Community Community=new web_Community(driver);

        home.gotoCreatePost();

        if(ExpectedResults.equalsIgnoreCase("fail")&&!CrPost.CreatePost(Title,"",CommunityName)){
            Assert.assertTrue(true);
        }else if(ExpectedResults.equalsIgnoreCase("success")&& CrPost.CreatePost(Title,"",CommunityName)){
            home.gotoMyProfile();

            if(Prof.checkPostText(Title,"",CommunityName)) {
                if (Community.checkPostText(Title, "", CommunityName)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }else{
                Assert.fail();
            }

        }else{
            Assert.fail();
        }

    }

    @Test(description = "This Test For Testing Body Text In Posts ")
    public void testTextPosts(){
        HomePage home= new HomePage(driver);
        web_CreatePost CrPost=new web_CreatePost(driver);
        web_Profile Prof=new web_Profile(driver);
        CommunityPage comm=new CommunityPage(driver);

        landingPage.dummyLogIn("3abkareem","Aa_123456789_Aa");
        home.gotoCreatePost();

        if(CrPost.CreatePost("Testing", "HELLO FROM TEsTING TEAM", "Tryy1223")){
            home.gotoMyProfile();
            if(Prof.checkPostText("Testing","HELLO FROM TEsTING TEAM","r/Tryy1223 .")){
               // Prof.gotoFirstPostCommunity();
                //Prof.gotoNFSW();
                if(comm.checkPostText("Testing","HELLO FROM TEsTING TEAM","r/Tryy1223")){
                    Assert.assertTrue(true);
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
    public void checkPost(){
        HomePage home=new HomePage(driver);
        landingPage.dummyLogIn("3abkareem","Aa_123456789_Aa");
        web_Profile Prof=new web_Profile(driver);


        home.gotoMyProfile();

        if(Prof.checkPostText("Testing","HELLO FROM TEsTING TEAM","r/Tryy1223 .")){
            Assert.assertTrue(true);
            
        }else{
            Assert.fail();
        }

    }

    @Test(description = "This Test Tests The Spoiler Posts")
    public void spoilTest(){
        HomePage home= new HomePage(driver);
        web_CreatePost CrPost=new web_CreatePost(driver);
        web_Profile Prof=new web_Profile(driver);
        CommunityPage comm=new CommunityPage(driver);
        landingPage.dummyLogIn("3abkareem","Aa_123456789_Aa");
        home.gotoCreatePost();
        CrPost.spoilerPost();
        if(CrPost.CreatePost("SPOIlER", "SPOILER TEST", "Tryy1223")) {
            home.gotoMyProfile();
            if(Prof.checkForSpoiler()){
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }

    }

    @Test(description = "This Test Tests The Spoiler Posts")
    public void NSFWtest(){
        HomePage home= new HomePage(driver);
        web_CreatePost CrPost=new web_CreatePost(driver);
        web_Profile Prof=new web_Profile(driver);
        CommunityPage comm=new CommunityPage(driver);
        landingPage.dummyLogIn("3abkareem","Aa_123456789_Aa");
        home.gotoCreatePost();
        CrPost.NSFWPost();
        if(CrPost.CreatePost("NSFW", "NSFW TESTING", "Tryy1223")) {
            home.gotoMyProfile();
            if(Prof.checkForNSFW()){
                Assert.assertTrue(true);
            }else{
                Assert.fail();
            }
        }else{
            Assert.fail();
        }

    }



    @DataProvider(name = "TitlesExcelSheet")
    public Object[][] getDataForPost() throws IOException {

        GetData getdata=new GetData();
        List<Map<String, String>> list = getData.getExcelData(EXCEL_PATH, "TitlesExcelSheet");
        Object [][] data = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> m = list.get(i);
            data[i][0] = m.get("Titles");
            data[i][1] = m.get("CommunityName");
            data[i][2] = m.get("ExpectedResults");
        }
        return data;
    }
}
