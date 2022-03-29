package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
//get all the urls and data from properties file	
 prop= new Properties();
 String dataproperties_path = System.getProperty("user.dir")+"/src/main/java/resources/data.properties";
FileInputStream fis=new FileInputStream(dataproperties_path);

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);
//invoke chrome browser 
if(browserName.equals("chrome"))
{
	String chrome_path = System.getProperty("user.dir")+"/src/main/java/resources/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chrome_path);
	 ChromeOptions options = new ChromeOptions();
		options. addArguments("headless");
	driver= new ChromeDriver(options);
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	//Take screenshot and get report
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
