package Testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Baseclasses.base1;
import Pomclasses.HomePage;
import Utilclasses.Util1;

    public class VerifyUserCanGetLowestPriceProduct {
	
	WebDriver driver;
	 HomePage hp;
	 
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports reports ;
	 ExtentTest test;
	
	
	@BeforeClass
	@Parameters("browser")
     public void beforeclass(String browser){
			htmlReporter = base1.getHtmlReporter();
			reports = base1.getReports();
			
			test =base1.getExtentTest("VerifyUserCanGetLowestPriceProduct");
		

		driver = base1.getdriver( browser);
		
	}
	
	@BeforeMethod
	public void beforemethod() {
	    hp = new HomePage(driver);
		
	}
	
	@Test
	public void VerifyUserGetLowestPriceProduct() {
		hp.searchproduct();
		
		for(int i=1; i<=5; i++) {
			if(i != 1) {
				hp.SwitchPage(i);
			}
		
	//	System.out.println(hp.getLowestPrice());
		
		Assert.assertNotEquals(hp.getLowestPrice(),"");    // Assert not equals to can be used instead of above single line 
		}
		
	}
	
//	@Test(priority=0, timeOut=4000 ) 
//	public void test2() throws InterruptedException {
//		Thread.sleep(4000);
//		System.out.println("test2 called");
//		
//	}
//	
//	@Test(priority=1,dependsOnMethods={"test2","test5"})
//	public void test3() {
//		System.out.println("test3 called");
//		
//	}
//	
//	@Test(priority=3,enabled=false)
//	public void test4() {
//	//	Assert.fail();
//		System.out.println("test4 called");
//		
//	}
//	
//	@Test(priority=2)
//	public void test5() {
//		System.out.println("test5 called");
//		
//	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.SUCCESS) 
	       {
	    	//	test.log(Status.PASS, result.getName() + "is Passed");
	    		String path =	Util1.getscreenshotpath(driver , result.getName());
	    		test.log(Status.PASS, result.getName() + "is Passed" , MediaEntityBuilder.createScreenCaptureFromPath(path).build());

	    		
	       } else if(result.getStatus()==ITestResult.FAILURE) {
	        	String path =	Util1.getscreenshotpath(driver , result.getName());
	    		test.log(Status.FAIL, result.getName() + "is Failed" , MediaEntityBuilder.createScreenCaptureFromPath(path).build());

	    	   } else if(result.getStatus()==ITestResult.SKIP) {
	        	
	    		 test.log(Status.SKIP, result.getName() + "is Skipped");
	    	}
			
			
		}
		
	
	
	@AfterClass
	public void afterclass() {
		
		base1.unloaddriver();
		reports.flush();
		
	}


}
