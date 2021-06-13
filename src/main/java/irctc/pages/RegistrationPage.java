package irctc.pages;

import wrappers.GenericWrappers;

public class RegistrationPage extends GenericWrappers{

	
	public RegistrationPage enterUserName(String userName){
		enterByXpath("", userName);
		return this;
	}
	
	public RegistrationPage enterPassword(String password){
		enterByXpath("", password);
		return this;
	}
	public RegistrationPage enterConfirmPassword(String Cpassword){
		enterByXpath("", Cpassword);
		return this;
	}
	public RegistrationPage preffredLounage(){
		clickByXpath("");
		clickByXpath("");
		return this;

	}
	
	public RegistrationPage securityQuestion(){
		clickByXpath("");
		clickByXpath("");
		return this;

	}
	public RegistrationPage securityAns(String ans){
		enterByXpath("", ans);
		return this;
	}
	
	public RegistrationPage clickOnContinue(){
		clickByXpath("");
		return this;
	}
	public RegistrationPage firstName(String Fname){
		enterByXpath("", Fname);
		return this;
	}
	public RegistrationPage middleName(String Mname){
		enterByXpath("", Mname);
		return this;
	}
	public RegistrationPage lastName(String Lname){
		enterByXpath("", Lname);
		return this;
	}
	
	public RegistrationPage clickOnOccupation(){
		clickByXpath("");
		clickByXpath("");
		return this;

	}
	public RegistrationPage selectDateOfBirth(String Month, String Year, String date){
		clickByXpath("");
		selectVisibileTextById("", Month);
		selectVisibileTextById("", Year);
		clickByXpath("//a[text()='"+date+"']");
		return this;

	}
	
	public RegistrationPage marriageStatus(){
		clickByXpath("");
		return this;
	}
	
	public RegistrationPage selectGender(){
		clickByXpath("");
		return this;
	}
	public RegistrationPage enterEmail(String Email){
		enterByXpath("", Email);
		return this;
	}
	public RegistrationPage enterPhoneNumber(String Pnumber){
		enterByXpath("", Pnumber);
		return this;
	}
	
	public RegistrationPage clickOnContinue2(){
		clickByXpath("");
		return this;
	}
	
	public RegistrationPage enterHouseNumber(String Hnumber){
		enterByXpath("", Hnumber);
		return this;
	}
	public RegistrationPage enterAddress(String Address){
		enterByXpath("", Address);
		return this;
	}
	public RegistrationPage enterPincode(String Pincode){
		enterByXpath("", Pincode);
		return this;
	}
	
	public RegistrationPage enterVillageName(String Village){
		enterByXpath("", Village);
		return this;
	}
	
	public RegistrationPage selectDistrict(String District){
		selectVisibileTextByXpath("", District);
		return this;
	}
	
	public RegistrationPage selectPostOffice(String Poffice){
		selectVisibileTextByXpath("", Poffice);		
		return this;
	}
	
	public RegistrationPage enterRPhone(String Rphone){
		enterByXpath("", Rphone);
		return this;
	}
	
	public RegistrationPage clickOnCopyResidencetoofficeAddress(){
		clickByXpath("");
		return this;
	}
	public RegistrationPage enterOfficeNumber(String Onumber){
		enterByXpath("", Onumber);
		return this;
	}
	public RegistrationPage selectCountry(){
		clickByXpath("");
		clickByXpath("");
		return this;
	}
	public RegistrationPage enterOAddress(String OAddress){
		enterByXpath("", OAddress);
		return this;
	}
	public RegistrationPage enterOPincode(String OPincode){
		enterByXpath("", OPincode);
		return this;
	}	
	public RegistrationPage selectODistrict(String ODistrict){
		selectVisibileTextByXpath("", ODistrict);
		return this;
	}
	
	public RegistrationPage selectOPostOffice(String OPoffice){
		selectVisibileTextByXpath("", OPoffice);		
		return this;
	}
	public RegistrationPage enterOPhoneNumber(String OPNumber){
		enterByXpath("",OPNumber);
		return this;
	}	
	public RegistrationPage closeApplication(){
		closeAllBrowsers();
		return this;
	}	
	
}


