package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	WebDriver driver;
	
	
	By signIn= By.cssSelector("a[href*='sign_in']");
	//By title= By.cssSelector("body:nth-child(2) section:nth-child(6) div.container div.text-center > h2:nth-child(1)");
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar=By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]");
	////h2[contains(text(),'Featured Courses')]
	
	
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	  
	public WebElement SignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}

}
