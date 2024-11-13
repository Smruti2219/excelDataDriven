import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingStaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Select currency =new Select(driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]")));
		currency.selectByVisibleText("Select");
		List<WebElement> options = currency.getOptions();
		
		//Selecting option using 3 methods.
		currency.selectByValue("INR");
		currency.selectByIndex(1);
		currency.selectByVisibleText("USD");
		
		//Printing all currency options in 
		 for(WebElement option : options){
		    System.out.println(option.getText());
		        }
		 //Automate Passenger dropdown
		 driver.findElement(By.id("divpaxinfo")).click();
		 
		 
		for(int i=0; i<3; i++) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("hrefIncAdt"))));
			driver.findElement(By.id("hrefIncAdt")).click();
			 }
		
		WebElement element = driver.findElement(By.id("divpaxinfo"));
		System.out.println(element.getText());
		
	
		WebElement element2 = driver.findElement(By.xpath("//input[@id='autosuggest']"));
		System.out.println(element2);
		    
	driver.quit();
	}		
		
}
