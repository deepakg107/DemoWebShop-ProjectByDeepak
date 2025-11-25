package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	
	@FindBy(linkText = "Log in")
	private WebElement loginlink;
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutlink;
	
	
	@FindBy(css = "input[id='small-searchterms']")
	private WebElement searchBox;
	
	@FindBy(css = "input[value='Search']")
    private WebElement searchButton;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogin() {
		return loginlink;
	}
	
	public WebElement getLogoutButton()
	{
		return logoutlink;
	}
	
	public WebElement getSearch()
	{
		return searchBox;
	}
	
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	
	public WebElement getRegisterLink()
	{
		return registerLink;
	}
	
	
	
}
