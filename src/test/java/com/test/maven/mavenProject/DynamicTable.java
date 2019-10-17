package com.test.maven.mavenProject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTable {

	WebDriver driver;

	@Test
	public void ActUsingTagname() {
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		

		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		
		for (int i = 1; i < rows.size(); i++) {
			
			WebElement nameElement=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
			System.out.println(nameElement.getText());
			
			if("John Smith".equals(nameElement.getText()))
			{
				WebElement radio=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
				radio.click();
			}
			
		}
		
		WebElement deleteBtn=driver.findElement(By.id("btnDelete"));
		deleteBtn.click();
		
		WebElement deleteBtn1=driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']"));
		deleteBtn1.click();
		}
		
		
	

	

	@BeforeTest
	public void bt() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
 
		
		Thread.sleep(5000);
		driver.quit();
	}

}
