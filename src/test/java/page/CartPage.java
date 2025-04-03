package page;
 
 import java.io.IOException;
 import java.util.List;
 
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 
import base.ProjectSpecificationMethod;
 
 public class CartPage extends ProjectSpecificationMethod {
 
 	public CartPage(WebDriver driver) throws IOException {
 		PageFactory.initElements(driver, this);
 		this.driver=driver;
 	}
 	
 	@FindBy(xpath="//tbody[@id='tbodyid']/tr/td/following-sibling::td[3]/a")
 	List<WebElement> deleteProduct;
 	
 	@FindBy(id="cartur")
 	WebElement cartTab;
 	
 	@FindBy(xpath = "//tbody/tr")  
    WebElement cartItem;

 	
 	public void clickOncart() {
 		cartTab.click();
 	}
 	public void deleteProductsFromCart() {
 		List<WebElement> deletecount=deleteProduct;
 		try{
 			for(WebElement delete:deletecount) {
 			delete.click();
 		}
 		} catch(Exception e) {
 			deletecount=deleteProduct;
 		}
 		
 	}

    public boolean isProductAddedToCart() {
        return cartItem.isDisplayed();
    }
 }