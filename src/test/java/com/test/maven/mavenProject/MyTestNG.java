package com.test.maven.mavenProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestNG {
  @Test
  public void a() 
  {
	  System.out.println("My Test NG");
	  
  }
  
  @Test
  public void d() 
  {
	  System.out.println("My Test NG1");
	  
  }
  
  @Test
  public void b() 
  {
	  System.out.println("My Test NG2");  //run alphabeticaly
	  
  }
  
  @Test(priority=1)
  public void x() 
  {
	//  System.out.println("priority=1");
	  
  }
  
  @Test(priority=0)
  public void y() 
  {
	  System.out.println("priority=0");
	  
  }
  
  @Test(priority=-1)  //negative priority does not run
  public void x1() 
  {
	  System.out.println("priority=-1");
	  
  }
  
  @BeforeTest
  public void l() 
  {
	  System.out.println("before test");
	  
  }
  
  
  @AfterTest
  public void m() 
  {
	  System.out.println("after test");
	  
  }
  
  @AfterMethod
  public void o() 
  {
	  System.out.println("After method");
	  
  }
  
  @BeforeMethod
  public void p() 
  {
	  System.out.println("Before method");
	  
  }
  
  
}
