package web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.HomePage;
import web.pageObjects.web_OtherUserProFile;
import web.testComponents.BaseTest;

public class OtherUserProfileTest extends BaseTest {

    @Test(description = "This Test Test If I Can Follow SomeOne")
    public void followTest() {

        web_OtherUserProFile OUser = new web_OtherUserProFile(driver);
        HomePage Home = landingPage.NormalLogin("Immediate_Rhubarb_77", "Abdo@1357");

        String Name =Home.gotoFirstPostOwner();
        if (OUser.checkName(Name)) {
            if (OUser.toggleFollowButton()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }
}


