package Mobile.tests;

import Mobile.testComponents.BaseTest;
import mobile.Pages.EditScreenPage;
import mobile.Pages.Home;
import mobile.Pages.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditTests extends BaseTest {
    @Test(description = "This test to test Display name and description")
    public void editDisplayAndDescription(){
        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);
        EditScreenPage Edit=new EditScreenPage(driver);

        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.gotoMyProfile();

        Prof.gotoEdit();
        if(Edit.checkForEditScreen()){
            Edit.changeNameDesc("bof","HELLO FAT");
            Assert.assertTrue(true);

        }else {
            Assert.fail();
        }
    }

}
