package rahulshettyacademy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("userEmail")).sendKeys("afsalashirien@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Aa123456");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		List <WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
		
		String productName = "Zara coat 3";
		
		WebElement prod = products.stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	   driver.findElement(By.cssSelector(".btn.btn-custom :nth-child(2)")).click();	
	   
	   List <WebElement> cartItems = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	   
	   
	  Boolean match = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
	  
	  Assert.assertTrue(match);
	  
	  driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
	  
	  Actions a = new Actions(driver);
	  
	  a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "chi").build().perform();
	  
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='list-group']")));
	  
	  driver.findElement(By.cssSelector("button[type='button']:nth-child(3)")).click();
	  
	 //JavascriptExecutor js = (JavascriptExecutor)driver;

	 //js.executeScript("window.scrollBy(0,1000)");
	  
	  
	  //driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	  
	  WebElement Submit = driver.findElement(By.cssSelector("a.action__submit"));

	  JavascriptExecutor js = (JavascriptExecutor) driver;

	  js.executeScript("arguments[0].click();", Submit);
	  
	 String confirmMessage =  driver.findElement(By.cssSelector(".hero-primary")).getText();
	 
	
	 
	 Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmMessage);
	  
	 //driver.close();
	  
	}

	
}