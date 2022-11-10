package Pomclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.Util1;

public class ProfilePage extends Util1 {
	

	   WebDriver driver;
	
	@FindBy(xpath="//div[@class='NS64GK _1MZ7_i']")     
	private WebElement ManageAddress;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")     
	private WebElement AddNewAddress;
	
	@FindBy(xpath="//textarea[@tabindex='5']")     
	private WebElement DetailAddress;
	
	@FindBy(xpath="//button[text()='Save']")     
	private WebElement SaveButton;
	
	
	 

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void ClickOnManageAddress() {
		ManageAddress.click();
		ManageAddress.click();
	}
	
	public void ClickOnAddNewAddress() {     
		AddNewAddress.click();
	}
	
	public void addAddressData(List<String> addressData) {
		
		for(int i=1; i<=4; i++) {
	driver.findElement(By.xpath("//input[@tabindex='"+i+"']")).sendKeys(addressData.get(i-1));
		}
		
		 DetailAddress.sendKeys(addressData.get(4));
		 
		 SaveButton.click();	
		 
	}
	


}
