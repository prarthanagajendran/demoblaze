// LogoutPage.java (Page Object Model for Logout)
// LogoutTest.java (TestNG test class)
package test;
 import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import base.ProjectSpecificationMethod;
import page.LoginPage;
import page.LogoutPage;
 
public class LogoutTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup() {
		    sheetname="LoginData";
		   testName="Logout Test";
			testDescription="Testing the logout functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
	}

 @Test(dataProvider = "excelRead")
 	public void validateLogoutFunctionality(String Username, String Password, String expectedOutcome) throws IOException, InterruptedException {
	 LoginPage loginPage = new LoginPage(driver);
     loginPage.clickLoginButton();
     loginPage.login(Username, Password);

 		LogoutPage logoutpg=new LogoutPage(driver);
 		Thread.sleep(2000);
 		logoutpg.logout();
 		Thread.sleep(500);
 		logoutpg.seeLoginMsg();
 	}
}
 