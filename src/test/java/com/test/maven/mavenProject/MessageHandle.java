package com.test.maven.mavenProject;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MessageHandle {

	WebDriver driver;

	@Test
	public void windowhand() throws InterruptedException {
	
		WebElement end=driver.findElement(By.xpath("//a[text()='English']"));
		end.click();
		
		Thread.sleep(1000);
		
		WebElement first=driver.findElement(By.xpath("//a[text()='Case Status']"));
		
		WebElement second=driver.findElement(By.xpath("//a[text()='Filing Number']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(first).pause(Duration.ofSeconds(2)).moveToElement(second).click().build().perform();

		Alert alt=driver.switchTo().alert();
		alt.accept();
		
		WebElement selectDistrict=driver.findElement(By.id("sess_dist_code"));
		
		Select sel=new Select(selectDistrict);
		
	//sel.selectByVisibleText("Beed-बीड ");
		
		
		sel.selectByIndex(26);
		Thread.sleep(1000);
		
		sel.selectByValue("10");
		Thread.sleep(1000);
		
		second.click();
	}

	@BeforeTest
	public void bt() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("https://court.mah.nic.in/courtweb/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
 
		
		Thread.sleep(5000);
		driver.quit();
	}

}
