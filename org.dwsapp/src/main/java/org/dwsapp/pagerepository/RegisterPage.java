package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	
	@FindBy(xpath = "//label[text()='Gender:']/following::input[@type='radio']")
	private WebElement genderRadioButton;
	
	@FindBy(xpath = "//label[text()='First name:']/following::input[@id='FirstName']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath = "//label[text()='Last name:']/following::input[@id='LastName']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//label[text()='Email:']/following::input[@id='Email']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//label[text()='Password:']/following::input[@id='Password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//label[text()='Confirm password:']/following::input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;
	
	
	//step 2..........................
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	
	//Step 3.....................................
	
	

	
	public WebElement getGender()
	{
		return genderRadioButton;
	}
	
	public WebElement getFirstName()
	{
		return firstNameTextField;
	}
	
	public WebElement getLastName()
	{
		return lastNameTextField;
	}
	
	public WebElement getEmail()
	{
		return emailTextField;
	}
	
	public WebElement getPassword()
	{
		return passwordTextField;
	}
	
	public WebElement getConfirmPassword()
	{
		return confirmPasswordTextField;
	}
	
	public WebElement getRegisterButton()
	{
		return registerButton;
	}
}
