package test;


import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.LoginPage;


import java.io.IOException;

public class LoginTest extends ProjectSpecificationMethod {
	
	@BeforeTest
 	public void setup() {
 		    sheetname="LoginData";
 		   testName="Login Test";
			testDescription="Testing the login functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
	}

    @Test(dataProvider = "excelRead")
    public void testLogin(String Username, String Password, String expectedOutcome) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.login(Username, Password);

        if (expectedOutcome.equalsIgnoreCase("Pass")) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful");
        } if(expectedOutcome.equalsIgnoreCase("Wrong password.")) {
            String alertText = loginPage.getAlertMessage();

            loginPage.getAlertMessage();
        	
            Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should fail");
            System.out.println("Loginfails");
        }else {
        	
        }
        
        
    }
 
}
   

