package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.HTMLReporter;

public class GenericWrappers extends HTMLReporter implements Wrappers {
	public RemoteWebDriver driver;
	public static Properties objProp;
	
	public void loadObjects(){
		
		 objProp = new Properties();
		try {
			objProp.load(new FileInputStream("./src/test/java/suportFiles/Object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void invokeApp(String browser, String url, boolean flag) {

		try {
			
			if(flag){
				
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName(browser);
				dc.setPlatform(Platform.WINDOWS);
				
				driver=new RemoteWebDriver(new URL("http://192.168.29.77:4444/wd/hub"), dc);
				
			}else{
				if (browser.equalsIgnoreCase("Chrome")) {
			
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.Internetexplorer.driver", "./Drivers/IEdriver.exe");
				driver = new InternetExplorerDriver();
			}
			}
			driver.manage().window().maximize();
			driver.get(url);
			
			//System.out.pr0intln("The browser launched successfully");
			logStatus("pass", "The browser launched successfully");
		} catch (NoSuchSessionException e) {
			logStatus("fail", "The browser is not launched bacuse of NoSuchSession Exception");
			//System.err.println("The browser is not launched bacuse of NoSuchSession Exception");
		} catch (TimeoutException e) {
			logStatus("fail", "The application is not opened in the browser.");
			//System.err.println("The application is not opened in the browser.");
		} catch (WebDriverException e) {
			logStatus("fail", "Browser is not launched because of webdriver exception");
			//System.err.println("Browser is not launched because of webdriver exception");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).sendKeys(data);
			logStatus("pass", "The data " + data + " is entered successfully in the element with locator " + idValue);
			//System.out.println("The data " + data + " is entered successfully in the element with locator " + idValue);
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + idValue + " is not available in the DOM");
			//System.err.println("The locator " + idValue + " is not available in the DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The element with locator " + idValue + " is not available in the Application");
			//System.err.println("The element with locator " + idValue + " is not available in the Application");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element with locator " + idValue + " is not interactable");
			//System.err.println("The element with locator " + idValue + " is not interactable");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The element with locator " + idValue + " is not stable to enter the data");
			//System.err.println("The element with locator " + idValue + " is not stable to enter the data");
		} catch (WebDriverException e) {
			logStatus("fail", "The element with locator " + idValue + " is not entered the data because of webdriverexception");
			//System.err.println(
					//"The element with locator " + idValue + " is not entered the data because of webdriverexception");
		}

	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			logStatus("pass", "The data " + data + " is entered successfully in the element with locator " + nameValue);
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + nameValue + " is not found in DOM");
			//System.err.println("The locator " + nameValue + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The locator " + nameValue + "is not found in appilicatio0n");
			//System.err.println("The locator " + nameValue + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + nameValue + " is not stable to enterthe data");
			//System.err.println("The locator " + nameValue + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element" + nameValue + " is not to trace");
			//System.err.println("The element" + nameValue + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + data + " is not entered because of webdriver exception");
			//System.err.println("The element" + data + " is not entered because of webdriver exception");
		}

	}

	public void enterByXpath(String xpathValue, String data) {
		
		try {
		driver.findElementByXPath(xpathValue).sendKeys(data);
		logStatus("pass", "The data " + data + " is entered successfully in the element with locator " + xpathValue);
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + xpathValue + " is not found in DOM");
			//System.err.println("The locator " + xpathValue + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The locator " + xpathValue + "is not found in appilicatio0n");
			//System.err.println("The locator " + xpathValue + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + xpathValue + " is not stable to enterthe data");
			//System.err.println("The locator " + xpathValue + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element" + xpathValue + " is not to trace");
			//System.err.println("The element" + xpathValue + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + data + " is not entered because of webdriver exception");
			//System.err.println("The element" + data + " is not entered because of webdriver exception");
		}
	}

	public void verifyTitle(String title) {
		try {
			String str = driver.getTitle();
			if (str.equalsIgnoreCase(title)) {
				logStatus("pass", "The String title is matching with the expected");
				//System.out.println("The String title is matching with the expected");
			} else {
				logStatus("pass", "The String title does not meet the expected output");
				//System.err.println("The String title does not meet the expected output");
			}
		} catch (NoSuchSessionException e) {
			logStatus("fail", "The seesion is not available in appilication");
			//System.err.println("The seesion is not available in appilication");
		} catch (TimeoutException e) {
			logStatus("fail", "The title is not loading in the given Time");
			//System.err.println("The title is not loading in the given Time");
		} catch (WebDriverException e) {
			logStatus("fail", "Not able to get the title due to webDriver exception");
			//System.err.println("Not able to get the title due to webDriver exception");
		}
	}

	public void verifyTextById(String id, String text) {
 try {
	String str1 = driver.findElement(By.id(id)).getText();
	 if(str1.equalsIgnoreCase(text)){
		 logStatus("pass", "The text is matching with the expected");
		 //System.out.println("The text is matching with the expected");
	 }else{
		 logStatus("pass", "The text is not matching with the expected");
		// System.out.println("The text is not matching with the expected");
	 }
} catch (NoSuchElementException e) {
	logStatus("fail", "The locator " + id + " is not found in DOM");
	//System.err.println("The locator " + id + " is not found in DOM");
} catch (ElementNotVisibleException e) {
	logStatus("fail", "The locator " + id + "is not found in appilicatio0n");
	//System.err.println("The locator " + id + "is not found in appilicatio0n");
} catch (StaleElementReferenceException e) {
	logStatus("fail", "The locator " + id + " is not stable to enterthe data");
	//System.err.println("The locator " + id + " is not stable to enterthe data");
} catch (ElementNotInteractableException e) {
	logStatus("fail", "The element" + id + " is not to trace");
	//System.err.println("The element" + id + " is not to trace");
} catch (WebDriverException e) {
	logStatus("fail", "The element" + id + " is not entered because of webdriver exception");
	//System.err.println("The element" + id + " is not entered because of webdriver exception");
}

	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String str2 = driver.findElement(By.xpath(xpath)).getText();
			 if(str2.equalsIgnoreCase(text)){
				 //System.out.println("The text is matching with the expected");
				 logStatus("pass", "The text is matching with the expected");

			 }else{
				// System.out.println("The text is not matching with the expected");
				 logStatus("pass", "The text is not matching with the expected");

			 }
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + xpath + " is not found in DOM");
			//System.err.println("The locator " + xpath + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + xpath + "is not found in appilicatio0n");
			//System.err.println("The locator " + xpath + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + xpath + " is not stable to enterthe data");
			//System.err.println("The locator " + xpath + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + xpath + " is not to trace");
			//System.err.println("The element" + xpath + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + xpath + " is not entered because of webdriver exception");
			//System.err.println("The element" + xpath + " is not entered because of webdriver exception");
		}

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String str2 = driver.findElement(By.xpath(xpath)).getText();
			 if(str2.contains(text)){
				 logStatus("pass", str2+" contains the text"+text);
				// System.out.println(str2+" contains the text"+text);
			 }else{
				 logStatus("pass", str2+" not contains the text"+text);
				 //System.out.println(str2+" not contains the text"+text);
			 }
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + xpath + " is not found in DOM");
			//System.err.println("The locator " + xpath + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + xpath + "is not found in appilicatio0n");
			//System.err.println("The locator " + xpath + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + xpath + " is not stable to enterthe data");
			//System.err.println("The locator " + xpath + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element" + xpath + " is not to trace");
			//System.err.println("The element" + xpath + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + xpath + " is not entered because of webdriver exception");
			//System.err.println("The element" + xpath + " is not entered because of webdriver exception");
		}

	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			logStatus("pass","The locater "+id+"is found and perfomed click operation");
			//System.out.println("The locater "+id+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + id + " is not found in DOM");
			//System.err.println("The locator " + id + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The locator " + id + "is not found in appilicatio0n");
			//System.err.println("The locator " + id + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + id + " is not stable to enterthe data");
			//System.err.println("The locator " + id + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			
			logStatus("fail", "The element" + id + " is not to trace");
			//System.err.println("The element" + id + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + id + " is not entered because of webdriver exception");
			//System.err.println("The element" + id + " is not entered because of webdriver exception");
		}

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			logStatus("pass", "The locater "+classVal+"is found and perfomed click operation");

			//System.out.println("The locater "+classVal+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			logStatus("fail", "The locator " + classVal + " is not found in DOM");

//			System.err.println("The locator " + classVal + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The locator " + classVal + "is not found in appilicatio0n");

			//System.err.println("The locator " + classVal + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + classVal + " is not stable to enterthe data");

			//System.err.println("The locator " + classVal + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element" + classVal + " is not to trace");

			//System.err.println("The element" + classVal + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + classVal + " is not entered because of webdriver exception");

			//System.err.println("The element" + classVal + " is not entered because of webdriver exception");
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			logStatus("pass", "The locater "+name+"is found and perfomed click operation");
			//System.out.println("The locater "+name+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + name + " is not found in DOM");
			//System.err.println("The locator " + name + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail", "The locator " + name + "is not found in appilicatio0n");
			//System.err.println("The locator " + name + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail", "The locator " + name + " is not stable to enterthe data");
			//System.err.println("The locator " + name + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail", "The element" + name + " is not to trace");
			//System.err.println("The element" + name + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail", "The element" + name + " is not entered because of webdriver exception");
			//System.err.println("The element" + name + " is not entered because of webdriver exception");
		}

	}

	public void clickByLink(String name) {
		driver.findElementByLinkText(name).click();
		logStatus("pass","The locater "+name+"is found and perfomed click operation");

		System.out.println("The locater "+name+"is found and perfomed click operation");
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			logStatus("pass","The locater "+xpathVal+"is found and perfomed click operation");
			//System.out.println("The locater "+xpathVal+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + xpathVal + " is not found in DOM");
			//System.err.println("The locator " + xpathVal + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + xpathVal + "is not found in appilicatio0n");
			//System.err.println("The locator " + xpathVal + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + xpathVal + " is not stable to enterthe data");
			//System.err.println("The locator " + xpathVal + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + xpathVal + " is not to trace");
			//System.err.println("The element" + xpathVal + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + xpathVal + " is not entered because of webdriver exception");
			//System.err.println("The element" + xpathVal + " is not entered because of webdriver exception");
		}

	}

	
	public void clickByXpath(WebElement xpathVal) {
		try {
			xpathVal.click();
			logStatus("pass","The locater "+xpathVal+"is found and perfomed click operation");
			//System.out.println("The locater "+xpathVal+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + xpathVal + " is not found in DOM");
			//System.err.println("The locator " + xpathVal + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + xpathVal + "is not found in appilicatio0n");
			//System.err.println("The locator " + xpathVal + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + xpathVal + " is not stable to enterthe data");
			//System.err.println("The locator " + xpathVal + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + xpathVal + " is not to trace");
			//System.err.println("The element" + xpathVal + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + xpathVal + " is not entered because of webdriver exception");
			//System.err.println("The element" + xpathVal + " is not entered because of webdriver exception");
		}

	}

	
	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub

	}

	public String getTextById(String idVal) {
		String str5 = "";
		try {
			 str5 = driver.findElement(By.id(idVal)).getText();
			 logStatus("pass","The locator " + idVal + " is  found in DOM");
			
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + idVal + " is not found in DOM");
			//System.err.println("The locator " + idVal + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + idVal + "is not found in appilicatio0n");
			//System.err.println("The locator " + idVal + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + idVal + " is not stable to enterthe data");
			//System.err.println("The locator " + idVal + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + idVal + " is not to trace");
			//System.err.println("The element" + idVal + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + idVal + " is not entered because of webdriver exception");
			//System.err.println("The element" + idVal + " is not entered because of webdriver exception");
		}	
		 return str5;
		}

	public String getTextByXpath(String xpathVal) {
String str6 ="";

try {
	str6= driver.findElement(By.xpath(xpathVal)).getText();
	System.out.println(str6);
	logStatus("pass","The locator " + xpathVal + " is  found in DOM");
			
} catch (NoSuchElementException e) {
	logStatus("fail","The locator " + xpathVal + " is not found in DOM");
	//System.err.println("The locator " + xpathVal + " is not found in DOM");
} catch (ElementNotVisibleException e) {
	logStatus("fail","The locator " + xpathVal + "is not found in appilicatio0n");
	//System.err.println("The locator " + xpathVal + "is not found in appilicatio0n");
} catch (StaleElementReferenceException e) {
	logStatus("fail","The locator " + xpathVal + " is not stable to enterthe data");
	//System.err.println("The locator " + xpathVal + " is not stable to enterthe data");
} catch (ElementNotInteractableException e) {
	logStatus("fail","The element" + xpathVal + " is not to trace");
	//System.err.println("The element" + xpathVal + " is not to trace");
} catch (WebDriverException e) {
	logStatus("fail","The element" + xpathVal + " is not entered because of webdriver exception");
	//System.err.println("The element" + xpathVal + " is not entered because of webdriver exception");
}	
return str6;

	}

	public void selectVisibileTextById(String id, String value) {
		//driver.findElementById(using)
			try {
				WebElement we = driver.findElementById(id);
				Select se = new Select(we);
				se.selectByVisibleText(value);
				//logStatus("pass","The element" + xpathVal + " is not entered because of webdriver exception");
			} catch (NoSuchElementException e) {
				logStatus("fail","The locator " + id + " is not found in DOM");
				//System.err.println("The locator " + id + " is not found in DOM");
			} catch (ElementNotVisibleException e) {
				logStatus("fail","The locator " + id + "is not found in appilicatio0n");
				//System.err.println("The locator " + id + "is not found in appilicatio0n");
			} catch (StaleElementReferenceException e) {
				logStatus("fail","The locator " + id + " is not stable to enterthe data");
				//System.err.println("The locator " + id + " is not stable to enterthe data");
			} catch (ElementNotInteractableException e) {
				logStatus("fail","The element" + id + " is not to trace");
				//System.err.println("The element" + id + " is not to trace");
			} catch (WebDriverException e) {
				logStatus("fail","The element" + id + " is not entered because of webdriver exception");
				//System.err.println("The element" + id + " is not entered because of webdriver exception");
			}	

	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement we = driver.findElementById(id);
			Select se = new Select(we);
			se.selectByIndex(value);
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + id + " is not found in DOM");
			//System.err.println("The locator " + id + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + id + "is not found in appilicatio0n");
			//System.err.println("The locator " + id + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + id + " is not stable to enterthe data");
			//System.err.println("The locator " + id + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + id + " is not to trace");
			//System.err.println("The element" + id + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + id + " is not entered because of webdriver exception");
			//System.err.println("The element" + id + " is not entered because of webdriver exception");
		}	

	}

	
	public void selectIndexByXpath(String id, int value) {
		try {
			WebElement we = driver.findElementByXPath(id);
			Select se = new Select(we);
			se.selectByIndex(value);
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + id + " is not found in DOM");
			//System.err.println("The locator " + id + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + id + "is not found in appilicatio0n");
			//System.err.println("The locator " + id + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + id + " is not stable to enterthe data");
			//System.err.println("The locator " + id + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + id + " is not to trace");
			//System.err.println("The element" + id + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + id + " is not entered because of webdriver exception");
			//System.err.println("The element" + id + " is not entered because of webdriver exception");
		}	


	}

	public void switchToParentWindow() {
		Set<String> all = driver.getWindowHandles();
		for(String one:all){
			driver.switchTo().window(one);
			break;
			//how  to switch from 4th window to 2nd
		}

	}

	public void switchToLastWindow() {
		Set<String> all = driver.getWindowHandles();
		for(String one:all){
			driver.switchTo().window(one);
		
		}
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();;
	}

	public String getAlertText() {
		String atext = driver.switchTo().alert().getText();
		return atext;
	}

	public long takeSnap() {
		// TODO Auto-generated method stub
		
		long number = System.currentTimeMillis();
		
		try {
			File pic = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./reports/images/snap"+number+".jpg");
			FileUtils.copyFile(pic, dest);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return number;

	}

	public void closeBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();

	}
	
	public void waitTime(long time){
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void clickByCssSelector(String cssSelector) {
		try {
			driver.findElementByCssSelector(cssSelector).click();
			System.out.println("The locater "+cssSelector+"is found and perfomed click operation");
		} catch (NoSuchElementException e) {
			System.err.println("The locator " + cssSelector + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The locator " + cssSelector + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			System.err.println("The locator " + cssSelector + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element" + cssSelector + " is not to trace");
		} catch (WebDriverException e) {
			System.err.println("The element" + cssSelector + " is not entered because of webdriver exception");
		}
		
	}

	public void selectVisibileTextByXpath(String id, String value) {
		try {
			WebElement we = driver.findElementByXPath(id);
			Select se = new Select(we);
			se.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			logStatus("fail","The locator " + id + " is not found in DOM");
			//System.err.println("The locator " + id + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			logStatus("fail","The locator " + id + "is not found in appilicatio0n");
			//System.err.println("The locator " + id + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			logStatus("fail","The locator " + id + " is not stable to enterthe data");
			//System.err.println("The locator " + id + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			logStatus("fail","The element" + id + " is not to trace");
			//System.err.println("The element" + id + " is not to trace");
		} catch (WebDriverException e) {
			logStatus("fail","The element" + id + " is not entered because of webdriver exception");
			//System.err.println("The element" + id + " is not entered because of webdriver exception");
		}	
	
		
	}

	public void getTextAndPrint(String Xpath) {
		try {
			String str1 = driver.findElement(By.xpath(Xpath)).getText();
			System.out.println(str1);
			/*
			 if(str1.equalsIgnoreCase(text)){
				 System.out.println("The text is matching with the expected");
			 }else{
				 System.out.println("The text is not matching with the expected");
			 }*/
		} catch (NoSuchElementException e) {
			System.err.println("The locator " + Xpath + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The locator " + Xpath + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			System.err.println("The locator " + Xpath + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element" + Xpath + " is not to trace");
		} catch (WebDriverException e) {
			System.err.println("The element" + Xpath + " is not entered because of webdriver exception");
		}

		
	}

	public void getTextByAttributeAndPrint(String Xpath) {
		
		try {
			WebElement wee = driver.findElementByXPath(Xpath);
			String stt = wee.getAttribute("value");

			
				System.out.println("Transaction ID: " +stt);
			
			/*String str1 = driver.findElement(By.xpath(Xpath)).getText();
			System.out.println(str1);
			
			 if(str1.equalsIgnoreCase(text)){
				 System.out.println("The text is matching with the expected");
			 }else{
				 System.out.println("The text is not matching with the expected");
			 }*/
		} catch (NoSuchElementException e) {
			System.err.println("The locator " + Xpath + " is not found in DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The locator " + Xpath + "is not found in appilicatio0n");
		} catch (StaleElementReferenceException e) {
			System.err.println("The locator " + Xpath + " is not stable to enterthe data");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element" + Xpath + " is not to trace");
		} catch (WebDriverException e) {
			System.err.println("The element" + Xpath + " is not entered because of webdriver exception");
		}

		
	}

}
