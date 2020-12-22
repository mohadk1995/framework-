package framework.FrameworkBuild;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Default;

public class UploadandDownloadFile {
	
	@Test
	public void UploadDownload() throws Exception
	{
		
		String downloadPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "D:\\javaprogram\\Chrome-WebDriver\\Chrome87\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String, Object>();
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory",downloadPath);
		options.setExperimentalOption("prefs",chromeprefs);
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://smallpdf.com/pdf-to-jpg");
		
		driver.findElement(By.xpath("//span[contains(text(),'Choose File')]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\DELL Inspiron 5570\\Desktop\\Tickets\\uploadfile.exe");
		//Thread.sleep(30000);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]")));
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]")).click();
	driver.findElement(By.xpath("//button[@class='sc-1mvwhop-0 hKtorq']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download')]")));
	driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
	
	
	File f= new File(downloadPath+"/Mumbai_Dahod_12dec-images.zip");
	if(f.exists());
	{
		System.out.println("Success");
	}
	
	}

}
