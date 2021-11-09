package BestBuySripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_page {
    
	public WebDriver driver ;
	
	@Test (priority=1)
	public void driverInitialisation()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.bestbuy.ca");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		String ExpectedpageTitle= "Best Buy: Shop Online For Deals & Save | Best Buy Canada";
		String ActualpageTitle= driver.getTitle();
		
	  //hard assertion- stops the test if assertion fails
		
       Assert.assertEquals(ActualpageTitle, ExpectedpageTitle);
       
       //SoftAssertion
       SoftAssert softassert= new SoftAssert();
       softassert.assertEquals(ActualpageTitle, ExpectedpageTitle);
     
		
	}
	/*
	@Test(priority=2)
	public void closebrowser()
	{
		
		driver.close();
	} */


}
