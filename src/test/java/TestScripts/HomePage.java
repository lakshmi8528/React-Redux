package TestScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test
	
	public void basePageNavigation() throws IOException
	{

		//go to the page and verify the page is opened or not
		driver.get(prop.getProperty("url1"));
		LoginPage l=new LoginPage(driver); 
		//validate the title
		Assert.assertEquals(l.getLogin().getText(),"React Redux Grid");
		
	}

	@AfterTest
	public void teardown()
	{
		
		driver.close();	
		
	}	
	
}
