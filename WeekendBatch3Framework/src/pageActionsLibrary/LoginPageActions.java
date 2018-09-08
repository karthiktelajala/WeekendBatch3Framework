package pageActionsLibrary;

import org.openqa.selenium.WebDriver;

import pageObjectsLibrary.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterUsername(String username)
	{
		txtUsername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		btnLogin.click();
	}
	
	public String getErrorLoginMessage()
	{
		return msgErrorLogin.getText();
	}
	
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}
