package org.dwsapp.producttest;

import org.dwsapp.genericlibrary.BaseConfig;
import org.dwsapp.pagerepository.AccessoriesPage;
import org.dwsapp.pagerepository.DesktopPage;
import org.dwsapp.pagerepository.NoteBookPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;


public class ComputerTest extends BaseConfig{
	
	@Test(enabled=true,groups = "ft",priority = 3)
	public void verifyDesktop()
	{
		
		//create the Test Information
			test=report.createTest("verify Desktopproduct 1");
						
				//steps Information
			test.log(Status.INFO, "Step 1: launching the browser");
			test.log(Status.INFO,"step 2: navigating to application via url successfull");
			test.log(Status.INFO, "step3: verified page successfull");
				
	
		
		
//		String desktop="computer";
//		if(desktop.equals("computer"))
//		{
//		//wpobj.getSearch().sendKeys(desktop);
//			enterDataOnElements(wpobj.getSearch(), desktop);
//		//wpobj.getSearchButton().click();
//			clickOnElement(wpobj.getSearchButton());
//		//p.getComputer1().click();
//		
//		List<WebElement> alldesktops=driver.findElements(By.xpath("//div[@class='product-grid']/child::div/div/div[2]/h2"));
//		System.out.println(alldesktops.size());
//		
//		for(WebElement we:alldesktops)
//		{
//			System.out.println("desktop "+we.getText());
//		}
//		WebElement addToCart =driver.findElement(By.xpath("//input[@value='Add to cart']"));
//		clickOnElement(addToCart);
//		for(WebElement we:alldesktops)
//		{
//			
//			clickOnElement(we);
//			
//			driver.navigate().back();
//		}
//		
//		
//		Reporter.log("All Desktop products Verified .......",true);
//		}
//		else
//		{
//			Reporter.log("All Desktop products  NotVerified .......",true);
//		}
		
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
	
	
	//@Parameters("notebook")
	@Test(enabled=true,groups = "it",priority = 1)
	public void verifyNoteBooks()
	{
		//create the Test Information
		test=report.createTest("verify Notebookproduct 1");
					
			//steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO,"step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");
			
		
		
		
		
		waitStatement();
//		String notebook="14.1-inch Laptop";
//		if(notebook.equals("14.1-inch Laptop"))
//		{
//			//wpobj.getSearch().sendKeys(notebook);
//			enterDataOnElements(wpobj.getSearch(), notebook);
//			//wpobj.getSearchButton().click();
//			clickOnElement(wpobj.getSearchButton());
//			
//			
//			//p.getNoteBook().click();
//	WebElement addToCart =driver.findElement(By.xpath("//input[@value='Add to cart']"));
//	clickOnElement(addToCart);
//	
//		Reporter.log("All Notebooks products Verified .......",true);
//		}
//		else
//		{
//			Reporter.log("All Notebooks products NotVerified .......",true);
//		}
		
	//step 5.2.......................................
		 noteBookPageobj=new NoteBookPage(driver);
		 //computerhover is displayed or not
		 Assert.assertEquals(noteBookPageobj.getComputerHover().isDisplayed(), true);
		 Reporter.log("computerhover is displayed ",true);
		 
		 
		 //computerhover is enabled or not
		 Assert.assertEquals(noteBookPageobj.getComputerHover().isEnabled(), true);
		 Reporter.log("computerhover is enabled ",true);
		 
		mouseHoverToElement(noteBookPageobj.getComputerHover());
		
		//notebook is displayed or not
		Assert.assertEquals(noteBookPageobj.getNoteBook().isDisplayed(), true);
		Reporter.log("notebook is displayed",true);
		
		//notebook is enabled or not
		Assert.assertEquals(noteBookPageobj.getNoteBook().isEnabled(), true);
		Reporter.log("notebook is enabled",true);
		
		
		clickOnElementUsingActionsClass(noteBookPageobj.getNoteBook());
		
		//notebook product is displayed or not
		Assert.assertEquals(noteBookPageobj.getNoteBookprd1().isDisplayed(), true);
		//Reporter.log("notebook product is displayed",true);
		
		//notebook product is enabled or not
		Assert.assertEquals(noteBookPageobj.getNoteBookprd1().isEnabled(), true);
		//Reporter.log("notebook product is enabled",true);
		

		//step2 : click on "Demo web Shop book product in books page
	Assert.assertTrue(noteBookPageobj.getNoteBookprd1().isDisplayed());
    Assert.assertTrue(noteBookPageobj.getNoteBookprd1().isEnabled());
    
    
		if(noteBookPageobj.getNoteBookprd1().isDisplayed() &&
				noteBookPageobj.getNoteBookprd1().isEnabled())
		{
			test.log(Status.PASS, "step4: Verified the NotebookProduct is displayed and enabled");
		}
		else
		{
			test.log(Status.FAIL, "Step4: verified the  NotebookProduct is Not displayed and not enabled");
		}
		
		
		clickOnElement(noteBookPageobj.getNoteBookprd1());
		
		
		//add to cart is displayed or not
		Assert.assertEquals(noteBookPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed",true);
		
		
		//add to cart is enabled or not
		Assert.assertEquals(noteBookPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is  enabled ",true);
		
		//softassertobj.assertAll();
		clickOnElement(noteBookPageobj.getAddToCart());
		
		Reporter.log("All Notebooks products Verified .......",true);
		
		
	}
	
	
	@Test(enabled=true,groups = "rt",priority = 2)
	public void verifyAccessories()
	{
		
		//create the Test Information
				test=report.createTest("verify Accessoriesproduct 1");
							
					//steps Information
				test.log(Status.INFO, "Step 1: launching the browser");
				test.log(Status.INFO,"step 2: navigating to application via url successfull");
				test.log(Status.INFO, "step3: verified page successfull");
					
	
	//step 5.3........................	
		waitStatement();
		accessoriesPageobj=new AccessoriesPage(driver);
		softassertobj=new SoftAssert();
		
		//computerhover is displayed or not
		Assert.assertEquals(accessoriesPageobj.getComputerHover().isDisplayed(), true);
		Reporter.log("computerhover is displayed ",true);
		
		
		//computerhover is enabled or not
		Assert.assertEquals(accessoriesPageobj.getComputerHover().isEnabled(), true);
		Reporter.log("computerhover is enabled ",true);
		 
		
		mouseHoverToElement(accessoriesPageobj.getComputerHover());
		
		
		//Accessories is displayed or not
		Assert.assertEquals(accessoriesPageobj.getAccessories().isDisplayed(), true);
		Reporter.log("Accessories is displayed  ",true);
		
		//Accessories is enabled or not
		Assert.assertEquals(accessoriesPageobj.getAccessories().isEnabled(), true);
		Reporter.log("Accessories is enabled ",true);
		
		
		clickOnElementUsingActionsClass(accessoriesPageobj.getAccessories());
		
		
		//Accessories product is displayed or not
		Assert.assertEquals(accessoriesPageobj.getAccessorieprd1().isDisplayed(), true);
		//Reporter.log("Accessories product is displayed ",true);
		
		//Accessories product is enabled or not
		Assert.assertEquals(accessoriesPageobj.getAccessorieprd1().isEnabled(), true);
		//Reporter.log("Accessories product is enabled  ",true);
		//step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(accessoriesPageobj.getAccessorieprd1().isDisplayed());
        Assert.assertTrue(accessoriesPageobj.getAccessorieprd1().isEnabled());
		
		if(accessoriesPageobj.getAccessorieprd1().isDisplayed() &&
				accessoriesPageobj.getAccessorieprd1().isEnabled())
		{
			test.log(Status.PASS, "step4: Verified the AccessoriesProduct is displayed and enabled");
		}
		else
		{
			test.log(Status.FAIL, "Step4: verified the AccessoriesProduct is Not displayed and not enabled");
		}
		
		
		clickOnElement(accessoriesPageobj.getAccessorieprd1());
		
		
		
		//add to cart is displayed or not
		softassertobj.assertEquals(accessoriesPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed",true);
		
		//add to cart is enabled or not
		softassertobj.assertEquals(accessoriesPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled",true);
		
		
		clickOnElement(accessoriesPageobj.getAddToCart());
		Reporter.log("All Accessories products Verified .......",true);
	}
	
	

}
