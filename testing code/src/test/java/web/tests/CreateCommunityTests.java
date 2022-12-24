package web.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetData;
import web.pageObjects.HomePage;
import web.pageObjects.web_CreateCommunity;
import web.testComponents.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static web.constants.TestConstants.EXCEL_PATH;

public class CreateCommunityTests extends BaseTest {

    @Test(description = "This test Used to create Public sub-reddit",dataProvider = "CreateCommunity")
    public void createPublicCommunityTest(String CommunityName,String ExpectedResults) {
        HomePage home = new HomePage(driver);
        web_CreateCommunity Cr_Comm = new web_CreateCommunity(driver);
        //CommunityValidation Comm=new CommunityValidation(driver);

        landingPage.dummyLogIn("3abkareem", "Aa_123456789_Aa");
        home.gotoCreateCommunity();
        if (ExpectedResults.equalsIgnoreCase("fail")&&!Cr_Comm.setCommunityName(CommunityName)) {
            Assert.assertTrue(true);
        } else if(Cr_Comm.setCommunityName(CommunityName)&&ExpectedResults.equalsIgnoreCase("success")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @DataProvider(name = "CreateCommunity")
    public Object[][] getDataForPost() throws IOException {

        GetData getdata=new GetData();
        List<Map<String, String>> list = getData.getExcelData(EXCEL_PATH, "CreateCommunity");
        Object [][] data = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> m = list.get(i);
            data[i][0] = m.get("Community Name");
            data[i][1] = m.get("ExpectedResults");
        }
        return data;
    }
}
