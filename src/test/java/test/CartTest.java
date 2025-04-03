package test;
 
 import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import base.ProjectSpecificationMethod;
import page.CartPage;
 import page.LoginPage;
 
 public class CartTest extends ProjectSpecificationMethod{
 
	 public class LogoutTest extends ProjectSpecificationMethod {
			
			@BeforeTest
			public void setup() {
				    sheetname="LoginData";
				   testName="Cart Test";
					testDescription="Testing the cart functionality with positive and negative cases";
					testAuthor="prarthana";
					testCategory="Smoke Testing";
			}

		 @Test(dataProvider = "excelRead")
 	public void validateCartFunctionality(String Username, String Password, String expectedOutcome) throws IOException, InterruptedException {
 		LoginPage loginpg=new LoginPage(driver);
 		loginpg.clickLoginButton();
 		Thread.sleep(2000);
 		loginpg.login(Username,Password);
 		CartPage cartpg=new CartPage(driver);
 		Thread.sleep(2000);
 		cartpg.clickOncart();
 		cartpg.deleteProductsFromCart();
 	}
 	
	 }
 }
 