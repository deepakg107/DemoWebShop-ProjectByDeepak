package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CameraPhotoPage {

	@FindBy(xpath =   "//a[contains(text(),'Electronics')]")
	private WebElement electronicsHover;

	@FindBy(xpath = "//a[contains(text(),'Electronics')]/following::ul/li[1]/a")
	private WebElement cameraPhoto;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;


	@FindBy(linkText = "Digital SLR Camera 12.2 Mpixel")
	private WebElement cameraPhotoProduct1;


	public CameraPhotoPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}


	public WebElement getElectronicsHover() {
		return electronicsHover;
	}


	public WebElement getCameraPhoto() {
		return cameraPhoto;
	}


	public WebElement getAddToCart() {
		return addToCart;
	}


	public WebElement getCameraPhotoProduct1() {
		return cameraPhotoProduct1;
	}


}
