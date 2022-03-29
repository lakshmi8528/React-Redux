package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class reactReduxComplex {

	//get all the objects from reactRedux Complex page
	public WebDriver driver;
	
	By tablecolumns=By.xpath("//table[@class='react-grid-table react-grid-header-fixed']/thead/tr/th/span[1]");
	By features=By.xpath("//div[@class='sidebarContainer featuresContainer']//ul/li");
	By allcheckbox=By.xpath("//div[3]//input[@class='react-grid-checkbox'][1]");
	
	
	
	public reactReduxComplex(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	//get all the Table Columns from the Complex view and compare with the Actual ones

	public void getTableColumns()
	{
		int i=0;
		String[]  strAc = {"Name","Phone Number","Email","Address",""};
		List<WebElement> strArray =driver.findElements(tablecolumns);
		for(i=0;i<strArray.size();i++)
		{
			Assert.assertEquals(strArray.get(i).getText(),strAc[i]);					
		}	 
		 
	}	
	
	//get all the features from the Complex view and compare with the Actual ones
	public void getFeatures()
	{
		int i=0;
		String[]  strAc = {"Flat List","Sortable","Draggable Columns","Resizeable Columns","Local/Remote Data Source","Checkbox Selection","Multi Select","Pagination","Row Actions and Menus","Hideable Columns"};
		List<WebElement> strArray =driver.findElements(features);
		for(i=0;i<strArray.size();i++)
		{
			Assert.assertEquals(strArray.get(i).getText(),strAc[i]);					
		}	
		
	}
	
	//Check and uncheck the header checkbox and verify
	
	public void checkallcheckbox() throws InterruptedException
	{
		
		driver.findElement(allcheckbox).click();
		Assert.assertEquals(driver.findElement(allcheckbox).getAttribute("value"),"on");
	}
	
}
