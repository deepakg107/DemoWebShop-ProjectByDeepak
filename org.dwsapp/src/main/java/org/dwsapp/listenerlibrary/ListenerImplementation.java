package org.dwsapp.listenerlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dwsapp.genericlibrary.WebDriverLibrary;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String cdate = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		String n = result.getName();

		// 1
		TakesScreenshot ts = (TakesScreenshot) WebDriverLibrary.stdriver;

		// 2
		File tempPath = ts.getScreenshotAs(OutputType.FILE);

		// 3
		File permanentPath = new File("./src/main/resources/TestScreenshot/" + n + cdate + ".png");

		// 4
		try {
			FileHandler.copy(tempPath, permanentPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Screen shot Taken Successfully");

	}

}
