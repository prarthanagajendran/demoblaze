package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import page.HomePage;
import page.SignupPage;
import base.ProjectSpecificationMethod;

public class SignupTest extends ProjectSpecificationMethod {
	

 	@BeforeTest
 	public void setup() {
 		    sheetname="SignupData";
 		   testName="Signup Test";
			testDescription="Testing the Signup functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
	}

    @Test(priority=1,dataProvider = "excelRead")
    public void testSignup(String Username, String Password,String invalidUsername, String invalidPassword) throws InterruptedException {
        SignupPage signup = new SignupPage(driver);
       HomePage homePage = new HomePage(driver);  
       signup.clickSignupLink();

        signup.enterUsername(Username);
        
        signup.enterPassword(Password);
        signup.clickSignupButton();

        Thread.sleep(2000);

        String alertText = signup.getAlertMessage();
        Assert.assertTrue(alertText.contains("Sign up successful"));
        
        signup.acceptAlert();
    }
    @Test(priority=2,dataProvider = "excelRead")
    public void invalidtestSignup(String Username, String Password,String invalidUsername, String invalidPassword) throws InterruptedException {
        SignupPage signup = new SignupPage(driver);
       HomePage homePage = new HomePage(driver);  
       signup.clickSignupLink();

        signup.enterUsername(invalidUsername);
        
        signup.enterPassword(invalidPassword);
        signup.clickSignupButton();

        Thread.sleep(2000);
        String alertText = signup.getAlertMessage();
        Assert.assertTrue(alertText.contains("This user already exist."));
        
        signup.acceptAlert();
    }

   
}//Wrong password.
