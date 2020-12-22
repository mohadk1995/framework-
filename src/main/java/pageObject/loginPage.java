package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	WebDriver driver;
	
	
	By email= By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By logIn=By.cssSelector("input[class*='login-button']");
	
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	  
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogInd()
	{
		return driver.findElement(logIn);
	}

}
