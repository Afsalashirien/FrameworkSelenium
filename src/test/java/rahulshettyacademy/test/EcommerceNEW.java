package rahulshettyacademy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Framework.OrderPage;
import PageObjects.Framework.ProductCatalogue;
import PageObjects.Framework.cartpage;
import PageObjects.Framework.checkoutpage;
import PageObjects.Framework.confirmationMessage;
import rahulshetty.basetest.Basetest;

public class EcommerceNEW extends Basetest {

	
	//String productName = "Zara coat 3";
	
	
	@Test(dataProvider = "getData" , groups = {"dataset"})
	
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

		
		
		ProductCatalogue productcatalogue = landingpage.logintoapplication(input.get("email"),input.get("password"));
		
		productcatalogue.getProductsList();
		
		
		
		productcatalogue.addToCart(input.get("productName"));
		
		cartpage cartpage = productcatalogue.goTocartpage();
		
	    
	    Boolean match = cartpage.verifycartpage(input.get("productName"));
	    
	    Assert.assertTrue(match);
	    
	    checkoutpage checkoutpage = cartpage.checkout();
	    
	    checkoutpage.selectCountry("chi");
	    
	   confirmationMessage confirmationpage =  checkoutpage.finish();
	    
	    String confirmMessage = confirmationpage.getConfirmationMessage();
		 
        Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmMessage);
		
		
	  
	}

	
	@Test(dependsOnMethods = {"submitOrder"})
	public void verifyOrdersPage() {
		String productName = "Zara coat 3";
		ProductCatalogue productcatalogue = landingpage.logintoapplication("afsalashirien@gmail.com", "Aa123456");
		OrderPage orderpage = productcatalogue.goToorderpage();
		Assert.assertTrue(orderpage.verifyOrderItems(productName));
		
	}
	
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		
		List<HashMap<String,String>> data = getJsonDataToMap();
		
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
		
		
		
	}
	
	/*@DataProvider
	
	public Object[][] getData() {
		
		HashMap <String,String> map = new HashMap <String , String>();
		map.put("email", "afsalashirien@gmail.com");
		map.put("password", "Aa123456");
		map.put("productName", "Zara coat 3");
		
		
		HashMap <String, String> map1 = new HashMap <String , String>();
		map1.put("email", "afsala123@gmail.com");
		map1.put("password", "Aa123456");
		map1.put("productName", "Adidas original");
		
		return new Object[][] {{map},{map1}};
		
		
	}*/
	
	/*@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"afsalashirien@gmail.com","Aa123456","Zara coat 3"},{"afsala123@gmail.com","Aa123456","ADIDAS ORIGINAL"}};			
		
		
		
	}*/
	
}