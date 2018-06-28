package com.testbase.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;













import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;







import org.testng.annotations.Parameters;

import com.sun.javafx.PlatformUtil;


public class TestBases {
				static WebDriver driver;
				String newAdwinID;
				String mainWinID;
				@Parameters("browser")
				
				public static WebDriver getBrowser(String browser)
							{
					    /*...................> Browser selection <..........................*/
					System.out.println("[setting up driver:" + browser + "]");
								if (browser.equalsIgnoreCase("firefox")) {
									 System.setProperty("webdriver.gecko.driver","geckho.exe");
									 driver = new FirefoxDriver();
									 driver.manage().window().maximize();
									//return driver;
							}else if(browser.equalsIgnoreCase("chrome"))
							{
							         
									 System.setProperty("webdriver.gecko.driver","D:\\PAMS_24_08_2016\\test\\src\\main\\resources\\geckodriver.exe" );
							         System.setProperty("webdriver.chrome.driver", "D:\\PAMS_24_08_2016\\test\\src\\main\\resources\\chromedriver.exe");
							         ChromeOptions options = new ChromeOptions();
							         options.addArguments("--disable-notifications");
							 		 options.addArguments("disable-infobars");
							 		 options.addArguments("--start-maximized");
							 	     options.addArguments("--disable-web-security");
							 	     options.addArguments("--no-proxy-server");
							 	     HashMap<String, Object> prefs = new HashMap<String, Object>();
							 	     prefs.put("credentials_enable_service", false);
							 	     prefs.put("profile.password_manager_enabled", false);
							 	     options.setExperimentalOption("prefs", prefs);
							 		 driver=new ChromeDriver(options);
							         driver.manage().window().maximize();
							         
							 
							        }  else if(browser.equalsIgnoreCase("ie"))
							        	
							
							{
							           
							           //System.setProperty("webdriver.gecko.driver",DataProviderfactory.getconfig().getgeckho() );
							           
							           System.setProperty("webdriver.ie.driver","C:\\Users\\prakash\\Desktop\\geckho\\IEDriverServer.exe");
							           driver= new InternetExplorerDriver();
							           driver.manage().window().maximize();
							     //  return driver;
							
							}
								       return driver;
							
								
							}
							public static WebDriver waitFor(int sec) throws InterruptedException {
								Thread.sleep(sec * 1000);
								return driver;
							}
							
							public static void expliciteWait(WebElement element, int timeToWaitInSec) {
								try {
									WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
									wait.until(ExpectedConditions.visibilityOf(element));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							public static void clickWhenReady(WebElement locator, int timeout) {
								WebElement element = null;
								WebDriverWait wait = new WebDriverWait(driver, timeout);
								element = wait.until(ExpectedConditions.elementToBeClickable(locator));
								element.click();
							
							}
							public static void implicitWait(int timetowaitInSec){
								driver.manage().timeouts().implicitlyWait(timetowaitInSec,TimeUnit.SECONDS);
							}
							/*...................> Implicitly wait Method to wait for loading a page <..........................*/
							
							public void wait_for_page_load(int time)
							{
								driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
							}
							
							/*...................> Explicitly wait Method for waiting an element in a page <..........................*/
							
							public void wait_for_element_present(WebElement wb)
							{
								WebDriverWait wait=new WebDriverWait(driver,20);
								wait.until(ExpectedConditions.visibilityOf(wb));
							}
							
							/*...................> Explicitly wait Method for URL in a page <..........................*/
							
							public void wait_until_url_contains(String url)
							{
								WebDriverWait wait=new WebDriverWait(driver,20);
								wait.until(ExpectedConditions.urlContains(url));
							}
							
							/*...................> Explicitly wait Method for URL in a page <..........................*/
							
							public void wait_until_text_present(WebElement wb,String text)
							{
								WebDriverWait wait=new WebDriverWait(driver,20);
								wait.until(ExpectedConditions.textToBePresentInElement(wb, text));
							}
							
							/*...................> Method to use Fluent wait <..........................*/
							
							public void fluent_wait(WebElement ele)
							{
								FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
								wait.withTimeout(30, TimeUnit.SECONDS);
								wait.pollingEvery(5, TimeUnit.SECONDS);
								wait.ignoring(NoSuchElementException.class);
								wait.until(ExpectedConditions.elementToBeClickable(ele));
							}
							
							/*...................> Normal wait method using Thread.Sleep method <..........................*/
							public void wait_in_seconds(int i) throws InterruptedException
							{
								Thread.sleep(1000*i);
							}
							
							/*...................> Method to Accept an Alert in a browser <..........................*/
							
							public void accept_alert()
							{
								WebDriverWait wait=new WebDriverWait(driver,10);
								wait.until(ExpectedConditions.alertIsPresent());
								Alert alt=driver.switchTo().alert();
								alt.accept();
							}
							
							/*...................> Method to Cancel an Alert in a browser <..........................*/
							
							public void cancel_alert()
							{
								WebDriverWait wait=new WebDriverWait(driver,10);
								wait.until(ExpectedConditions.alertIsPresent());
								Alert alert=driver.switchTo().alert();
								alert.dismiss();
							}
							
							/*...................> Method to get an alert text <..........................*/
							
							public String get_alert_text()
							{
								WebDriverWait wait=new WebDriverWait(driver,10);
								wait.until(ExpectedConditions.alertIsPresent());
								Alert alt=driver.switchTo().alert();
								String text=alt.getText();
								return text;
							}
							
							/*...................> Method for switching to a frame using id <..........................*/
							
							public void swith_to_frame_using_id(String id)
							{
								driver.switchTo().frame(id);
							}
							
							/*...................> Method for switching to a frame using name <..........................*/
							
							public void swith_to_frame_using_name(String name)
							{
								driver.switchTo().frame(name);
							}
							
							/*...................> Method for switching to a frame using number <..........................*/
							
							public void swith_to_frame_using_number(String number)
							{
								driver.switchTo().frame(number);
							}
							
							/*...................> Method for switching to default content <..........................*/
							
							public void swith_to_defaulat_content()
							{
								driver.switchTo().defaultContent();
							}
							
							/*...................> Browser Navigation Methods <..........................*/
							
							public void navigate_back()
							{
								driver.navigate().back();
							}
							
							public void navigate_forword()
							{
								driver.navigate().forward();
							}
							
							public void navigate_refresh()
							{
								driver.navigate().refresh();
							}
							
							
							 public  void setDriverPath() {
							        if (PlatformUtil.isMac()) {
							            System.setProperty("webdriver.chrome.driver", "chromedriver");
							        }
							        if (PlatformUtil.isWindows()) {
							            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
							        }
							        if (PlatformUtil.isLinux()) {
							            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
							        }
							    }
							 public  boolean isElementPresent(By by) {
							        try {
							            driver.findElement(by);
							            return true;
							        } catch (NoSuchElementException e) {
							            return false;
							        }
							    }
							

}

