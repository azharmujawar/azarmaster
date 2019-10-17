package com.test.maven.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class TestNGBrowser {
	WebDriver driver;
  @Test
  public void f() {
	  
	  LoginClass log = new LoginClass(driver);
		log.login();
		
		
  }
  
  @Parameters("bro")
  @BeforeTest
  public void beforeTest( String xyz) {
	  
	  if(xyz.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
		  
	  } else if(xyz.equals("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	  } else if(xyz.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
	  }
	  
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }
  
  

}
