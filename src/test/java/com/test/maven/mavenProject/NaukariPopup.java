package com.test.maven.mavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NaukariPopup {

	WebDriver driver;

	@Test
	public void windowhand() {
		String parentwindow = driver.getWindowHandle();

		Set<String> allwindow = driver.getWindowHandles();

		for (String win : allwindow) {

			driver.switchTo().window(win);
			System.out.println(driver.getTitle());

			if (!win.equals(parentwindow))

				driver.close();

		}
		
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//button[text()='Search Walk-in Jobs']")).click();
		
		
		
		Set<String> newallwindow = driver.getWindowHandles();

		for (String newwin : newallwindow) {

			driver.switchTo().window(newwin);
			System.out.println(driver.getTitle());

			if (newwin.equals(parentwindow))

				driver.close();

		}
		
		
		driver.findElement(By.xpath("//button[@id='qsbFormBtn']")).click();

	}

	@BeforeTest
	public void bt() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
 
		
		Thread.sleep(5000);
		driver.quit();
	}

}
