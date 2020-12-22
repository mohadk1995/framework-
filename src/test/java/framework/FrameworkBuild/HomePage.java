package framework.FrameworkBuild;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class HomePage extends base {
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(HomePage.class.getName());
	
	
	
	@BeforeTest
	public void IniialiseDriver() throws Exception
	{
		driver = initializeDriver();
		log.info("Mohammed");
		
	}
	
	@Test(dataProvider="getData")
	public void BaseIntialization(String username, String Password) throws Exception
	{
		
		
		driver.get(prop.getProperty("url"));
		
		landingPage lp= new landingPage(driver);
		//Assert.assertEquals(lp.getTitle().getText(), "mohd");
		lp.SignIn().click(); 
		
		loginPage log=new loginPage(driver);
		log.getEmail().sendKeys(username);
		log.getPassword().sendKeys(Password);
		log.clickLogInd().click();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="mohadk1995";
		data[0][1]="1234";
		
	data[1][0]="tasnim";
		data[1][1]="147";
		
		return data;
	}
	

}
