package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
	prop= new Properties();
	//FileInputStream fis=new FileInputStream("C:\\Users\\rahul\\E2EProject\\src\\main\\java\\resources\\data.properties");
	 FileInputStream fis= new FileInputStream("D:\\javaprogram\\FrameworkBuild\\src\\main\\java\\resources\\data.properties");//bymmk

	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		 //System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\javaprogram\\Chrome-WebDriver\\Chrome87\\chromedriver.exe");
		driver= new ChromeDriver();
			//execute in chrome driver
		
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();
		//firefox code
	}
	else if (browserName.equals("IE"))
	{
//		IE code
		
		System.setProperty("webdriver.ie.driver", "D:\\udemey\\SeleniumHubJar\\IEDriver\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;


	}
	
	public void getScreenshots(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.getFileUtils().copyFile(src, new File("D:\\\\udemey\\\\Maven\\\\screenshot\\"+result+"screenshot.png"));
	}
}
