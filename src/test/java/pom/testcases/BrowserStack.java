package pom.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		  String USERNAME = "skbasha_F5ElKd";
		  String AUTOMATE_KEY = "cmagQMTZkagUR19ygptM";
		  String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  
		  
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("os", "Windows");
		dc.setCapability("os_version", "10");
		dc.setCapability("browser", "Chrome");
		dc.setCapability("browser_version", "89");
		dc.setCapability("name", "Basha's First Test");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL(url), dc);
		
		driver.get("https://irctc.co.in");
		
		System.out.println(driver.getTitle());

	}

}
