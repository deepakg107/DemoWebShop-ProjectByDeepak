package org.dwsapp.producttest;

import org.dwsapp.genericlibrary.BaseConfig;
import org.dwsapp.pagerepository.CameraPhotoPage;
import org.dwsapp.pagerepository.CellPhonesPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Electronics extends BaseConfig{

	@Test(groups = "ft",priority = 2,enabled = true)
	public void verifyCamera()
	{

		//create the Test Information
		test=report.createTest("verify Cameraproduct 1");

			//steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO,"step 2: navigating to application via url successfull");
		test.log(Status.INFO, "step3: verified page successfull");

		//step 6.1................
		waitStatement();
		 cameraPhotoPageobj=new CameraPhotoPage(driver);

		 //ElectronicsHover is displayed or not
		 Assert.assertEquals(cameraPhotoPageobj.getElectronicsHover().isDisplayed(), true);
		 Reporter.log("ElectronicsHover is displayed ",true);

		 //ElectronicsHover is enabled or not
		 Assert.assertEquals(cameraPhotoPageobj.getElectronicsHover().isEnabled(), true);
		 Reporter.log("ElectronicsHover is enabled ",true);


		mouseHoverToElement(cameraPhotoPageobj.getElectronicsHover());


		// cameraPhoto is displayed or not
		 Assert.assertEquals(cameraPhotoPageobj.getCameraPhoto().isDisplayed(), true);
		 Reporter.log("cameraPhoto is displayed ",true);

		// cameraPhoto is enabled or not
		 Assert.assertEquals(cameraPhotoPageobj.getCameraPhoto().isEnabled(), true);
		 Reporter.log("cameraPhoto is enabled ",true);



		clickOnElementUsingActionsClass(cameraPhotoPageobj.getCameraPhoto());



		// cameraPhoto product is selected or not
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed(), true);
		 //Reporter.log("cameraPhoto product is displayed",true);

		// cameraPhoto product is enabled or not
		Assert.assertEquals(cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled(), true);
		 //Reporter.log("cameraPhoto product is enabled ",true);

		//step2 : click on "Demo web Shop book product in books page
		 Assert.assertTrue(cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed());
	      Assert.assertTrue(cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled());


		 if(cameraPhotoPageobj.getCameraPhotoProduct1().isDisplayed() && cameraPhotoPageobj.getCameraPhotoProduct1().isEnabled())
		 {
			 test.log(Status.PASS, "step4: Verified the cameraProduct is displayed and enabled");
		 }
		 else
		 {
			 test.log(Status.FAIL, "step4: verified the cameraProduct is Not displayed and not enabled");
		 }

		clickOnElement(cameraPhotoPageobj.getCameraPhotoProduct1());


		//add to cart is displayed or not
		Assert.assertEquals(cameraPhotoPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed",true);

		//add to cart is enabled or not
		Assert.assertEquals(cameraPhotoPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled",true);


		clickOnElement(cameraPhotoPageobj.getAddToCart());
		Reporter.log("ElectronicsTest-Camera products verified",true);
	}




	@Test(groups = "rt",priority = 1,enabled = true)
	public void verifyCellPhones()
	{

		//create the Test Information
		test=report.createTest("verify CellPhoneproduct 1");

					//steps Information
		test.log(Status.INFO, "Step 1: launching the browser");
		test.log(Status.INFO,"step 2: navigating to application via url successfull");
     	test.log(Status.INFO, "step3: verified page successfull");





	//step 6.2........................
		waitStatement();
		cellPhonesPageobj=new CellPhonesPage(driver);


		//ElectronicsHover is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getElectronicsHover().isDisplayed(), true);
		Reporter.log("ElectronicsHover is displayed ",true);

		//ElectronicsHover is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getElectronicsHover().isEnabled(), true);
		Reporter.log("ElectronicsHover is enabled ",true);



		mouseHoverToElement(cellPhonesPageobj.getElectronicsHover());


		//cell phone is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhone().isDisplayed(), true);
		Reporter.log("cell phone is displayed ",true);

		//cell phone is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhone().isEnabled(), true);
		Reporter.log("cell phone is enabled ",true);


		clickOnElementUsingActionsClass(cellPhonesPageobj.getCellPhone());



		//cell phone product is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhoneProduct1().isDisplayed(), true);
		//Reporter.log("cell phone product  is displayed ",true);

		//cell phone product is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getCellPhoneProduct1().isEnabled(), true);
		//Reporter.log("cell phone product is enabled ",true);
		//step2 : click on "Demo web Shop book product in books page
		Assert.assertTrue(cellPhonesPageobj.getCellPhoneProduct1().isDisplayed());
        Assert.assertTrue(cellPhonesPageobj.getCellPhoneProduct1().isEnabled());

		if(cellPhonesPageobj.getCellPhoneProduct1().isDisplayed() && cellPhonesPageobj.getCellPhoneProduct1().isEnabled())
		 {
			 test.log(Status.PASS, "step4: Verified the cellPhoneProduct is displayed and enabled");
		 }
		 else
		 {
			 test.log(Status.FAIL, "step4: verified the cellPhoneProduct is Not displayed and not enabled");
		 }


		clickOnElement(cellPhonesPageobj.getCellPhoneProduct1());


		//add to cart is displayed or not
		Assert.assertEquals(cellPhonesPageobj.getAddToCart().isDisplayed(), true);
		Reporter.log("add to cart is displayed",true);

		//add to cart is enabled or not
		Assert.assertEquals(cellPhonesPageobj.getAddToCart().isEnabled(), true);
		Reporter.log("add to cart is enabled",true);


		clickOnElement(cellPhonesPageobj.getAddToCart());

		Reporter.log("Cell phones products verified",true);
	}
}
