package Automationpractice.Automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Calender_Type2 {
	
	
	@Test
	public void calender() throws InterruptedException
	{
		
		// launch browser
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	//Scroll up the page
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)");
		
	Thread.sleep(5000);
	//click on calender textbox
	driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();
	
	String expected_monthyear="February 2022";
	String expected_date="14";
	
	while(true)
	{
		
		String current_monthyear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	
		if(current_monthyear.equals(expected_monthyear))
		{
			System.out.println("landed on expected month in calender widget");
			break;
			
		}
		else

		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
	}
	
	// Click on the date
	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[2]/a")).click();
	
	
	
	}

}
