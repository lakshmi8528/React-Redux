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
import pageObjects.reactReduxComplex;
import resources.base;

public class validateCheckallcheckbox_Complex extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	//login to Complex page and validate the heading
	@Test
	
	public void basePagNavigation() throws IOException
	{

		
		driver.get(prop.getProperty("url2"));
		LoginPage l=new LoginPage(driver); 
		Assert.assertEquals(l.getLogin().getText(),"React Redux Grid");
		
	}
		//call the checkallcheckbox from reactReduxTree.java page 
	@Test
	public void validatecheckbox() throws IOException, InterruptedException
	{
		reactReduxComplex rt=new reactReduxComplex(driver);
		rt.checkallcheckbox();
	}

	@AfterTest
	public void teardown()
	{
		
		driver.close();	
		
	}	
	
}
