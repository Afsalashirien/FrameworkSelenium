package PageObjects.Framework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.abstractcomp.AbstractComponents;

public class cartpage extends AbstractComponents {

	
	WebDriver driver;
	public cartpage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "div[class='cartSection'] h3")
	List<WebElement> cartitems;
	
	public Boolean verifycartpage(String productName) {
		
		Boolean match = cartitems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	@FindBy(css = "li[class='totalRow'] button")
	WebElement checkout;
	
	
	public checkoutpage checkout() {
		
		checkout.click();
		checkoutpage checkoutpage = new checkoutpage(driver);
		return checkoutpage;
		
	}
	
	
}