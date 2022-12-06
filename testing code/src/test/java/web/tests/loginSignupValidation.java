package web.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetData;
import web.pageObjects.HomePage;
import web.testComponents.BaseTest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static web.constants.TestConstants.*;

public class loginSignupValidation extends BaseTest{

    /**
     * this is a test method to test the normal login with username and password
     * @param username: this is the username through which he can sign into hos account
     * @param password: this is the user password through which he can login into his account
     */
    @Test(description = "normal login in with some username and password", dataProvider = "loginExcelDataProvider")
    public void NormalLoginTest(String username, String password, String expectedResult){
        HomePage homePage = landingPage.NormalLogin(username, password);
        if(expectedResult.equalsIgnoreCase("success"))
            Assert.assertNotNull(homePage);
        else if(expectedResult.equalsIgnoreCase("fail"))
            Assert.assertNull(homePage);
        else
            Assert.fail();
    }

    /**
     * login in with google
     */
    @Test(description = "login in using google account", dataProvider = "loginSignUpGoogleExcelDataProvider")
    public void loginUpWithGoogle(String email, String password) throws InterruptedException {
        HomePage homePage = landingPage.googleLogin(email, password);
        Assert.assertNotNull(homePage);
    }

    /**
     * login in with facebook
     */
    @Test(description = "login in using facebook account", dataProvider = "loginSignUpGoogleExcelDataProvider")
    public void loginUpWithFacebook(String email, String password) throws InterruptedException{
        HomePage homePage = landingPage.facebookLogin(email, password);
        Assert.assertNotNull(homePage);
    }

    /**
     * to test forget username
     */
    @Test(description = "testing forget username", dataProvider = "forgetUserNamePassword")
    public void forgetUserName(String email, String password, String username) throws InterruptedException, MessagingException, IOException {
        landingPage.forgetUserName(email);
        Assert.assertTrue(getData.checkEmails("pop.gmail.com", "pop3", email, password, username));
    }

    /**
     * forget username test
     */
    @Test(description = "forget user password", dataProvider = "forgetUserNamePassword")
    public void forgetUserPassword(String email, String password, String username) throws InterruptedException{
        landingPage.forgetUserPassword(email, username);
        Assert.assertTrue(getData.checkEmails("pop.gmail.com", "pop3", email, password, "reset password"));

    }


    /**
     * this is the provider for forgetting username/password
     * @return Object[][]: array of test inputs to be tested
     * @throws IOException: throws an exception if the excel file through which we get our data isn't present
     */
    @DataProvider(name = "forgetUserNamePassword")
    public Object[][] forgetUserPassNameDataProvider() throws IOException {
        GetData getData = new GetData();
        List<Map<String, String>> list = getData.getExcelData(EXCEL_PATH, "googleForgetUserNamePassword");
        Object [][] data = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> m = list.get(i);
            data[i][0] = m.get("email");
            data[i][1] = m.get("password");
            data[i][2] = m.get("username");
        }

        return data;
    }


    /**
     * this is the provider for login and sign up using google/facebook
     * @return Object[][]: array of test inputs to be tested
     * @throws IOException: throws an exception if the excel file through which we get our data isn't present
     */
    @DataProvider(name = "loginSignUpGoogleExcelDataProvider")
    public Object[][] emailDataProvider() throws IOException {
        GetData getData = new GetData();
        List<Map<String, String>> list = getData.getExcelData(EXCEL_PATH, "googleLogin");
        Object [][] data = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> m = list.get(i);
            data[i][0] = m.get("email");
            data[i][1] = m.get("password");
        }

        return data;
    }

    /**
     * tis function is used to test the signup functionality
     */
    @Test(description = "sign up with some random generate username and password")
    public void signupTest(){
        /*this should be */
        String randomEmail = getData.generateRandomString(10) + "@gmail.com";
        String randomUsername = getData.generateRandomString(15);
        String randomPassword = getData.generateRandomString(10);
        List<String>data = new ArrayList<>();
        data.add(randomUsername);
        data.add(randomEmail);
        data.add(randomUsername);
        System.out.println(data);

       // getData.insertRecordIntoExcelSheet(data, EXCEL_PATH, LOGIN_TEST_DATA);
        landingPage.signup(randomUsername, randomEmail, randomPassword);
        System.out.println(landingPage.getSignUpErrorMessage());
    }

    /**
     * this is the provider for our test function that provides it with any needed data to test it
     * @return Object[][]: array of test inputs to be tested
     * @throws IOException: throws an exception if the excel file through which we get our data isn't present
     */
    @DataProvider(name = "loginExcelDataProvider")
    public Object[][] dataProvider() throws IOException {
        GetData getData = new GetData();
        List<Map<String, String>> list = getData.getExcelData(EXCEL_PATH, LOGIN_TEST_DATA);
        Object [][] data = new Object[list.size()][list.get(0).size()];

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> m = list.get(i);
            data[i][0] = m.get(USERNAME_TAG_EXCEL);
            data[i][1] = m.get(PASSWORD_TAG_EXCEL);
            data[i][2] = m.get(EXPECTED_RES_TAG_EXCEL);
        }

        return data;
    }




    /**
     * signing up with google
     */
    @Test
    public void signUpWithGoogle(){

    }

    /**
     * signing up with facebook
     */
    @Test
    public void signUpWithFacebook(){

    }






    /**
     * for forgetting username
     */
    @Test
    public void forgetUserNameTest(){

    }


    /**
     * for forgetting password
     */
    @Test
    public void forgetPasswordTest(){

    }

}