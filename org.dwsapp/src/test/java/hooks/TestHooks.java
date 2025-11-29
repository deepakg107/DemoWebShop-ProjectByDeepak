package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHooks {
	
	public static WebDriver driver;
	@Before
	public void browserSetup()
	{
		System.out.println("[Hook] - starting browser setup");
		driver=new  ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@After
	public void browsertearDown()
	{
		
	}

}
