
package Automationpractice.Automationpractice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practice {
    
	public WebDriver driver;
		
	@Test(priority=1)
	public void openurl() {

		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		String url= "https://rahulshettyacademy.com/AutomationPractice/";
	    driver.get(url);
		driver.manage().window().maximize();
		String expectedPageTitle= "Practice Page";
		System.out.println("page Title= " +driver.getTitle());
	    Assert.assertEquals(driver.getTitle(), expectedPageTitle);
	  		
	}
	    @Test(priority=2)
		public void clickRadiobutton()
	{  	
		WebElement radio2= driver.findElement(By.xpath("//input[@value='radio2']"));
		radio2.click();
		System.out.println(radio2.getText());
		
	}
	    
	    @Test(priority=3)
	    public void autoSuggestionDropdown() throws InterruptedException
	    {
	    		    
	    	WebElement suggestionTextbox= driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
	    	suggestionTextbox.sendKeys("Indi");
	    	Thread.sleep(1000);
	    	WebElement India= driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]/div"));
	    	India.click();
	    	
	 
	    	
	    }
	    
	     
	    @Test(priority=4)
	    public void dropdown()
	    {
	    	WebElement dropdown = driver.findElement(By.xpath("//select[@name='dropdown-class-example']"));
	    	Select select = new Select(dropdown);
	    	
	    	
	    	List<WebElement> dropdownlist =driver.findElements(By.id("dropdown-class-example"));
	    	for(WebElement dropdownelement: dropdownlist)
	    	{
	    		System.out.println("Options in the drop down list"+dropdownelement.getText());
	    		break;
	    		
	    	}
	    	dropdown.click();
	    	select.selectByVisibleText("Option2");
	    	dropdown.click();
	    		    }
	    
	    		
	    @Test(priority=5)
	    public void checkbox()
	    {
	    	WebElement checkbox= driver.findElement(By.id("checkBoxOption2"));
	    	if (checkbox.isSelected()== false)
	    	{
	    		checkbox.click();
	    		System.out.println("selected checkbox text="+checkbox.getText());
	    	}
	    	else
	    	{
	    		System.out.println("checkbox is already selected");
	    		
	    	}
	    }
	    
	    /*
	    public void screenshot()
	    {
	    	
	    	File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	File destination = new File (".//Screenshots/screen.png");
	    	try {
				FileUtils.copyFile(screenshotFile, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
*/
}
