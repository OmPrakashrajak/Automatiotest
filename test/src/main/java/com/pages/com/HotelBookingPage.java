package com.pages.com;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.com.TestBases;

public class HotelBookingPage {
	 WebDriver driver;
	public HotelBookingPage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(linkText = "Hotels")
	    private WebElement hotelLink;

	    @FindBy(id = "Tags")
	    private WebElement localityTextBox;
	    @FindBy(id="CheckInDate")
	    private WebElement checkdateedt;
	    @FindBy(xpath="//div[@class='monthBlock first']/table[1]//td")
		List<WebElement> datesedt;
	 
		public void  checkindatepicker(){
			int total=datesedt.size();
			for (int i = 0; i < total; i++) {
				String date=datesedt.get(i).getText();
				if (date.equals("30")){
					datesedt.get(i).click();
					break;
					
				}
				
			}
		}
	    @FindBy(id="CheckOutDate")
	    private WebElement checkoutdateedt;
	    @FindBy(xpath="//div[@class='monthBlock first']/table[1]//td")
		List<WebElement> checkindatesedt;
	 
		public void checoutdatepicker(){
			int total=datesedt.size();
			for (int i = 0; i < total; i++) {
				String date=datesedt.get(i).getText();
				if (date.equals("30")){
					datesedt.get(i).click();
					break;
					
				}
				
			}
		}

	    @FindBy(id = "SearchHotelsButton")
	    private WebElement searchButton;

	    @FindBy(id = "travellersOnhome")
	    private WebElement travellerSelection;
	    public  void HotelBooking() throws InterruptedException{
	    	TestBases.implicitWait(10);
	    	hotelLink.click();
	    	TestBases.implicitWait(10);
	    	localityTextBox.sendKeys("Nehru Place");
	    	TestBases.implicitWait(10);
	    	checkdateedt.click();
	    	checkindatepicker();
	    	TestBases.implicitWait(10);
	    	checkoutdateedt.click();
	    	checoutdatepicker();
	    	
	    	TestBases.implicitWait(10);
	    	searchButton.click();
	    	TestBases.implicitWait(10);
	    	travellerSelection.click();
	    	
	    	


}
}
