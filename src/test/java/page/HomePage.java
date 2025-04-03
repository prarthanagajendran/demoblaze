package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    
    
    @FindBy(id="signin2") 
    WebElement Signin;
    
   
 	
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 

   
    public void clickProduct(String productName) {
        WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']"));
        product.click();
    }
    
    
}
