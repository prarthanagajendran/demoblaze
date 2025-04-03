package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[@class='name']") 
    WebElement productTitle;

    @FindBy(xpath = "//h3[@class='price-container']") 
    WebElement productPrice;

    @FindBy(xpath = "//p[contains(text(),'Description')]")
    WebElement productDescription;

    @FindBy(xpath = "//a[text()='Add to cart']") 
    WebElement addToCartButton;

    @FindBy(id = "cartur")
    WebElement cartLink;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
    	//driver.findElement(By.xpath("//div[@class='card-block']//a[contains(text(),'Laptop')]"));

        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void navigateToCart() {
        cartLink.click();
    }
}
