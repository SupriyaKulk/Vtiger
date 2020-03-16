package com.vtiger.TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.vtiger.ObjectRepository.CampaignInfoPage;
import com.vtiger.ObjectRepository.CampaignPage;
import com.vtiger.ObjectRepository.CreateNewCampaignPage;
import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.genericLib.BaseClass;





@Listeners(com.vtiger.genericLib.ListenerImplementation.class)

public class CreateCampTest extends BaseClass{
	
		@Test
		
		public void createCamp() throws IOException
		{
			HomePage hp=PageFactory.initElements(driver, HomePage.class);
			CampaignPage cp= PageFactory.initElements(driver, CampaignPage.class);
			CreateNewCampaignPage cncp=PageFactory.initElements(driver, CreateNewCampaignPage.class);
			CampaignInfoPage cip=PageFactory.initElements(driver, CampaignInfoPage.class);
			
			
			hp.navigateToCamp();
			cp.navigateCreateNewCampaign();
			cncp.createCampaignWithMandatoryField();
			String ActMsg=cip.getSuccessMsg().getText();
			String ExpMsg=data.fetchDatafromExcel("Campaigndata",6, 1);
			Assert.assertTrue(ActMsg.contains(ExpMsg));
			System.out.println("Campaign created Successfully");
			
		}

	}



