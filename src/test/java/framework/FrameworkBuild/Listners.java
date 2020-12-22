package framework.FrameworkBuild;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import resources.base;

public class Listners implements ITestListener{
	base b= new base();
	public void onTestFailure(ITestResult result) {
		
		try {
			b.getScreenshots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	} 

}
