package PageObjects.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.abstractcomp.AbstractComponents;

public class confirmationMessage extends AbstractComponents {

	
	WebDriver driver;
	public confirmationMessage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement Thankyoumessage;
	
	public String getConfirmationMessage() {
		
	 return Thankyoumessage.getText();
	  
	}
	
}
