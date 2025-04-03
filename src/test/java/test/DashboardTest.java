package test;
 
 import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.DashboardPage;
 import page.LoginPage;
 
 public class DashboardTest extends ProjectSpecificationMethod {

		@BeforeTest
		public void setup() {
			    sheetname="LoginData";
			   testName="Purchase Test";
				testDescription="Testing the purchase functionality with positive and negative cases";
				testAuthor="prarthana";
				testCategory="Smoke Testing";
		}
    @Test(dataProvider = "excelRead")
        public void seeWelcomeUserMessage(String Username, String Password, String expectedOutcome) throws IOException, InterruptedException {
 		Thread.sleep(2000);
 		LoginPage loginpg=new LoginPage(driver);
 		loginpg.clickLoginButton();
 		loginpg.login(Username, Password);
 		Thread.sleep(500);
 		DashboardPage dashboardpg=new DashboardPage(driver);
 		Thread.sleep(500);
 		dashboardpg.welcomeMessage(Username);	
 		Thread.sleep(500);
 		dashboardpg.allMenuesList();
 		Thread.sleep(500);
 		dashboardpg.allCategoriesList();	
 	}
 
 }