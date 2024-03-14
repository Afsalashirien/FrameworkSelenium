package rahulshettyacademy.test;

import org.testng.Assert;

import org.testng.annotations.Test;



import PageObjects.Framework.ProductCatalogue;
import PageObjects.Framework.cartpage;
import rahulshetty.basetest.Basetest;

public class ErrorValidationTest extends Basetest{
	
	
	@Test(groups= {"negative"} , retryAnalyzer=rahulshetty.basetest.Retry.class)
	
	public void incorrectLogin() {

	landingpage.logintoapplication("afsala@gmail.com", "Aa123456");
	Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	
	
	}	
	
	
	
	@Test
	public void productValidation() throws InterruptedException {
		
		ProductCatalogue productcatalogue = landingpage.logintoapplication("afsala123@gmail.com", "Aa123456");

		String productName = "Zara coat 3";
		
		productcatalogue.getProductsList();
		
	    productcatalogue.addToCart(productName);
		
		cartpage cartpage = productcatalogue.goTocartpage();
		
	    
	    Boolean match = cartpage.verifycartpage("zaracoate");
	    
	    Assert.assertFalse(match);
		
	}
}
	
	
