package com.test.maven.mavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumStart {

	public static void main(String[] args) throws InterruptedException {

		SeleniumStart ref = new SeleniumStart();

		ref.setUp();

		LoginClass log = new LoginClass(ref.driver);
		log.login();

		

		ref.tearDown();

	}

	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();

	}

	public void tearDown() {

		 driver.quit();

	}

}
