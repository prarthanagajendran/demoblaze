package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    @FindBy(id = "login2")  
    private WebElement loginButton;

    @FindBy(id = "loginusername") 
    private WebElement usernameField;

    @FindBy(id = "loginpassword") 
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']") 
    private WebElement submitLoginButton;

    @FindBy(id = "nameofuser") 
    private WebElement welcomeMessage;
    
    
    @FindBy(id = "logout2") 
    private WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginButton() {
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(usernameField)); 
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }
    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }
    
    public void clicklogout() {
    	logoutButton.click();
    }
}
