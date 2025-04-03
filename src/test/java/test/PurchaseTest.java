package test;
 
 import java.io.IOException;
 
 import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.CartPage;
 import page.LoginPage;
 import page.PurchasePage;
 
 public class PurchaseTest extends ProjectSpecificationMethod{
 
			
			@BeforeTest
			public void setup() {
				    sheetname="PurchasePageData";
				   testName="Purchase Test";
					testDescription="Testing the purchase functionality with positive and negative cases";
					testAuthor="prarthana";
					testCategory="Smoke Testing";
			}
	@Test(dataProvider = "excelRead")
 	public void purchaseFunctionality(String Username, String Password, String name,String country,String city,String card,String month,String year) throws IOException, InterruptedException {
 		LoginPage loginpg=new LoginPage(driver);
 		loginpg.clickLoginButton();
 		Thread.sleep(2000);
 		loginpg.login(Username, Password);
 		CartPage cartpg=new CartPage(driver);
 		Thread.sleep(2000);
 		cartpg.clickOncart();
 		PurchasePage purchasepg=new PurchasePage(driver);
 		Thread.sleep(2000);
 		purchasepg.placeOrderButton();
 		Thread.sleep(500);
 		purchasepg.enterName(name);
 		Thread.sleep(500);
 		purchasepg.enterCountry(country);
 		Thread.sleep(500);
 		purchasepg.enterCity(city);
 		Thread.sleep(500);
 		purchasepg.enterCard(card);
 		Thread.sleep(500);
 		purchasepg.enterMonth(month);
 		Thread.sleep(500);
 		purchasepg.enterYear(year);
 		Thread.sleep(500);
 		purchasepg.purchaseButton();
 		Thread.sleep(500);
 		String msg=purchasepg.seeSuccessMsg();
 		Assert.assertTrue(msg.contains("Thank you for your purchase"));
 	}
 }
 