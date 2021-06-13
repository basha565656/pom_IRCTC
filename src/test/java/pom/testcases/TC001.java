package pom.testcases;

import org.testng.annotations.Test;

import irctc.pages.HomePage;
import irctc.pages.RegistrationPage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers{

	@Test
	public void tc001(){
		
		new HomePage()
		.covid19Alert()
		.clickOnRegister()
		.enterUserName("Basha")
		.enterPassword("Basha6899")
		.enterConfirmPassword("Basha@6899");
		/*.securityQuestion()
		.preffredLounage()
		.securityAns("")
		.clickOnContinue()
		.firstName("")
		.middleName("")
		.lastName("")
		.clickOnOccupation()
		.selectDateOfBirth("", "", "")
		.selectGender()
		.marriageStatus()
		.enterEmail("")
		.enterPhoneNumber("")
		.clickOnContinue2()
		.enterHouseNumber("")
		.enterAddress("")
		.enterPincode("")
		.enterVillageName("")
		.selectDistrict("")
		.selectPostOffice("")
		.enterRPhone("")
		.clickOnCopyResidencetoofficeAddress()
		.enterOfficeNumber("").enterOAddress("").selectCountry().enterOPincode("").selectPostOffice("")
		.selectODistrict("").enterOAddress("").closeApplication();
		*/
	}
	
	
}
