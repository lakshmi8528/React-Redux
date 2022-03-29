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
import pageObjects.reactReduxTree;
import resources.base;

public class validateDragandDrop_Tree extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	//login to Tree page and validate the heading
	@Test
	
	public void basePagNavigation() throws IOException
	{

		
		driver.get(prop.getProperty("url1"));
		LoginPage l=new LoginPage(driver); 
		Assert.assertEquals(l.getLogin().getText(),"React Redux Grid");
		
	}
	
	
	//call the dragandDrop from reactreduxTree.java page
	@Test
	public void dragandDrop() throws IOException, InterruptedException
	{
		reactReduxTree rt=new reactReduxTree(driver);
		rt.dragandDrop();
	}

	@AfterTest
	public void teardown()
	{
		
		driver.close();	
		
	}	
	
}
