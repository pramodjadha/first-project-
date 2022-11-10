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
import Pomclasses.Loginpage;
import Utilclasses.Util1;

public class VerifyUserCanLogin {
	
	WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	 ExtentReports reports ;
	 ExtentTest test;
	
	Loginpage lp;
	 HomePage hp;
	 
	 
	
	@BeforeClass
	@Parameters("browser")
	public void beforeclass(String browser){
		htmlReporter = base1.getHtmlReporter();
		reports = base1.getReports();
		
		test =base1.getExtentTest("VerifyUserCanLogin");
	
		driver = base1.getdriver(browser);       // Initialization 
		
	}
	
	@BeforeMethod
	public void beforemethod() {
		 lp = new Loginpage(driver);
		 hp = new HomePage(driver);
		}
	
	@Test 
	public void VerifyUserLogin() throws IOException {
		
		lp.enterEmailID();
		lp.enterPassword();
		lp.clickOnLoginBtn();
		
         boolean isProfileNameVisible = hp.checkProfileNameVisible();
         
         Assert.assertTrue(isProfileNameVisible);   // Assert can be used instead of below four line 
		
//		if(isProfileNameVisible) {
//			System.out.println("Test case is passed");
//		}else {
//			System.out.println("Test is failed");
//		}
    }
//	@Test
//	public void test2() {
//		hp.searchproduct();
		
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
      reports.flush();		
		
		
	}


}
