package org.dwsapp.genericlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.dwsapp.pagerepository.AccessoriesPage;
import org.dwsapp.pagerepository.BookPage;
import org.dwsapp.pagerepository.CameraPhotoPage;
import org.dwsapp.pagerepository.CellPhonesPage;
import org.dwsapp.pagerepository.DesktopPage;
import org.dwsapp.pagerepository.LoginPage;
import org.dwsapp.pagerepository.NoteBookPage;
import org.dwsapp.pagerepository.ShoopingCartPage;
import org.dwsapp.pagerepository.WelcomePage;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



@Listeners(org.dwsapp.listenerlibrary.ListenerImplementation.class)
public class BaseConfig extends WebDriverLibrary {

	
	public PropertiesLibrary pl;
	public LoginPage lpobj;
	public WelcomePage wpobj;
	public CameraPhotoPage cameraPhotoPageobj;
	public CellPhonesPage cellPhonesPageobj;
	public BookPage bookpageobj;
	public DesktopPage desktopPageobj;
	public NoteBookPage noteBookPageobj;
	public SoftAssert softassertobj;
	public AccessoriesPage accessoriesPageobj;
	public ExcelLibrary excelLibraryobj;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public ShoopingCartPage shoopingCartPageobj;
	

@Parameters({"browser","url"})
@BeforeClass
public void browserSetup(String browser,String url)
{
	//step 1
	openBrowser(browser);
	Reporter.log("Step 1  : browser opened success",true);
	maximizeBrowser();
	
	waitStatement();
	
	//step2
	navigateToApplication(url);
	Reporter.log("Step 2  : navigated to application  success",true);
	
	
	Reporter.log("browser setup successfull",true);
	
	
	//p=new Products(driver);

}


@BeforeMethod
public void login()
{ 
	
	 pl=new PropertiesLibrary();
	waitStatement();

	 lpobj=new LoginPage(driver);
	wpobj=new WelcomePage(driver);
	
	
	//step 3.1
	clickOnElement(wpobj.getLogin());
	Reporter.log("Step 3.1  : Login hyperlink click - success",true);
  
	//step 3.2
    enterDataOnElements(lpobj.getEmail(), pl.readData("email"));
    Reporter.log("Step 3.2  : Email address data entered - success",true);
    
    //step 3.3
    enterDataOnElements(lpobj.getPassword(), pl.readData("password"));
    Reporter.log("Step 3.3  : Password data entered - success",true);
    
    //step 3.4
	clickOnElement(lpobj.getLoginButton());
	Reporter.log("Step 3.4 : Login button clicked - success",true);

	Reporter.log("login successfully",true);
	
}

@AfterMethod
public void logout()
{
	
	wpobj=new WelcomePage(driver);
	
	//step 10
	clickOnElement(wpobj.getLogoutButton());
	Reporter.log("Step 5  :  Logout Button clicked - success",true);
	
	Reporter.log("logout successfull",true);

}

@BeforeTest
public void reportSetup()
{
	  String cdate=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	     
	//create spark Report
	spark = new ExtentSparkReporter("./AdvanceReport/Index"+cdate+".html");
	
	//configure the SparkReport Information
	spark.config().setDocumentTitle("Regression Testing for the demoWebSHop");
	spark.config().setReportName("Regressionsuite");
	spark.config().setTheme(Theme.STANDARD);
	
	
	//create the extentReport
	report =new ExtentReports();
	
	//Attach the sparkreport and extentReport
	report.attachReporter(spark);
	
	//configure the system information in extentReport
	
	report.setSystemInfo("Device Name:", "deepak");
	report.setSystemInfo("operatingSystem:", "Windows11");
	report.setSystemInfo("Browser:","Chrome");
	report.setSystemInfo("BrowserVersion:","chrome-138");
	
}

@AfterTest
public void reportTerminate()
{
	//flush the report info
	report.flush();
}
@AfterClass
public void closeBrowser()
{
	//step 11
    closeAllBrowser();
    
	Reporter.log("browser closed successfull",true);
}
}
