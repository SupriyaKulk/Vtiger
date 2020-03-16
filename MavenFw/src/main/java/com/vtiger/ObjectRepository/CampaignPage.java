package com.vtiger.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignPage {
	
		
		@FindBy(css="img[title='Create Campaign...']")
		private WebElement createCampaign;
		
		public WebElement getCreateCampaign()
		{
			return createCampaign;
		}
		public void navigateCreateNewCampaign()
		{
			createCampaign.click();
		}
	}



