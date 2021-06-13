package irctc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	
	
	@FindBy(xpath="/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")
	private WebElement covid19Alert;
	
	public HomePage(RemoteWebDriver driver , ExtentTest test){
		this.driver=driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage covid19Alert(){
		clickByXpath(covid19Alert);
		return this;
	}
	
	public RegistrationPage clickOnRegister(){
		clickByXpath("");
		return new RegistrationPage();
	}
	
	public HomePage clickOnTrain(){
		clickByXpath("");
		return this;
	}
	public FTRService clickOnFTRService(){
		clickByXpath("");
		return new FTRService();
	}
	public HomePage clickOnHolidays(){
		clickByXpath(objProp.getProperty("HomePage.clickOnHolidays"));
		return this;
	}
	public HomePage clickOnStays(){
		clickByXpath(objProp.getProperty("HomePage.clickOnStays"));
		return this;
	}
	public LoungePage clickOnLounge(){
		clickByXpath("");
		return new LoungePage();
	}
	public HotelsPage clickOnHotels(){
		clickByXpath("");
		return new HotelsPage();
	}
}


