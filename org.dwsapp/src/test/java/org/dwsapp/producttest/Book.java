package org.dwsapp.producttest;

import org.dwsapp.genericlibrary.BaseConfig;
import org.dwsapp.genericlibrary.ExcelLibrary;
import org.dwsapp.pagerepository.BookPage;
import org.dwsapp.pagerepository.ShoopingCartPage;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;



public class Book extends BaseConfig{

	@Test(enabled=true,groups = "rt",priority = 1)
	public void verifyHealthBook() {

		//create the Test Information
		test=report.createTest("verify Bookproduct 1");
				
		//steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO,"step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");
		
	
//		String searchbook="book";
//		if(searchbook.equals("book"))
//		{
//	
//		//wpobj.getSearch().sendKeys(searchbook);
//		enterDataOnElements(wpobj.getSearch(), searchbook);
//		//wpobj.getSearchButton().click();
//		clickOnElement(wpobj.getSearchButton());
//		WebElement addToCart =driver.findElement(By.xpath("//input[@value='Add to cart']"));
//		clickOnElement(addToCart);
//		Reporter.log(" health book product added to cart ",true);
//		Reporter.log("Verified health book",true);
//		
//		//p.getBook1().click();
//		
//		}
//		else
//		{
//			Reporter.log("enter valid book");
//		}
		
		
		waitStatement();

//		//step 4

		bookpageobj = new BookPage(driver);
		softassertobj = new SoftAssert();
		excelLibraryobj = new ExcelLibrary();
		shoopingCartPageobj = new ShoopingCartPage(driver);

		// String searchbook="book";

		// search displayed enabled selected or not
		Assert.assertEquals(wpobj.getSearch().isDisplayed(), true);
		Reporter.log("search box is displayed ", true);

		Assert.assertEquals(wpobj.getSearch().isEnabled(), true);
		Reporter.log("search box is enabled ", true);

		// enterDataOnElements(wpobj.getSearch(),searchbook);
		
		// step_4.1  - enter text "book" in search Store
		enterDataOnElements(wpobj.getSearch(), excelLibraryobj.readData("SearchBook", 2, 0));

		// search button displayed,enabled or not
		Assert.assertEquals(wpobj.getSearchButton().isDisplayed(), true);
		Reporter.log("search button is displayed ", true);

		Assert.assertEquals(wpobj.getSearchButton().isEnabled(), true);
		Reporter.log("search button is enabled ", true);

		// step_4.2  - click on search button
		clickOnElement(wpobj.getSearchButton());

		// book product is displayed,enabled,or not
		Assert.assertEquals(bookpageobj.getbookProduct1().isDisplayed(), true);
		// Reporter.log("book product is displayed ",true);

		// book product is enabled or not.
		Assert.assertEquals(bookpageobj.getbookProduct1().isEnabled(), true);
		// Reporter.log("book product is enabled ",true);

		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(bookpageobj.getbookProduct1().isDisplayed());
		Assert.assertTrue(bookpageobj.getbookProduct1().isEnabled());

		if (bookpageobj.getbookProduct1().isDisplayed() && bookpageobj.getbookProduct1().isEnabled()) {
			test.log(Status.PASS, "step4: verified the bookproduct1 is displayed and enabled");
		} else {
			test.log(Status.FAIL, "step4: verified the bookproduct1 is Not displayed and not enabled");
		}

		//Step_4.3  - click on health book product
		clickOnElement(bookpageobj.getbookProduct1());

		// add to cart is displayed or not
		Assert.assertEquals(bookpageobj.getaddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed ", true);

		// add to cart is enabled or not
		Assert.assertEquals(bookpageobj.getaddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled ", true);

		//Step_4.4  - add book product to cart
		clickOnElement(bookpageobj.getaddToCart());

		Reporter.log(" health book added to cart", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		//Step_4.5  -go to shooping cart page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());

		//Step_4.6  -select AgreeTermsCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());
        
		softassertobj.assertEquals(shoopingCartPageobj.getAgreeTermsCheckbox().isSelected(), true);
		Reporter.log("Agree Terms checkbox selected",true);

		//Step_4.7  -select CountryDropdown
		selectOptions("Canada",shoopingCartPageobj.getCountryDropdown());

		//Step_4.8  -select StateDropdown
		selectOptions(shoopingCartPageobj.getStateDropdown(), "62");
		
		//Step_4.9  -Enter postal code
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500090");
		
		Assert.assertEquals(shoopingCartPageobj.getCheckoutButton().isDisplayed(), true);
		Reporter.log("checkoutbutton is displayed",true);
		
		//Step_4.10  -click checkout button
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		Reporter.log("clicked on checkout button");
		
		//Step_4.11  -click BillingAddresscontinueButton
		clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
		
		//Step_4.12  -select InStorePickupCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
		
		//Step_4.13  -click ShippingAddressContinueButton
		clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
		
		//Step_4.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCHECK());
		Reporter.log("payment method check",true);
		
		//Step_4.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
		
//		enterDataOnElements(shoopingCartPageobj.getCardHolderName(), "deepak12@");
//		
//		enterDataOnElements(shoopingCartPageobj.getCardNumber(), "12345907");
//		
//		enterDataOnElements(shoopingCartPageobj.getCardCode(), "999");
		
		//Step_4.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
		
		//Step_4.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
		Reporter.log("confirm order :book",true);
		
		//Step_4.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
		
		//step_4.19  -navigateBack to thankyou
		driver.navigate().back();
		
		//step_4.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
		Reporter.log("ThankYou book order placed",true);
		Reporter.log("step 4:book verified & order successfull",true);
		
		// Assert.fail();
	}
}
