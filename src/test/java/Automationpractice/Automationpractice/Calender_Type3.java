package Automationpractice.Automationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Calender_Type3 {

	@Test
	public void calender()
	{
		//launch browser
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//scroll page up
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
				
		// click on calender text box
		
		driver.findElement(By.xpath("//input[@id='third_date_picker']")).click();
		
		//Select month
		WebElement monthselector = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select select1= new Select(monthselector);
		select1.selectByVisibleText("Sep");
		
		// Select year
		WebElement yearselector= driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select select2= new Select(yearselector);
		select2.selectByVisibleText("2020");
		
		// select day
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[5]/a")).click();
        
		
				
		
		
		

	}
}
