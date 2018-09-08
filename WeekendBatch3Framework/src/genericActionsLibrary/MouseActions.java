package genericActionsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public static void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();	
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement eleDrag, WebElement eleDrop )
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(eleDrag, eleDrop).build().perform();
	}
	
	public static void rightMouseClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

}
