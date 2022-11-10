package Pomclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.Util1;

public class Loginpage extends Util1 {
	
	WebDriver driver;

	@FindBy(xpath="(//input[@type='text'])[2]" )
	private WebElement emailId;
    
	@FindBy(xpath="//input[@type='password']" )
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]" )
	private WebElement loginBtn;


  
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public void enterEmailID() throws IOException {
		emailId.sendKeys(getdatafromconfig("email"));
	}
	
	public void enterPassword() throws IOException {
		password.sendKeys(getdatafromconfig("password"));
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	



}
