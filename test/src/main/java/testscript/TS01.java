package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.com.Flightbookingpage;
import com.testbase.com.ObjectReader;
import com.testbase.com.TestBases;

public class TS01 extends TestBases {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		 
		 
		  driver = getBrowser("chrome");
		  driver.get("https://www.cleartrip.com/");
		 // driver.get(ObjectReader.getconfig().getApplicationUrl());
		  
		  
		
	}
	@Test
 
  public void verify() throws Exception{
	  new Flightbookingpage(driver).SearchFlight();
	  
	
	
	      

  }
  @AfterMethod
  public void teardown() throws Exception{
		driver.close();
		 
		 
	  
	  
	  
	
}


}
