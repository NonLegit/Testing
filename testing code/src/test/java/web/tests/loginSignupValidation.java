package web.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.GetData;
import web.testComponents.BaseTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static constants.TestConstants.*;

public class loginSignupValidation extends BaseTest{

    /**
     * this is a test method to test the login with username and password
     * @param username: this is the username through which he can sign into hos account
     * @param password: this is the user password through which he can login into his account
     */
    @Test(description = "login in with some username and password", dataProvider = "loginExcelDataProvider")
    public void loginTest(String username, String password, String expectedResult){
        landingPage.login(username, password);
        String errorMessage = landingPage.getLoginErrorMessage();
        if(expectedResult.equalsIgnoreCase("fail") && (errorMessage.equalsIgnoreCase("Please fill out this field.") || errorMessage.equalsIgnoreCase("Incorrect username or password")) || errorMessage.equalsIgnoreCase("Username must be between 3 and 20 characters")){
            Assert.assertTrue(true);
        }else if(expectedResult.equalsIgnoreCase("success") && errorMessage.equalsIgnoreCase("success")){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    /**
     * tis function is used to test the signup functionality
     */
    @Test(description = "sign up with some random generate username and password")
    public void signupTest(){
        /*this should be */
        GetData getData = new GetData();
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


}