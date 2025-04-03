package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethod;
import page.HomePage;
import page.ProductDetailsPage;
import page.CartPage;

public class ProductTest extends ProjectSpecificationMethod {
	

	@BeforeTest
	public void setup() {
		    sheetname="LoginData";
		   testName="Purchase Test";
			testDescription="Testing the purchase functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
	}

    @Test   //(dataProvider = "excelRead")String Username, String Password, String expectedOutcome
    public void testAddProductToCart() throws IOException {
        HomePage homePage = new HomePage(driver);

        homePage.clickProduct("Sony vaio i5");  

        ProductDetailsPage productPage = new ProductDetailsPage(driver);
        
        // Verify product details
        String title = productPage.getProductTitle();
        String price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        Assert.assertNotNull(title, "Product title is missing.");
        Assert.assertNotNull(price, "Product price is missing.");
        Assert.assertNotNull(description, "Product description is missing.");

        // Add product to cart
        productPage.addToCart();

        // Navigate to cart and verify product is added
        productPage.navigateToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductAddedToCart(), "Product not added to cart.");
    }
}
