package irctc.pages;

import wrappers.GenericWrappers;

public class FTRService extends GenericWrappers{
	public FTRService clickOnNewUser(){
		clickByXpath("");
		return this;
	}	
	public FTRService enterUserID(String UserId){
		enterByXpath("", UserId);
		return this;
	}	
	public FTRService enterEPassword(String password){
		enterByXpath("", password);
		return this;
	}	
	public FTRService enterCPassword(String Cpassword){
		enterByXpath("", Cpassword);
		return this;
	}	
	
	public FTRService selectSeqQun(String SQun){
		selectVisibileTextByXpath("", SQun);
		return this;
	}	
	
	public FTRService selectSAns(String Sans){
		enterByXpath("", Sans);
		return this;
	}	
	public FTRService selectDateOfBirth(String Year,String Month){
		clickByXpath("");
		selectVisibileTextByXpath("", Year);
		selectVisibileTextByXpath("", Month);
		clickByXpath("");
		return this;
	}	
	public FTRService chooseGender(){
		clickByXpath("");
		return this;
	}	
	public FTRService selectMartialStatus(){
		clickByXpath("");
		return this;
	}	
	
	public FTRService enterEmail(String Email){
		enterByXpath("", Email);
		return this;
	}	
	public FTRService enterOccupation(String Occupation){
		enterByXpath("", Occupation);
		return this;
	}
	public FTRService enterFirstName(String Fname){
		enterByXpath("", Fname);
		return this;
	}
	
	public FTRService enterMname(String Mname){
		enterByXpath("", Mname);
		return this;
	}
	public FTRService enterLname(String Lname){
		enterByXpath("", Lname);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
