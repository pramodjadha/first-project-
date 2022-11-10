package Baseclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base1 {
	
	static WebDriver driver;                                        // Initialization
	
	static  ExtentHtmlReporter htmlReporter;
	static ExtentReports reports ;
	static ExtentTest test;
	

	public static WebDriver getdriver(String browser) {
	
	
	    if(driver == null){
	    	
	    	if(browser.equals("chrome")) {
	    		
	        WebDriverManager.chromedriver().setup();  // We can use WebDriverManager instead of below system.setproperty
	        
	//      System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\selenium\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
	   	    driver = new ChromeDriver(); 
	    		
	    	}     else if(browser.equals("firefox"))     
	    	
	    	{
	    	 WebDriverManager.firefoxdriver().setup();   // We can use WebDriverManager instead of below system.setproperty
	    	 
	//    	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
	    	 driver = new FirefoxDriver();
	    	}
	    	 
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
        return driver;
	}
	
	public static void unloaddriver() {
		driver = null;
	}
	
    public static ExtentHtmlReporter getHtmlReporter() {
    	if ( htmlReporter ==null) {
    		
    		htmlReporter = new  ExtentHtmlReporter("ExtentReports.html");
    	}
    	
    	return htmlReporter;
    }
    
    public static ExtentReports getReports() {
      	if ( reports ==null) {
      		
      		reports = new ExtentReports ();
      		reports.attachReporter(htmlReporter);
    	    	}
      	 return reports;
    	 }
    
     public static ExtentTest getExtentTest(String testName) {
    
    	   return reports.createTest(testName);
    	    	    	
    	
    }
    		
    		
    		
    		
    		
}
