package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;

//get the title of the page	
	By title=By.xpath("//h1/span");
	
	
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	
	public WebElement getLogin()
	{
		return driver.findElement(title);
	}	
	
}
