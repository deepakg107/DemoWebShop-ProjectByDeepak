package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoteBookPage {
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]/following::ul/li[2]/a")
	private WebElement noteBook;
	
	@FindBy(linkText = "14.1-inch Laptop")
	private WebElement noteBookprd1;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	private WebElement computerHover;
	
	public NoteBookPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getComputerHover() {
		return computerHover;
	}

	public WebElement getNoteBook() {
		return noteBook;
	}

	public WebElement getNoteBookprd1() {
		return noteBookprd1;
	}
	
	public WebElement getAddToCart() {
		return addToCart;
	}
}
