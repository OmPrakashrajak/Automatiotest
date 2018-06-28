package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.com.Flightbookingpage;
import com.pages.com.HotelBookingPage;
import com.testbase.com.TestBases;

public class TSHotel_02 extends TestBases {
WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		 
		 
		 
		  driver = getBrowser("chrome");
		  driver.get("https://www.cleartrip.com/");
		  
		  
		  
		
	}
	@Test
 
  public void verify() throws Exception{
	  new HotelBookingPage(driver).HotelBooking();
	

	
	      

  }
  @AfterMethod
  public void teardown() throws Exception{
	  driver.close();
		
		 
		 
	  
	  
	  
	
}

}
