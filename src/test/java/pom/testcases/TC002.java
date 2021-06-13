package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers {
	
	@BeforeClass
	public void beforeCLass(){
		testCaseName="TC002";
		testCaseDescription="Lounge Booking";
		testCaseAutor="Basha";
		testCaseCategeory="Regression";
	}
	
	
	@Test
public void tc002(){
	
	new HomePage(driver, test)
	.covid19Alert()
	.clickOnHolidays()
	.clickOnStays();
	/*.clickOnLounge()
	//.sWindow()
	.selectStationName("")
	.selectLounge("")
	.selectPersons("")
	.selectCheckDate()
	.selectCheckTime("")
	.selectDuration("")
	.clickOnBook()
	.clickOnGuestUserLogin()
	.enterGmailId("")
	.enterPhoneNumber("")
	.clickOnLogin()
	.enterPassengerDetails("", "", "", "", "", "")
	.selectState("")
	.clickOnSubmit()
	.verifyEmail("")
	.verifyPhoneNumber("")
	.getAndPrintAmount().
	clickOnMakePayment().
	getTransactionId().
	closeApplication();*/
}
}
