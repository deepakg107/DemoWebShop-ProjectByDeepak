package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPhonesPage {

	@FindBy(xpath = "//a[contains(text(),'Electronics')]")
	private WebElement electronicsHover;

	@FindBy(xpath = "//a[contains(text(),'Electronics')]/following::ul/li[2]/a")
	private WebElement cellPhone;

	@FindBy(linkText = "Smartphone")
	private WebElement cellPhoneProduct1;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;

	public CellPhonesPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	public WebElement getElectronicsHover() {
		return electronicsHover;
	}

	public WebElement getCellPhone() {
		return cellPhone;
	}

	public WebElement getCellPhoneProduct1() {
		return cellPhoneProduct1;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}



}
