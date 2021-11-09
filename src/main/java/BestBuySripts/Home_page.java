package BestBuySripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Home_page extends Login_page {
	
	@Test(priority=2)
	public void search_product()
	{   
		this.driverInitialisation();
		WebElement searchbox= driver.findElement(By.xpath("//*[@id='root']/div/div[4]/header/div/div/div[1]/div[2]/div[1]/div/div/form/div/input"));
		//searchbox.click();
		searchbox.sendKeys("dress");
		WebElement searchitem= driver.findElement(By.xpath("//*[@id='root']/div/div[4]/header/div/div/div[1]/div[2]/div[1]/div/div[2]/div/ul/li[5]/a"));
		searchitem.click();
		
		//WebElement result = driver.findElement(By.xpath("//div[@class='container_1l_Qd titleHeader_srY8W']/h1"));
		if(driver.getPageSource().contains("Results for: dressing table"))
		{
			System.out.println("expected item is displayed");
		}
		else
		{
			System.out.println("expected item is not displayed");
		}
		
		
		//search for exact item
		
		searchbox.sendKeys("ViscoLogic ALENA Round Mirror Dressing Table Set With 3 Modes Adjustable LED Light Mirror Vanity");
		searchbox.sendKeys(Keys.ENTER);
		if(driver.getPageSource().contains("1 results"))
		{
			System.out.println(" 1 item displayed");
		}
		else
		{
			System.out.println("search item not displayed");
		}
		
		WebElement clickSearchItem = driver.findElement(By.xpath("//div[@class='productItemName_3IZ3c']"));
		clickSearchItem.click();
		
		
	}
	

}
