package com.pages.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.com.ObjectReader;
import com.testbase.com.TestBases;

public class Flightbookingpage extends ObjectReader {
	WebDriver driver;
	public Flightbookingpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="OneWay")
	private WebElement onewayedt;
	@FindBy(id="FromTag")
	private WebElement FromTagedt;
	@FindBy(id="ToTag")
	private WebElement ToTagedt;
	@FindBy(id="DepartDate")
	private WebElement DepartDateedtt;
	@FindBy(xpath="//div[@class='monthBlock first']/table[1]//td")
	List<WebElement> datesedt;
	public void datepicker(){
		int total=datesedt.size();
		for (int i = 0; i < total; i++) {
			String date=datesedt.get(i).getText();
			if (date.equals("30")){
				datesedt.get(i).click();
				break;
				
			}
			
		}
	}
	@FindBy(id="SearchBtn")
	private WebElement Searchedt;
	
	
	
	
	public  void SearchFlight() throws InterruptedException{
		TestBases.implicitWait(10);
		onewayedt.click();
		TestBases.implicitWait(10);
		FromTagedt.sendKeys("Delhi");
		FromTagedt.click();
		TestBases.implicitWait(10);
		ToTagedt.sendKeys("Bangalore");
		ToTagedt.click();
		TestBases.implicitWait(10);
		DepartDateedtt.click();
		TestBases.implicitWait(10);
		datepicker();
		TestBases.implicitWait(10);
		Searchedt.click();
		
		
		
		
		
		
	}




}
