package com.vtiger.ObjectRepository;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.BaseClass;

public class CreateNewCampaignPage extends BaseClass {
	
		@FindBy(name="campaignname")
		private WebElement campaignNameTb;
		
		@FindBy(css="input[value='  Save  ']")
		private WebElement saveBtn;
		
		public WebElement getCampaignNameTb()
		{
			return campaignNameTb;
		}
		
		public WebElement getSaveBtn()
		{
			return saveBtn;
		}

		public void createCampaignWithMandatoryField() throws IOException
		{
			campaignNameTb.sendKeys(data.fetchDatafromExcel("Campaigndata",6,1));
			saveBtn.click();
			
		}
	}



