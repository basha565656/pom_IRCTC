package utilities;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReporter {

	// 1. Excel Seet Path
	//2. Test Case Name, Test Case Description
	// 3. Test Step Status
	
	@Test
	public void sampleReport(){
		// 1. Start Report
		ExtentReports report = new ExtentReports("./reports/sampleReport.html");
		
		//2. Start Test
		ExtentTest test = report.startTest("Test Case Name", "Test CAse Description");
		
		test.assignAuthor("Selenium");
		test.assignCategory("Dry run");
		
		// 3. Log Status
		test.log(LogStatus.PASS, "Test Step Description");
		test.log(LogStatus.PASS, "Test Step Description");
		test.log(LogStatus.PASS, "Test Step Description");
		test.log(LogStatus.PASS, "Test Step Description");
		test.log(LogStatus.PASS, "Test Step Description");
		
		
		// 4. End Test
		report.endTest(test);
		
		//5. End Report
		report.flush();
		
		
	}
	
}
