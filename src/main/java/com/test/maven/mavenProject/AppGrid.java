package com.test.maven.mavenProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class AppGrid {
	public static void main(String[] args) throws MalformedURLException {
		AppGrid ref = new AppGrid();
		ref.setup();

		String bro=	ref.capabilities.getCapability("browserName").toString();
		System.out.println(bro);
		
		LoginClass log = new LoginClass(ref.driver);
		log.login();

		
	}

	WebDriver driver;
	DesiredCapabilities capabilities ;
	public void setup() throws MalformedURLException {
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		capabilities= new DesiredCapabilities();
		//capabilities.setBrowserName("internet explorer");
		capabilities.setBrowserName("internet explorer");

		
		//capabilities.setBrowserName("internet explorer");
		
		driver  = new RemoteWebDriver(new URL("http://192.168.0.5:4444/wd/hub"), capabilities);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void teardown() {

		driver.quit();
	}
}
