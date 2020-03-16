package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.BaseClass;


public class HomePage extends BaseClass{
	
	
		
		@FindBy(linkText="More")
		private WebElement moreDD;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignLink;
		
		@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td/img")
		private WebElement signOutMouseOver;

		@FindBy(linkText="Sign Out")
		private WebElement signOutLink;
		
		public WebElement getMoreDD()
		{
			return moreDD;
		}
		
		public WebElement getCampaignLink()
		{
			return campaignLink;
		}
		
		public WebElement getSignOutMouseOver()
		{
			return signOutMouseOver;
		}
		
		public WebElement getSignOutLink()
		{
			return signOutLink;
		}
		
		public void signOutFromVtiger()
		{
			wlib.moveMousePointer(signOutMouseOver);
			signOutLink.click();
			
		}
		public void navigateToCamp()
		{
			wlib.moveMousePointer(moreDD);
			campaignLink.click();
		}
	}


