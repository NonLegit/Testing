package Mobile.tests;

import Mobile.testComponents.BaseTest;
import mobile.Pages.EditScreenPage;
import mobile.Pages.Home;
import mobile.Pages.MyProfilePage;
import mobile.Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherUsers extends BaseTest {
    @Test(description = "Follow Other user")
    public void followTest(){
        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);
        EditScreenPage Edit=new EditScreenPage(driver);
        SearchPage Search=new SearchPage(driver);

        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.openSearch();
        Search.searchForUser("messi");
        Home .dummylogin("messi","Aa_123456789_Aa");
        Home.gotoMyProfile();
        if(Prof.gotoFollowers()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

}
