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
        HomePage Home = landingPage.NormalLogin("bola", "Aa_12345678_Aa");

        driver.navigate().to("https://web.nonlegit.click/user/3abkareem");
        if (OUser.toggleFollowButton()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        /*String Name = Home.gotoFirstPostOwner();
        if (OUser.checkName(Name)) {
            driver.navigate().to("https://web.nonlegit.click/user/messi");
            if (OUser.toggleFollowButton()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        } else {
            Assert.fail();
        }*/
    }
}


