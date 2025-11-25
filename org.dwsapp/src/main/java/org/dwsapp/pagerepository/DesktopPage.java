package org.dwsapp.pagerepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {

	@FindBy(linkText = "Build your own cheap computer")
	private WebElement desktopProduct1;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//a[contains(text(),'Computers')]/following::ul/li[1]/a")
	private WebElement desktop;
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	private WebElement computerHover;
	
	
	
	public DesktopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDesktopProduct() {
		return desktopProduct1;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
 
	public WebElement getDesktop()
	{
		return desktop;
	}
	

	public WebElement getComputerHover() {
		return computerHover;
	}

	
	
	
}
