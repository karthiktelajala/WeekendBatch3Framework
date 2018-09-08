package pageTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericActionsLibrary.Excel;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTests extends TestBase
{
	public static final Logger log = Logger.getLogger(LoginPageTests.class.getClass());
	LoginPageActions loginPageActions;
	String url = "https://opensource-demo.orangehrmlive.com/";
	String filePath = "./testData/Credentials.xlsx";
	
	@BeforeMethod
	public void testInitializer()
	{
		initailzeBrowser("chrome", 60, url);
		Screenshot.captureScreenshot(driver, "loginPage");
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{	
		loginPageActions = new LoginPageActions(driver);
		
		String un = Excel.readExcel(filePath, 0, 1, 0);
		String pswd = Excel.readExcel(filePath, 0, 1, 1);
		loginPageActions.enterUsername(un);
		log.info("entered username: "+un);
		loginPageActions.enterPassword(pswd);
		log.info("entered password: "+pswd);
		loginPageActions.clickLoginButton();
		
		Screenshot.captureScreenshot(driver, "homePage");
		
		String expTitle = "OrangeHRM";
		String actTitle = loginPageActions.getPageTitle(driver);
		log.info("Asserting actual Title: "+actTitle+ " and expected Title: "+expTitle);
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		
		String un = Excel.readExcel(filePath, 0, 2, 0);
		String pswd = Excel.readExcel(filePath, 0, 2, 1);
		loginPageActions.enterUsername(un);
		log.info("entered username: "+un);
		loginPageActions.enterPassword(pswd);
		log.info("entered password: "+pswd);
		loginPageActions.clickLoginButton();
		
		Screenshot.captureScreenshot(driver, "errorLoginPage");
		
		String expError = "Invalid credentials";
		String actError = loginPageActions.getErrorLoginMessage();
		log.info("Asserting actual error: "+actError+ " and expected error: "+expError);
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void closeTest()
	{
		closeBrowser();
	}

}
