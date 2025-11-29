package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPage {

	@FindBy(xpath = "//a[contains(text(),'Computers')]/following::ul/li[3]/a")
	private WebElement accessories;

	@FindBy(linkText = "TCP Instructor Led Training")
	private WebElement accessorieprd1;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	private WebElement computerHover;

	public AccessoriesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccessories() {
		return accessories;
	}

	public WebElement getAccessorieprd1() {
		return accessorieprd1;
	}

	public WebElement getComputerHover() {
		return computerHover;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
}
