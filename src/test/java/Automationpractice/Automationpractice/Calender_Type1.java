package Automationpractice.Automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender_Type1 {

	@Test
	public void calender() throws InterruptedException
	{

		// launch browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		//scroll the screen bit up
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");


		//click on date picker textbox.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='first_date_picker']")).click();

		// Click on date picker.
		String expectedmonthyear= "January 2022";
		String expectedday="25";
				
        while(true)
        {
        	String current_monthyear= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			if(current_monthyear.equals(expectedmonthyear))
			{
				
				System.out.println("landed on expected month in calender widget");
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
	         
	    }
        
        
        // click on the expected date
     driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[4]/a")).click();
	}
}

