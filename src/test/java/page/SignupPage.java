package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;
import utils.Utility;

public class SignupPage extends ProjectSpecificationMethod {

     //Locators for Sign Up elements
    @FindBy(id = "signin2") 
   private WebElement signupLink;

    @FindBy(id = "sign-username") 
    private WebElement usernameField;

    @FindBy(id = "sign-password") 
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']") 
    private WebElement signupButton;

    public SignupPage(WebDriver driver) {
    	this.driver = driver;
 		PageFactory.initElements(driver,this );
    }

    public void clickSignupLink() {
      signupLink.click();
   }

    public void enterUsername(String username) {
      

        usernameField.sendKeys(username);
    }

   
    public void enterPassword(String password) {
    	
        passwordField.sendKeys(password);
    }

   
    public void clickSignupButton() {
        signupButton.click();
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
