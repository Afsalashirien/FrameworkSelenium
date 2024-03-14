package PageObjects.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.abstractcomp.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='card-body']")
	List<WebElement> productlist;
	
	By logintoastmessage = By.id("toast-container");
	
	public List<WebElement> getProductsList() {
		
		visibilityofelement(logintoastmessage);
		return productlist;
	}
	
	
	public WebElement getRequiredProduct(String productName) {
		
		WebElement prod = getProductsList().stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	By addtocarticon = By.cssSelector(".card-body button:last-of-type");
	
	By addtoastmessage = By.cssSelector("#toast-container");
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	
	public void addToCart(String productName) throws InterruptedException {
		
		WebElement prod = getRequiredProduct(productName);
		prod.findElement(addtocarticon).click();
		visibilityofelement(addtoastmessage);
		invisibilityofelement(spinner);
		
			}
	
	
	
	
	
}
