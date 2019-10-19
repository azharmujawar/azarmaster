package com.test.maven.mavenProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class LoginClass {

	
	
	
	@FindBy(xpath="//a[text()='Login & Signup']")
	WebElement loginextra;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement loctorUsername;

	@FindBy(xpath = "//input[@type='password']")
	WebElement loctorPassword;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement loctorloginButn;

	WebDriver driver;

	public LoginClass(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
	}

	public void login() {

		// WebElement username=
		// driver.findElement(By.xpath("//span[text()='Enter Email/Mobile
		// number']//preceding::input[1]"));

		
		/*try{
			
			loginextra.click();
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to Click ");
		}
		*/
		
		
		loctorUsername.sendKeys("azhar123@gmail.com");

		loctorPassword.sendKeys("azharpune");

		loctorloginButn.click();
	}
}
