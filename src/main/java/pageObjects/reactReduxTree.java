package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class reactReduxTree {

	//get all the objects from reactRedux Tree page
	public WebDriver driver;
	
	By tablecolumns=By.xpath("//table[@class='react-grid-table react-grid-header-fixed']/thead/tr/th/span[1]");
	By features=By.xpath("//div[@class='sidebarContainer featuresContainer']//ul/li");
	By dragfirstrow=By.xpath("//tr[@class='react-grid-row'][1]");
	By droptothirdrow=By.xpath("//tr[@class='react-grid-row'][3]");
	By title=By.xpath("//h1/span");
	
	
	
	public reactReduxTree(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
    //get all the Table Columns from the Tree view and compare with the Actual ones
	public void getTableColumns()
	{
		int i=0;
		String[]  strAc = {"Name","Phone Number","Email","Address"};
		List<WebElement> strArray =driver.findElements(tablecolumns);
		for(i=0;i<strArray.size();i++)
		{
			Assert.assertEquals(strArray.get(i).getText(),strAc[i]);					
		}	 
		 
	}	
	
	//get all the features from the Tree view and compare with the Actual ones
	
	public void getFeatures()
	{
		int i=0;
		String[]  strAc = {"Tree Structure","Drag amd Drop Rows","Show/Hide Actions"};
		List<WebElement> strArray =driver.findElements(features);
		for(i=0;i<strArray.size();i++)
		{
			Assert.assertEquals(strArray.get(i).getText(),strAc[i]);					
		}	
		
	}
	
	//Verify drag and drop feature by dragging from first row and moving to third row
	public void dragandDrop() throws InterruptedException
	{
		
		WebElement fromElement = driver.findElement(dragfirstrow);

		WebElement toElement = driver.findElement(droptothirdrow);
		
		Actions builder = new Actions(driver);
	
		Action dragAndDrop = builder.clickAndHold(fromElement)
		.moveToElement(toElement)
		.release(toElement)
		.build();
		
		
		dragAndDrop.perform();	
	}
	
}
