package Automationpractice.Automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender_Type4 {
	
	
	@Test
	public void calender()
	{
		
		//Launch Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//scroll up the page
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		// click on calender widget
		
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		String expected_monthyear="September 2020";
		String expected_day ="11";
		
		while(true)
		{
			String current_monthyear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		  if (current_monthyear.equals(expected_monthyear)) {
			  break;
		  }
		  else
		  {
			driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
			
		  }
		}
		
		// click on the day in the selected month year
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[6]/a")).click();
		
		
		
		
	}

}
