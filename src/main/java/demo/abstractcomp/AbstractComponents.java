package demo.abstractcomp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Framework.OrderPage;
import PageObjects.Framework.cartpage;

public class AbstractComponents {

	WebDriver driver;
	

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		}

	
	
	public void visibilityofelement(By toastlogin) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(toastlogin));
		
	}
	
	public void visibilityofwebelement(WebElement toastmessage) {
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.visibilityOf(toastmessage));
			
		}
	
	
	
	public void invisibilityofelement(WebElement ele) throws InterruptedException {
		
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.
	}
	
	@FindBy(css =".btn.btn-custom :nth-child(2)")
	WebElement carticon;
	
	public cartpage goTocartpage() {
		
		carticon.click();
		cartpage cartpage = new cartpage(driver);
		return cartpage;
		
	}
	
	
	public void javascriptexecution(WebElement click) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()" , click);
	
}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordericon;
	
    public OrderPage goToorderpage() {
		
		ordericon.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
}