package Pomclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.Util1;

public class HomePage extends Util1 {
	
	 WebDriver driver;
     
     
		@FindBy(xpath="(//div[@class='exehdJ'])[1]")     
		private WebElement profileName;
	
		@FindBy(xpath="//input[@name='q']")
		private WebElement searchfield;
		
		@FindBy(xpath="(//div[@class='_2kHMtA'])[1]")  
		private WebElement firstproduct;
		
		@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")  
		private List<WebElement> ProductPriceElementList;
		
		@FindBy(xpath=" (//li[@class='_2NOVgj'])[1]")     
		private WebElement MyProfilrText;
		
		
		
		
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		
		
		public boolean checkProfileNameVisible() {
			
			try {
				waitTillElementPresent(driver , By.xpath("(//div[@class='exehdJ'])[1]"));
				
			} catch(Exception e)
			{
				return false;
			}
			
			return true;
		}
		
		public void searchproduct() {
			searchfield.click();
		    searchfield.sendKeys("realme");
			searchfield.sendKeys(Keys.ENTER);
			waitTillElementPresent(driver,firstproduct);
		
		}
		
		public int getLowestPrice() {
			
	        List<Integer> productPriceList =  new ArrayList<>();	
			for(WebElement k : ProductPriceElementList) {
				productPriceList.add(Integer.parseInt(k.getText().replace("₹","").replace(",", "")));  
		}
			Collections.sort(productPriceList);
			return productPriceList.get(0);
		}

		public void SwitchPage(int i) {
			driver.findElement(By.xpath("//a[@class='ge-49M' and text()='"+i+"']")).click();
			waitTillElementPresent(driver, By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+i+"']"));
					
		}
		
     public boolean ClickonmyProfile() {
     	
     	MovetoElement(driver, profileName);
     	profileName.click();
     	MyProfilrText.click();
     	try {
     	waitTillElementPresent(driver, By.xpath("//span[text()='Personal Information']"));
     	}catch(Exception e) {
     		return false;
     	}
     	return true;
     }



}
