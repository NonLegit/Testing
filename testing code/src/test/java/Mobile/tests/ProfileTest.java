package Mobile.tests;

import Mobile.testComponents.BaseTest;
import mobile.Pages.EditScreenPage;
import mobile.Pages.Home;
import mobile.Pages.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test(description = "This is 3 cases Test which Tests switching between Posts  comments and about tabs In a New Profile")
    public void switchToPosts(){

        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);


        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.gotoMyProfile();
        if(Prof.chooseWebElement("Comments")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test(description = "This Test Tests That This Account Belongs To The Logger ")
    public void checkLogger(){

        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);

        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.gotoMyProfile();
        if(Prof.checkName("Immediate_Rhubarb_75")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test(description = "Test Back In My Profile page Button")
    public void testBackButton(){

        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);

        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.gotoMyProfile();

        Prof.backToHome();
        Home.checkForHome();
    }

    @Test(description = "THis Test Tests Going To Edit Page")
    public void testGoToEdit(){

        Home Home=new Home(driver);
        MyProfilePage Prof=new MyProfilePage(driver);
        EditScreenPage Edit=new EditScreenPage(driver);

        Home.dummylogin("bola","Aa_12345678_Aa");
        Home.gotoMyProfile();

        Prof.gotoEdit();
        if(Edit.checkForEditScreen()){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
    }


}
