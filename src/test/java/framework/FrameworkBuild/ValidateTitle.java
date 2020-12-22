package framework.FrameworkBuild;
import org.apache.logging.log4j.*;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.util.Loader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class ValidateTitle extends base{
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void IniialiseDriver() throws Exception
	{
		driver = initializeDriver();
		log.info("Driver is Initialising");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void basNavigationBar() throws IOException
	{
		
		landingPage lp= new landingPage(driver);
		//Assert.assertEquals(lp.getTitle().getText(), "mohd");
		
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
		
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver=null;
	}

}
