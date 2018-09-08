package testBaseLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestBase 
{	
	public static final Logger log = Logger.getLogger(TestBase.class.getClass());
	public WebDriver driver;
	
	public void initailzeBrowser(String browser, int sec, String url)
	{
		String log4jPath = "log4jProperties";
		PropertyConfigurator.configure(log4jPath);
		launchBrowser(browser);
		log.info(browser+" browser is launched");
		maximizeBrowser();
		implicitWait(sec);
		getURL(url);		
		log.info("navigating to the url: "+url);
	}
	
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//you need to put respective code for "gecko" driver
			File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
	}
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}

	public void closeBrowser()
	{
		driver.close();
		log.info("browser is closed");
	}
	
	public void quitBrowser()
	{
		driver.quit();
		log.info("quit from browser");
	}
	
	public void implicitWait(int sec)
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

}
