package irctc.pages;

import wrappers.GenericWrappers;

public class LoungePage extends GenericWrappers{
public LoungePage selectStationName(String Sname){
	selectVisibileTextById("", Sname);
	return this;
}
public LoungePage selectLounge(String Lounge){
	selectVisibileTextById("", Lounge);
	return this;
}
public LoungePage selectPersons(String Persons){
	selectVisibileTextById("", Persons);
	return this;
}

public LoungePage selectCheckDate(){
	clickByXpath("");
	clickByXpath("");
	return this;
}
public LoungePage selectCheckTime(String Time){
	
	selectVisibileTextByXpath("", "//option[text()='"+Time+"']");
	return this;
}
public LoungePage selectDuration(String Duration){
	
	selectVisibileTextByXpath("", "//option[text()='"+Duration+"']");
	return this;
}
public LoungePage clickOnBook(){
	
	clickByXpath("");
	return this;
}
public LoungePage sWindow(){
	switchToLastWindow();
	return this;
}
public LoungePage clickOnGuestUserLogin(){
	
	clickByXpath("");
	return this;
}

public LoungePage enterGmailId(String Gmail){
	
	enterByXpath("", Gmail);
	return this;
}
public LoungePage enterPhoneNumber(String Number){
	
	enterByXpath("", Number);
	return this;
}

public LoungePage clickOnLogin(){
	
	clickByXpath("");
	return this;
}

public LoungePage SwitchWindow(){
	
	switchToLastWindow();
	return this;
}
public LoungePage enterPassengerDetails(String Name1,String Age1,String Gender1,String Gender2 ,String Name2,String Age2){
	
	enterByXpath("", Name1);
	enterByXpath("", Age1);
	selectVisibileTextByXpath("", Gender1);
	enterByXpath("", Name2);
	enterByXpath("", Age2);
	selectVisibileTextByXpath("", Gender2);
	return this;
}

public LoungePage selectState(String State){
	
	
	selectVisibileTextByXpath("","//option[text()='"+State+"']");
	
	return this;
	
}
public LoungePage clickOnSubmit(){
	
	
	clickByXpath("");
	
	return this;
	
}
public LoungePage verifyEmail(String Email){
	verifyTextByXpath("", Email);
	return this;
	
}
public LoungePage verifyPhoneNumber(String Pnumber){
	verifyTextByXpath("", Pnumber);
	return this;
	
}

public LoungePage getAndPrintAmount(){
	getTextAndPrint("");
	return this;
	
}
public LoungePage clickOnAgree(){
	clickByXpath("");
	return this;
	
}
public LoungePage clickOnMakePayment(){
	clickByXpath("");
	return this;
	
}
public LoungePage getTransactionId(){
	getTextByAttributeAndPrint("");
	return this;
	
}

public LoungePage closeApplication(){
	closeAllBrowsers();
	return this;
	
}



}
