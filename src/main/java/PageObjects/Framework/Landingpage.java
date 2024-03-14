package PageObjects.Framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.abstractcomp.AbstractComponents;

public class Landingpage extends AbstractComponents{

	WebDriver driver;
	public Landingpage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	

	@FindBy(id = "userEmail")
	WebElement useremail;
	
	@FindBy(id = "userPassword")
	WebElement userpassword;
	
	@FindBy(id = "login")
	WebElement submit;
	
	public ProductCatalogue logintoapplication(String username, String pwd) {
		
		useremail.sendKeys(username);
		userpassword.sendKeys(pwd);
		submit.click();
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
		
	}
	
	public void access() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errormessage;
	
	public String getErrorMessage() {
		
	visibilityofwebelement(errormessage);
	return	errormessage.getText();
		
	}
	
	
}
