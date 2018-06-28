package com.pages.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.com.TestBases;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(linkText="Your trips")
    private WebElement Yourtripslinkedt;
    @FindBy(id="SignIn")
    private WebElement Signinedt;
    @FindBy(id="signInButton")
    private WebElement signInButtonedt;
    public void Iframe(){
        driver.switchTo().frame("modal_window");
    }
    public void defaultContent(){
    	driver.switchTo().defaultContent();
    }
    public void Validate(){
    	String errors1 = errorsedt;
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
    }
    @FindBy(id="errors1")
    String errorsedt;;
    public void SighIn(){
    	Yourtripslinkedt.click();
    	TestBases.implicitWait(10);
    	Signinedt.click();
    	TestBases.implicitWait(10);
    	Iframe();
    	signInButtonedt.click();
    	defaultContent();
    	
    	
    	
    	
    }
   

    
   
    
}
