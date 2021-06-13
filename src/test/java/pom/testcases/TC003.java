package pom.testcases;

import irctc.pages.HomePage;

public class TC003 {
public void test(){
	new HomePage()
	.covid19Alert()
	.clickOnTrain()
	.clickOnFTRService()
	.clickOnNewUser()
	.enterUserID("")
	.enterEPassword("")
	.enterCPassword("")
	.selectSeqQun("")
	.selectSAns("")
	
	.selectDateOfBirth("", "")
	.chooseGender()
	.selectMartialStatus()
	.enterFirstName("")
	.enterMname("")
	.enterLname("");
	
	
}
}
