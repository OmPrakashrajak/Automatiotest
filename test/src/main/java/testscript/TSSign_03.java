package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.com.HotelBookingPage;
import com.pages.com.SignInPage;
import com.testbase.com.TestBases;

public class TSSign_03 extends TestBases  {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		 
		 
		 
		  driver = getBrowser("chrome");
		  driver.get("https://www.cleartrip.com/");
		  
		  
		  
		
	}
	@Test
 
  public void verify() throws Exception{
	  new SignInPage(driver).SighIn();;
	

	
	      

  }
  @AfterMethod
  public void teardown() throws Exception{
	  driver.close();
		
		 

}
}
