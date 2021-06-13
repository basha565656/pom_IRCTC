package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers{
	
	
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}
	
	
	@BeforeTest
	public void beforeTest(){
		loadObjects();	
	}
	
	@BeforeMethod
	public void openBrowser(){
		startTest(testCaseName, testCaseDescription);
		test.assignAuthor(testCaseAutor);
		test.assignCategory(testCaseCategeory);
		invokeApp("chrome", "https://www.irctc.co.in", true);
	}
	
	@AfterMethod
	public void closeApplication(){
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass(){
		endReport();
	}
	
	@AfterTest
	public void afterTest(){
		objProp=null;
	}
	
	@AfterSuite
	public void afterSuite(){
		endReport();
	}
	

}
