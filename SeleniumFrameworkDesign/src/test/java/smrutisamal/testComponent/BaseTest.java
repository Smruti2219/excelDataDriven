package smrutisamal.testComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import smrutisamal.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop= new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//smrutisamal//resources//GlobalData.properties");
		prop.load(file);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return(driver);
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileHandler.copy(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
//	@BeforeMethod(alwaysRun=true)
	public LandingPage setup() throws IOException {
		driver=initializeDriver();
		landingpage= new LandingPage(driver);
		landingpage.Goto(driver);
		return landingpage;
		
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	
	}

}
