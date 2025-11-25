package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	

	public LoginPage(WebDriver driver)
	   {
		
		PageFactory.initElements( driver,this);
		//PageFactory.initElements( driver,this.passwordTextField);
	   }
	
	
	public WebElement getEmail()
	{
		return emailTextField;
		
	}
	
	public WebElement getPassword()
	{
		return passwordTextField;
	}
	
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	
}
