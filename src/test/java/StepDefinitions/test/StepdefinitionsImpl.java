package StepDefinitions.test;

import java.io.IOException;

import org.testng.Assert;

import PageObjects.Framework.Landingpage;
import PageObjects.Framework.ProductCatalogue;
import PageObjects.Framework.cartpage;
import PageObjects.Framework.checkoutpage;
import PageObjects.Framework.confirmationMessage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshetty.basetest.Basetest;

public class StepdefinitionsImpl extends Basetest {

	
public Landingpage landingpage;

public ProductCatalogue productcatalogue;
		
public confirmationMessage confirmationpage;

		@Given("User is on eCommerce page.")
		
		public void user_is_on_ecommercePage() throws IOException {
			
			landingpage = launchapplication();
			
		}
		
		@Given ("^user logged in using username (.+) and password (.+)$")
		
		public void user_login(String username,String password)
		{
			
		 productcatalogue = landingpage.logintoapplication(username,password);
		 
		}
		
		@When ("^I add the product (.+) into cart$")
		
		public void add_product(String productName) throws InterruptedException {
			
			productcatalogue.getProductsList();
			
		   productcatalogue.addToCart(productName);
			
			}
		
		@And ("^click checkout (.+) and complete the order$")
		
		public void checkout_product(String productName) {
			
			cartpage cartpage = productcatalogue.goTocartpage();
			
		    
		    Boolean match = cartpage.verifycartpage(productName);
		    
		    Assert.assertTrue(match);
		    
		    checkoutpage checkoutpage = cartpage.checkout();
		    
		    checkoutpage.selectCountry("chi");
		    
		   confirmationpage =  checkoutpage.finish();
		}

		
		@Then ("I receive a success message as {string}")
		
		public void get_sucess_message (String string) {
			
			String confirmMessage = confirmationpage.getConfirmationMessage();
			 
	        Assert.assertEquals(string, confirmMessage);
	        
	        driver.close();
		}
		
		@Then ("{string} message is displayed")
		
		public void get_error_message (String string) {
			Assert.assertEquals(string, landingpage.getErrorMessage());
			driver.close();
		}
		
	}


