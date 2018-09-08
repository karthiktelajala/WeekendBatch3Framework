package genericActionsLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot 
{
	public static void captureScreenshot(WebDriver driver,String screenshotName )
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile1 = ts.getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile1, new File("./screenshots/"+screenshotName+".png"));
		}
		catch(Exception e)
		{
			System.out.println("Exception while capturing screenshot :"+e.getMessage());
		}
	}
}
