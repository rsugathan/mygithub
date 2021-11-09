package Automationpractice.Automationpractice;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class switches extends practice{

	
	
	@Test(priority=7)
	public void switchToWindow()
	{
	switches obj= new switches();
	//obj.openurl();
	WebElement openWindowButton= driver.findElement(By.id("openwindow"));
	openWindowButton.click();
	//getWindowHandles method is used to get the handles of all the windows opened and it is stored in a collection as a set of strings
	Set<String> windowHandles =driver.getWindowHandles();
	
	//Iterator is an interface that is used to iterate through each and every element in the list
	java.util.Iterator<String> iterator= windowHandles.iterator();
	
	//Iterator iterates and picks the first iteration as the parent window and the next iteration as the child window
   // using iterator we are iterating through the set of window handles and store the parent and child window handles in a string variable
	String parentWindowHandle= iterator.next();
	String childWindowHandle= iterator.next();
	
	
	driver.switchTo().window(childWindowHandle);
	driver.manage().window().maximize();
	System.out.println("page title of the child window ="+driver.getTitle());
	
	driver.switchTo().window(parentWindowHandle);
	System.out.println("page Title of parent window handle="+driver.getTitle());
		
    }
	
	@Test(priority=8)
	public void switchToTab()
	{
		
		//this.openurl();
		
	WebElement tab= driver.findElement(By.id("opentab"));
	tab.click();
	Set<String> windowhandles=driver.getWindowHandles();
	java.util.Iterator<String> iterator= windowhandles.iterator();
	String p_windowhanle= iterator.next();
	String c_windowhandle= iterator.next();
	driver.switchTo().window(p_windowhanle);
	System.out.println("parent tab="+driver.getTitle());
	driver.switchTo().window(c_windowhandle);
	System.out.println("Child Tab title="+driver.getTitle());
	
    } 
	
	@Test(priority=9)
	public void switchToFrame()
	{
		this.openurl();
		
		//scroll down the page to bring the focus to frame
		// only javascript can perform the scroll action
		JavascriptExecutor js= (JavascriptExecutor)driver;
		// to test the scrollby coordinates just hit and try random values in console
		js.executeScript("window.scrollBy(0,1500)");// to scroll the page down to frame
		
	//WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='course-iframe']/document/html/body/app-root/div/header/div[3]/div/div"));
	driver.switchTo().frame(0);
	System.out.println("frame title= "+driver.getTitle());
	//driver.switchTo().frame("courses-iframe");
	//System.out.println("iframe page title= "+frameElement.getText());
	WebElement allAccessPlanTab= driver.findElement(By.xpath("/html/body/app-root/div/header/div[3]/div/div/div[2]/nav/div[2]/ul/li[3]/a"));
	allAccessPlanTab.click();
	WebElement learningPaths= driver.findElement(By.xpath("/html/body/app-root/div/header/div[3]/div/div/div[2]/nav/div[2]/ul/li[4]/a"));
	learningPaths.click();
	System.out.println("learning path text= "+learningPaths.getText());// to display the text of the web element
	driver.switchTo().parentFrame();
	System.out.println("parent frame page title="+ driver.getTitle());
	js.executeScript("window.scrollBy(0,-1500)"); // to scroll the page up
    }
	
	
	@Test(priority=10)
	public void switchToAlert()
	{
		this.openurl();
		
		WebElement alertButton = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		alertButton.click();
		
		 String alertmessage= driver.switchTo().alert().getText();// to get the alert message
		System.out.println("alertmessage ="+alertmessage);
		driver.switchTo().alert().accept();
		
		
		WebElement confirmbutton= driver.findElement(By.xpath("//input[@id='confirmbtn']"));
		confirmbutton.click();
		String alertmsg= driver.switchTo().alert().getText();
		System.out.println("message ="+alertmsg);
		driver.switchTo().alert().dismiss();
	//driver.close();
    }


@Test(priority=11)
public void clickFooterLinks()
{
	this.openurl();
	//scroll down the page
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,2000)");
	
	WebElement restAPI= driver.findElement(By.xpath("//a[text()='REST API']"));
	String clicklink= Keys.chord(Keys.CONTROL,Keys.ENTER);
	restAPI.sendKeys(clicklink);
	Set<String> windowhandles=driver.getWindowHandles();
	System.out.println(windowhandles);
	java.util.Iterator<String> iterator= windowhandles.iterator();
	String pwindow= iterator.next();
	String cwindow= iterator.next();
	driver.switchTo().window(cwindow);
   System.out.println(driver.getTitle());
   driver.switchTo().window(pwindow);
   System.out.println(driver.getTitle());
   
   //scroll down the page
   js.executeScript("window.scrollBy(0,-2000)");
   
   WebElement image= driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']/a/img"));
   image.click();
   System.out.println("Title n image click= "+driver.getTitle());
   Assert.assertEquals(driver.getTitle(), "Rahul Shetty Academy");
   
   //
	File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//File destination = new File (".//Screenshots/screen.png");
	try {
		FileUtils.copyFile(screenshotFile, new File ("C:\\Work\\Screenshots\\screen.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   
   
	
	
	
	
	
}
}