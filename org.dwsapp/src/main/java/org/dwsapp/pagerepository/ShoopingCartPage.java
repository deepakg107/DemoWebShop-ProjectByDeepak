package org.dwsapp.pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoopingCartPage {

	@FindBy(linkText = "Shopping cart")
	private WebElement shoopingCartLink;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	private WebElement checkoutButton;
	
	@FindBy(css = "input[id='termsofservice']")
	private WebElement agreeTermsCheckbox;
	
	@FindBy(id = "ZipPostalCode")
	private WebElement zipPostalCode;
	
	@FindBy(xpath = "(//select[@id='CountryId'])[1]")
	private WebElement countryDropdown;
	
	@FindBy(xpath = "//label[text()='State / province:']/following-sibling::select")
	private WebElement stateDropdown;
	
	@FindBy(css = "input[onclick='Billing.save()']")
	private WebElement BillingAddresscontinueButton;
	
	@FindBy(id = "PickUpInStore")
	private WebElement inStorePickupCheckbox;
	
	@FindBy(css = "input[onclick='Shipping.save()']")
	private WebElement shippingAddressContinueButton;
	
	@FindBy(id = "paymentmethod_0")
	private WebElement paymentMethodByCOD;
	
	@FindBy(id = "paymentmethod_1")
	private WebElement paymentMethodByCHECK;
	
	@FindBy(id = "paymentmethod_2")
	private WebElement paymentMethodByCREDITCard;
	
	@FindBy(id = "paymentmethod_3")
	private WebElement paymentMethodByPurchaseOrder;
	
	@FindBy(css = "input[onclick='PaymentMethod.save()']")
	private WebElement paymentMethodContinueButton;
	
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()' and @value='Continue']")
	private WebElement paymentInfoContinueButton;
	
	@FindBy(css = "input[onclick='ConfirmOrder.save()']")
	private WebElement ConfirmOrderButton;
	
	@FindBy(css = "input[type='button']")
	private WebElement continueThankYou;
	
	@FindBy(linkText = "Click here for order details.")
	private WebElement clickhereForOrderDetails;
	
	@FindBy(id = "CardholderName")
	private WebElement cardHolderName;
	
	@FindBy(id = "CardNumber")
	private WebElement cardNumber;
	
	@FindBy(id = "CardCode")
	private WebElement cardCode;
	
	public ShoopingCartPage(WebDriver driver )
	{
		PageFactory.initElements(driver,this);
	}

	
	
	public WebElement getCardCode()
	{
		return cardCode;
	}
	
	public WebElement getCardNumber() {
		return cardNumber;
	}
	
	public WebElement getCardHolderName() {
		return cardHolderName;
	}

	public WebElement getShoopingCartlink() {
		return shoopingCartLink;
	}



	public WebElement getCheckoutButton() {
		return checkoutButton;
	}



	public WebElement getAgreeTermsCheckbox() {
		return agreeTermsCheckbox;
	}



	public WebElement getZipPostalCode() {
		return zipPostalCode;
	}



	public WebElement getCountryDropdown() {
		return countryDropdown;
	}



	public WebElement getStateDropdown() {
		return stateDropdown;
	}



	public WebElement getBillingAddresscontinueButton() {
		return BillingAddresscontinueButton;
	}



	public WebElement getInStorePickupCheckbox() {
		return inStorePickupCheckbox;
	}



	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}



	public WebElement getPaymentMethodByCOD() {
		return paymentMethodByCOD;
	}



	public WebElement getPaymentMethodByCHECK() {
		return paymentMethodByCHECK;
	}



	public WebElement getPaymentMethodByCREDITCard() {
		return paymentMethodByCREDITCard;
	}



	public WebElement getPaymentMethodByPurchaseOrder() {
		return paymentMethodByPurchaseOrder;
	}



	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}



	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}



	public WebElement getConfirmOrderButton() {
		return ConfirmOrderButton;
	}



	public WebElement getContinueThankYou() {
		return continueThankYou;
	}



	public WebElement getClickhereForOrderDetails() {
		return clickhereForOrderDetails;
	}
	
	
	
	
	
}
