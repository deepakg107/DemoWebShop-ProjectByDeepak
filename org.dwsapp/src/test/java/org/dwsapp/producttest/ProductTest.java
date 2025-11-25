package org.dwsapp.producttest;


import org.dwsapp.genericlibrary.BaseConfig;
import org.dwsapp.genericlibrary.ExcelLibrary;
import org.dwsapp.pagerepository.AccessoriesPage;
import org.dwsapp.pagerepository.BookPage;
import org.dwsapp.pagerepository.CameraPhotoPage;
import org.dwsapp.pagerepository.CellPhonesPage;
import org.dwsapp.pagerepository.DesktopPage;
import org.dwsapp.pagerepository.NoteBookPage;
import org.dwsapp.pagerepository.ShoopingCartPage;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class ProductTest extends BaseConfig {
	@Test(enabled = true, groups = "rt", priority = 1)
	public void verifyHealthBook() {

		// create the Test Information
		test = report.createTest("verify Bookproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

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

	@Test(enabled = true, groups = "ft", priority = 2)
	public void verifyDesktop() {

		// create the Test Information
		test = report.createTest("verify Desktopproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		waitStatement();

		// step 5.................................

		desktopPageobj = new DesktopPage(driver);
		softassertobj = new SoftAssert();

		// ComputerHover is displayed or not
		Assert.assertEquals(desktopPageobj.getComputerHover().isDisplayed(), true);
		Reporter.log("computerhover is displayed ", true);

		// ComputerHover is enabled or not
		Assert.assertEquals(desktopPageobj.getComputerHover().isEnabled(), true);
		Reporter.log("computerhover is enabled ", true);

		//step_5.1  -mouse hover to computers element
		mouseHoverToElement(desktopPageobj.getComputerHover());

		// Desktop hidden element is displayed or not
		Assert.assertEquals(desktopPageobj.getDesktop().isDisplayed(), true);
		Reporter.log("desktop is displayed ", true);

		// Desktop hidden element is enabled or not
		Assert.assertEquals(desktopPageobj.getDesktop().isEnabled(), true);
		Reporter.log("desktop is enabled ", true);

		//step_5.2  -mouse hover to computers- desktop element
		clickOnElementUsingActionsClass(desktopPageobj.getDesktop());

		// desktop product is displayed or not
		Assert.assertEquals(desktopPageobj.getDesktopProduct().isDisplayed(), true);
		// Reporter.log("desktop product is displayed ",true);

		// desktop product is enabled or not
		Assert.assertEquals(desktopPageobj.getDesktopProduct().isEnabled(), true);
		// Reporter.log("desktop product is enabled ",true);

		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(desktopPageobj.getDesktopProduct().isDisplayed());
		Assert.assertTrue(desktopPageobj.getDesktopProduct().isEnabled());

		if (desktopPageobj.getDesktopProduct().isDisplayed() && desktopPageobj.getDesktopProduct().isEnabled()) {
			test.log(Status.PASS, "step4: Verified the desktopProduct is displayed and enabled");
		} else {
			test.log(Status.FAIL, "Step4: verified the desktopProduct is Not displayed and not enabled");
		}

		//step_5.3  -click on desktop product 
		clickOnElement(desktopPageobj.getDesktopProduct());

		// add to cart is displayed or not
		Assert.assertEquals(desktopPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed", true);

		Assert.assertEquals(desktopPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled", true);

		//step_5.4  -click on desktop product add to cart
		clickOnElement(desktopPageobj.getAddToCart());

		Reporter.log(" desktop product is added to cart", true);
		//Reporter.log("All Desktop products Verified .......", true);
		
		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		//step_5.5  -Go to ShoopingCartlink page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());

		//step_5.6  -select AgreeTermsCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());

		//selectOptions("Canada",shoopingCartPageobj.getCountryDropdown());
		
		//step_5.7  -select country dropdown option
		selectOptions(shoopingCartPageobj.getCountryDropdown(), 1);

		//step_5.8  -select state dropdown option
		selectOptions(shoopingCartPageobj.getStateDropdown(), "34");

		//step_5.9  -enter postal code 
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500050");
		
		//step_5.10  -click checkoutbutton 
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		
		//Step_5.11  -click BillingAddresscontinueButton
	    clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
				
				//Step_5.12  -select InStorePickupCheckbox
	    clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
				
				//Step_5.13  -click ShippingAddressContinueButton
	    clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
				
				//Step_5.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCOD());
		Reporter.log("payment method COD",true);
				
				//Step_5.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
				
		
				//Step_5.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
				
				//Step_5.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
				Reporter.log("confirm order :desktop",true);
				
				//Step_5.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
				
				//step_5.19  -navigateBack to thankyou
				driver.navigate().back();
				
				//step_5.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
				Reporter.log("ThankYou desktop order placed",true);
				Reporter.log("step 4: desktop verified & order successfull",true);
		
	}

	// @Parameters("notebook")
	@Test(enabled = true, groups = "it", priority = 3)
	public void verifyNoteBooks() {
		// create the Test Information
		test = report.createTest("verify Notebookproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		waitStatement();

		// step 6.......................................
		noteBookPageobj = new NoteBookPage(driver);
		// computerhover is displayed or not
		Assert.assertEquals(noteBookPageobj.getComputerHover().isDisplayed(), true);
		Reporter.log("computerhover is displayed ", true);

		// computerhover is enabled or not
		Assert.assertEquals(noteBookPageobj.getComputerHover().isEnabled(), true);
		Reporter.log("computerhover is enabled ", true);

		//step_6.1  -mouse hover to computers element
		mouseHoverToElement(noteBookPageobj.getComputerHover());

		// notebook is displayed or not
		Assert.assertEquals(noteBookPageobj.getNoteBook().isDisplayed(), true);
		Reporter.log("notebook is displayed", true);

		// notebook is enabled or not
		Assert.assertEquals(noteBookPageobj.getNoteBook().isEnabled(), true);
		Reporter.log("notebook is enabled", true);

		//step_6.2  -mouse hover to computers- Notebook element
		clickOnElementUsingActionsClass(noteBookPageobj.getNoteBook());

		// notebook product is displayed or not
		Assert.assertEquals(noteBookPageobj.getNoteBookprd1().isDisplayed(), true);
		// Reporter.log("notebook product is displayed",true);

		// notebook product is enabled or not
		Assert.assertEquals(noteBookPageobj.getNoteBookprd1().isEnabled(), true);
		// Reporter.log("notebook product is enabled",true);

		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(noteBookPageobj.getNoteBookprd1().isDisplayed());
		Assert.assertTrue(noteBookPageobj.getNoteBookprd1().isEnabled());

		if (noteBookPageobj.getNoteBookprd1().isDisplayed() && noteBookPageobj.getNoteBookprd1().isEnabled()) {
			test.log(Status.PASS, "step4: Verified the NotebookProduct is displayed and enabled");
		} else {
			test.log(Status.FAIL, "Step4: verified the  NotebookProduct is Not displayed and not enabled");
		}

		//step_6.3  -click on notebook product
		clickOnElement(noteBookPageobj.getNoteBookprd1());

		// add to cart is displayed or not
		Assert.assertEquals(noteBookPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed", true);

		// add to cart is enabled or not
		Assert.assertEquals(noteBookPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is  enabled ", true);

		// softassertobj.assertAll();
		//step_6.4  -click on  add to cart
		clickOnElement(noteBookPageobj.getAddToCart());
		
		Reporter.log(" notebook product is added to cart", true);
		//Reporter.log("All Notebooks products Verified .......", true);

		
		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		//step_6.5  -Go to ShoopingCartlink page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());

		//step_6.6  -select AgreeTermsCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());

		//step_6.7  -select country dropdown option
		selectOptions("United States",shoopingCartPageobj.getCountryDropdown());

		//step_6.8  -select state dropdown option
		selectOptions(shoopingCartPageobj.getStateDropdown(), "54");

		//step_6.9  -enter postal code
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500059");
		
		//step_6.10  -click CheckoutButton
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		
		
		//Step_6.11  -click BillingAddresscontinueButton
	    clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
				
				//Step_6.12  -select InStorePickupCheckbox
	    clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
				
				//Step_6.13  -click ShippingAddressContinueButton
	    clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
				
				//Step_6.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCOD());
		Reporter.log("payment method COD",true);
				
				//Step_6.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
				
		
				//Step_6.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
				
				//Step_6.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
				Reporter.log("confirm order :notebook",true);
				
				//Step_6.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
				
				//step_6.19  -navigateBack to thankyou
				driver.navigate().back();
				
				//step_6.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
				Reporter.log("ThankYou Notebook order placed",true);
				Reporter.log("step 4: Notebook verified & order successfull",true);
		
	}

	@Test(enabled = true, groups = "rt", priority = 4)
	public void verifyAccessories() {

		// create the Test Information
		test = report.createTest("verify Accessoriesproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		// step 7........................
		waitStatement();
		accessoriesPageobj = new AccessoriesPage(driver);
		softassertobj = new SoftAssert();

		// computerhover is displayed or not
		Assert.assertEquals(accessoriesPageobj.getComputerHover().isDisplayed(), true);
		Reporter.log("computerhover is displayed ", true);

		// computerhover is enabled or not
		Assert.assertEquals(accessoriesPageobj.getComputerHover().isEnabled(), true);
		Reporter.log("computerhover is enabled ", true);

		//Step_7.1 Mouse hover to computers element
		mouseHoverToElement(accessoriesPageobj.getComputerHover());

		// Accessories is displayed or not
		Assert.assertEquals(accessoriesPageobj.getAccessories().isDisplayed(), true);
		Reporter.log("Accessories is displayed  ", true);

		// Accessories is enabled or not
		Assert.assertEquals(accessoriesPageobj.getAccessories().isEnabled(), true);
		Reporter.log("Accessories is enabled ", true);

		//Step_7.2 Mouse hover and click  to computers- Accessories element
		clickOnElementUsingActionsClass(accessoriesPageobj.getAccessories());

		// Accessories product is displayed or not
		Assert.assertEquals(accessoriesPageobj.getAccessorieprd1().isDisplayed(), true);
		// Reporter.log("Accessories product is displayed ",true);

		// Accessories product is enabled or not
		Assert.assertEquals(accessoriesPageobj.getAccessorieprd1().isEnabled(), true);
		// Reporter.log("Accessories product is enabled ",true);
		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(accessoriesPageobj.getAccessorieprd1().isDisplayed());
		Assert.assertTrue(accessoriesPageobj.getAccessorieprd1().isEnabled());

		if (accessoriesPageobj.getAccessorieprd1().isDisplayed()
				&& accessoriesPageobj.getAccessorieprd1().isEnabled()) {
			test.log(Status.PASS, "step4: Verified the AccessoriesProduct is displayed and enabled");
		} else {
			test.log(Status.FAIL, "Step4: verified the AccessoriesProduct is Not displayed and not enabled");
		}

         //step_7.3 select & click Accessories product        
		clickOnElement(accessoriesPageobj.getAccessorieprd1());

		// add to cart is displayed or not
		softassertobj.assertEquals(accessoriesPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed", true);

		// add to cart is enabled or not
		softassertobj.assertEquals(accessoriesPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled", true);

		//Step_7.4 Add Accessorie product to cart
		clickOnElement(accessoriesPageobj.getAddToCart());
		//Reporter.log("All Accessories products Verified .......", true);
		Reporter.log(" accessories product is added to cart", true);
		
		
		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		waitStatement(shoopingCartPageobj.getShoopingCartlink());
		
		//Step_7.5 go to shoopingCart page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());

		//step_7.6  -select AgreeTermsCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());

		//step_7.7  -select country dropdown option
		selectOptions(shoopingCartPageobj.getCountryDropdown(),"1");

		//step_7.8  -select state dropdown option
		selectOptions("Tennessee",shoopingCartPageobj.getStateDropdown() );

		//step_7.9  -enter postal code
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500060");
		
		//step_7.10  -click CheckoutButton
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		
		//Step_7.11  -click BillingAddresscontinueButton
	    clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
				
				//Step_7.12  -select InStorePickupCheckbox
	    clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
				
				//Step_7.13  -click ShippingAddressContinueButton
	    clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
				
				//Step_7.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCOD());
		Reporter.log("payment method COD",true);
				
				//Step_7.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
				
		
				//Step_7.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
				
				//Step_7.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
				Reporter.log("confirm order :Accessorie",true);
				
				//Step_7.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
				
				//step_7.19  -navigateBack to thankyou
				driver.navigate().back();
				
				//step_7.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
				Reporter.log("ThankYou Accessories order placed",true);
				Reporter.log("step 4: accessories verified & order successfull",true);
	}

	@Test(groups = "ft", priority = 5, enabled = true)
	public void verifyCamera() {

		// create the Test Information
		test = report.createTest("verify Cameraproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		// step 8................
		waitStatement();
		cameraPhotoPageobj = new CameraPhotoPage(driver);

		// ElectronicsHover is displayed or not
		Assert.assertEquals(cameraPhotoPageobj.getElectronicsHover().isDisplayed(), true);
		Reporter.log("ElectronicsHover is displayed ", true);

		// ElectronicsHover is enabled or not
		Assert.assertEquals(cameraPhotoPageobj.getElectronicsHover().isEnabled(), true);
		Reporter.log("ElectronicsHover is enabled ", true);

		//step_8.1  -Mouse hover to electronics element
		mouseHoverToElement(cameraPhotoPageobj.getElectronicsHover());

		// cameraPhoto is displayed or not
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhoto().isDisplayed(), true);
		Reporter.log("cameraPhoto is displayed ", true);

		// cameraPhoto is enabled or not 
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhoto().isEnabled(), true);
		Reporter.log("cameraPhoto is enabled ", true);

		//step_8.2  -Mouse hover and click electronics- cameraPhoto element
		clickOnElementUsingActionsClass(cameraPhotoPageobj.getCameraPhoto());

		// cameraPhoto product is selected or not
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed(), true);
		// Reporter.log("cameraPhoto product is displayed",true);

		// cameraPhoto product is enabled or not
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled(), true);
		// Reporter.log("cameraPhoto product is enabled ",true);

		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed());
		Assert.assertTrue(cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled());

		if (cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed()
				&& cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled()) {
			test.log(Status.PASS, "step4: Verified the cameraProduct is displayed and enabled");
		} else {
			test.log(Status.FAIL, "step4: verified the cameraProduct is Not displayed and not enabled");
		}

		//step_8.3  -click on cameraPhone product
		clickOnElement(cameraPhotoPageobj.getCameraPhotoProduct1());

		// add to cart is displayed or not
		Assert.assertEquals(cameraPhotoPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed", true);

		// add to cart is enabled or not
		Assert.assertEquals(cameraPhotoPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled", true);

		//step_8.4  -Add cameraphoto product to cart
		clickOnElement(cameraPhotoPageobj.getAddToCart());
		Reporter.log("ElectronicsTest-Camera product is  added to cart", true);
		
		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		//step_8.5  -go to ShoopingCart page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());

		//step_8.6  -select AgreeTermsCheckbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());

		//step_8.7  -select country dropdown option	
		selectOptions("Canada",shoopingCartPageobj.getCountryDropdown());

		//step_8.8  -select state dropdown option
		selectOptions(shoopingCartPageobj.getStateDropdown(), "62");

		//step_8.9  -enter postal code
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500070");
		
		//step_8.10  -click on checkout button
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		
		//Step_8.11  -click BillingAddresscontinueButton
	    clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
				
				//Step_8.12  -select InStorePickupCheckbox
	    clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
				
				//Step_8.13  -click ShippingAddressContinueButton
	    clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
				
				//Step_8.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCOD());
		Reporter.log("payment method COD",true);
				
				//Step_8.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
				
		
				//Step_8.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
				
				//Step_8.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
				Reporter.log("confirm order :Cameraphoto",true);
				
				//Step_8.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
				
				//step_8.19  -navigateBack to thankyou
				driver.navigate().back();
				
				//step_8.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
				Reporter.log("ThankYou camera order placed",true);
				Reporter.log("step 4: camera verified & order successfull",true);
				
	}

	@Test(groups = "rt", priority = 6, enabled = true)
	public void verifyCellPhones() {

		// create the Test Information
		test = report.createTest("verify CellPhoneproduct 1");

		// steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO, "step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		// step 9........................
		waitStatement();
		cellPhonesPageobj = new CellPhonesPage(driver);

		// ElectronicsHover is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getElectronicsHover().isDisplayed(), true);
		Reporter.log("ElectronicsHover is displayed ", true);

		// ElectronicsHover is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getElectronicsHover().isEnabled(), true);
		Reporter.log("ElectronicsHover is enabled ", true);

		//Step_9.1 mouse hover to electronics element
		mouseHoverToElement(cellPhonesPageobj.getElectronicsHover());

		// cell phone is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhone().isDisplayed(), true);
		Reporter.log("cell phone is displayed ", true);

		// cell phone is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhone().isEnabled(), true);
		Reporter.log("cell phone is enabled ", true);

		//Step_9.2 mouse hover to electronics- cellphone element
		clickOnElementUsingActionsClass(cellPhonesPageobj.getCellPhone());

		// cell phone product is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhoneProduct1().isDisplayed(), true);
		// Reporter.log("cell phone product is displayed ",true);

		// cell phone product is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhoneProduct1().isEnabled(), true);
		// Reporter.log("cell phone product is enabled ",true);
		// step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(cellPhonesPageobj.getCellPhoneProduct1().isDisplayed());
		Assert.assertTrue(cellPhonesPageobj.getCellPhoneProduct1().isEnabled());

		if (cellPhonesPageobj.getCellPhoneProduct1().isDisplayed()
				&& cellPhonesPageobj.getCellPhoneProduct1().isEnabled()) {
			test.log(Status.PASS, "step4: Verified the cellPhoneProduct is displayed and enabled");
		} else {
			test.log(Status.FAIL, "step4: verified the cellPhoneProduct is Not displayed and not enabled");
		}

		//Step_9.3 click on cell phone product
		clickOnElement(cellPhonesPageobj.getCellPhoneProduct1());

		// add to cart is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed", true);

		// add to cart is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled", true);

		//Step_9.4 add phone product to cart
		clickOnElement(cellPhonesPageobj.getAddToCart());

		Reporter.log("Cell phones product is added to cart", true);
		
		
		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isDisplayed());
		Reporter.log("shooping cart displayed", true);

		Assert.assertTrue(shoopingCartPageobj.getShoopingCartlink().isEnabled());
		Reporter.log("shooping cart enabled", true);

		//Step_9.5 go to shoopingCart page
		clickOnElement(shoopingCartPageobj.getShoopingCartlink());
		
		//Step_9.6 click agreeTerms checkbox
		clickOnElementUsingActionsClass(shoopingCartPageobj.getAgreeTermsCheckbox());

		//Step_9.7 select country option from dropdown
		selectOptions(shoopingCartPageobj.getCountryDropdown(),"1");

		//Step_9.8 select state option from dropdown 
		selectOptions(shoopingCartPageobj.getStateDropdown(),21);

		//Step_9.9 enter postal code
		enterDataOnElements(shoopingCartPageobj.getZipPostalCode(), "500080");
		
		//step_9.10 click on checkout button
		clickOnElement(shoopingCartPageobj.getCheckoutButton());
		
		//Step_9.11  -click BillingAddresscontinueButton
	    clickOnElement(shoopingCartPageobj.getBillingAddresscontinueButton());
				
				//Step_9.12  -select InStorePickupCheckbox
	    clickOnElementUsingActionsClass(shoopingCartPageobj.getInStorePickupCheckbox());
				
				//Step_9.13  -click ShippingAddressContinueButton
	    clickOnElement(shoopingCartPageobj.getShippingAddressContinueButton());
				
				//Step_9.14  -select payment method
		clickOnElementUsingActionsClass(shoopingCartPageobj.getPaymentMethodByCOD());
		Reporter.log("payment method COD",true);
				
				//Step_9.15  -click payment method continue button
		clickOnElement(shoopingCartPageobj.getPaymentMethodContinueButton());
				
		
				//Step_9.16  -click payment Information continue button
		clickOnElement(shoopingCartPageobj.getPaymentInfoContinueButton());
				
				//Step_9.17  -click ConfirmOrderButton
		clickOnElement(shoopingCartPageobj.getConfirmOrderButton());
				Reporter.log("confirm order :CellPhone",true);
				
				//Step_9.18  -click ForOrderDetails
		clickOnElement(shoopingCartPageobj.getClickhereForOrderDetails());
				
				//step_9.19  -navigateBack to thankyou
				driver.navigate().back();
				
				//step_9.20  -click on ThankYou continue button
		clickOnElement(shoopingCartPageobj.getContinueThankYou());
				Reporter.log("ThankYou phone order placed");
				Reporter.log("step 4: cellphone verified & order successfull",true);
				
	}

}
