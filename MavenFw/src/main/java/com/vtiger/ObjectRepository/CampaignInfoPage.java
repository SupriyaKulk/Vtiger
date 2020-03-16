package com.vtiger.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignInfoPage {
	

	
		@FindBy(xpath="//span[contains(text(),'Campaign Information')]")
		private WebElement successMsg;
		
		public WebElement getSuccessMsg()
		{
			return successMsg;
		}
	}



