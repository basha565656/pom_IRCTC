package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class HTMLReporter {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	public String testCaseName, testCaseDescription, testCaseAutor, testCaseCategeory;
	
	public void startReport(){
		
		 report = new ExtentReports("./reports/report.html");
		
	}
	
	public void startTest(String testName, String description){
		 test = report.startTest(testName, description);
	}
	
	public void logStatus(String status, String desc){
		
		long number = takeSnap();
		
		String path = System.getProperty("user.dir")+"/reports/images/snap"+number+".jpg";
		
		if(status.equalsIgnoreCase("pass")){
			test.log(LogStatus.PASS, desc+test.addScreenCapture(path));
		}else if(status.equalsIgnoreCase("fail")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(path));
		}
		
	}
	
	public void endTest(){
		report.endTest(test);
	}
	
	public void endReport(){
		report.flush();
	}
	
	public abstract long takeSnap();

}
