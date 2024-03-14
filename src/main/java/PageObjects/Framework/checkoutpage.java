package PageObjects.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.abstractcomp.AbstractComponents;

public class checkoutpage extends AbstractComponents {

	
	
	WebDriver driver;
	public checkoutpage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryField;
	
	By dropdown = By.cssSelector("section[class*='list-group']");
	
	@FindBy(css="button[type='button']:nth-child(3)")
	WebElement country;
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		  
		a.sendKeys(countryField,countryName).build().perform();
		
		visibilityofelement(dropdown);
		
		country.click();
	}
	
	@FindBy(css="a.action__submit")
	WebElement submitbutton;
	
	public confirmationMessage finish() {
		
		javascriptexecution(submitbutton);
		return new confirmationMessage(driver);
		
	}
	
	
	
}



