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
     * tis function is used to test the signup functionality using google
     */
    @Test(description = "sign up with some suggested username and random password", dataProvider = "loginSignUpGoogleExcelDataProvider")
    public void googleSignupUsingSuggestedNameTest(String email, String password) throws InterruptedException {
        HomePage homePage = landingPage.googleSignUp(email, password);
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
     * tis function is used to test the signup functionality using facebook
     */
    @Test(description = "sign up with some suggested username and random password", dataProvider = "loginSignUpGoogleExcelDataProvider")
    public void facebookSignupUsingSuggestedNameTest(String email, String password) throws InterruptedException {
        HomePage homePage = landingPage.facebookSignUp(email, password);
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
     * tis function is used to test the normal signup functionality
     */
    @Test(description = "sign up with some random generate username and password")
    public void NormalSignupUsingRandomNameTest(){

        String randomEmail = getData.generateRandomString(10) + "@gmail.com";
        String randomUsername = getData.generateRandomString(15);
        String randomPassword = getData.generateRandomString(10) + "*.";
        List<String>data = new ArrayList<>();
        data.add(randomUsername);
        data.add(randomPassword);
        data.add("success");

        HomePage homePage = landingPage.RandomSignup(randomUsername, randomEmail, randomPassword);

        Assert.assertNotNull(homePage);

        getData.insertRecordIntoExcelSheet(data, EXCEL_PATH, LOGIN_TEST_DATA);
    }

    /**
     * tis function is used to test the signup functionality using suggested username
     */
    @Test(description = "sign up with some suggested username and random password")
    public void NormalSignupUsingSuggestedNameTest(){

        String randomEmail = getData.generateRandomString(10) + "@gmail.com";
        String randomPassword = getData.generateRandomString(10) + "*.";

        String randomUsername = landingPage.suggestedSignup(randomEmail, randomPassword);

        List<String>data = new ArrayList<>();
        data.add(randomUsername);
        data.add(randomPassword);
        data.add("success");
        System.out.println(data);

        Assert.assertNotNull(randomUsername);

        getData.insertRecordIntoExcelSheet(data, EXCEL_PATH, LOGIN_TEST_DATA);
    }

}