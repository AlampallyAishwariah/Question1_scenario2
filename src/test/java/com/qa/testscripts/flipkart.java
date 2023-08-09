package com.qa.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

public class flipkart extends TestBase{
	@Test(priority = 0)
	public void checkPopUpCloseButton() throws IOException {
		boolean close=p.getPopUpCloseButton().isEnabled();
		if(close) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver,"checkPopUpCloseButton");
			Assert.assertTrue(false,"popup button is not enabled");
		}
		p.getPopUpCloseButton().click();
	}
	@Test(priority = 1,dependsOnMethods = "checkPopUpCloseButton")
	public void checkPosition() throws IOException {
		if(p.getFlipKartLogo().isDisplayed()) {
			Assert.assertTrue(true,"Flipkart logo is present on page");
			int logoloc=p.getFlipKartLogo().getLocation().getX();
			if(logoloc<500) {
				Assert.assertTrue(true,"Flipkart Logo is on left side of the page");
			}
			else {
				captureScreenshot(driver,"checkPosition");
				Assert.assertTrue(false,"Flipkart Logo is not available on left side");
			}
		}
		else {
			captureScreenshot(driver,"checkPosition");
			Assert.assertTrue(false,"Flipkart logo is not present on the page");
		}
	}
	
	@Test(priority = 2,dependsOnMethods = "checkPopUpCloseButton")
	public void checkSearch() throws InterruptedException, IOException {
		p.getSearch().sendKeys("iphone 14");
		Thread.sleep(2000);
		boolean search_button=p.getSearchbutton().isEnabled();
		if(search_button) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver,"checkSearch");
			Assert.assertTrue(false);
		}
		p.getSearchbutton().click();
		int items=p.getSearchedItem().size();
		System.out.println(" Number of Items Displayed "+items);
		String firstItem=p.getSearchedItem().get(0).getText();
        p.getSearchedItem().get(0).click();
        Set<String> handler=driver.getWindowHandles();
        Iterator<String> li=handler.iterator();
        String ParentHandleID=li.next();
        String ChildHandleID=li.next();
        driver.switchTo().window(ChildHandleID);
        String selectedfirstitem=driver.getTitle();
        if(driver.getPageSource().contains(firstItem) && selectedfirstitem.contains("APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com")) {
        	Assert.assertTrue(true);
        }
        else {
        	//captureScreenshot(driver,"checkSearch");
        	Assert.assertTrue(false,"Not Naviagted to correct page");
        }
        Assert.assertEquals(selectedfirstitem,"APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com",
        		"title is not correct");
	}
}
