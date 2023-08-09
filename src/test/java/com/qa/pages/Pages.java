package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Pages {
	WebDriver driver;

	@FindBy(css = "button._2KpZ6l._2doB4z")
	WebElement PopUpCloseButton;
	public WebElement getPopUpCloseButton() {
		return PopUpCloseButton;
	}

	@FindBy(xpath = "//img[@title=\"Flipkart\"]")
	WebElement FlipKartLogo;
	public WebElement getFlipKartLogo() {
		return FlipKartLogo;
	}

	@FindBy(css = "._3704LK")
	WebElement Search;
	public WebElement getSearch() {
		return Search;
	}

	@FindBy(css = ".L0Z3Pu")
	WebElement Searchbutton;
	public WebElement getSearchbutton() {
		return Searchbutton;
	}

	@FindAll(@FindBy(xpath = "//li[contains(@class,'Y5N33s')]"))
	List<WebElement> SearchDropDown;
	public List<WebElement> getSearchDropDown() {
		return SearchDropDown;
	}

	
	@FindAll(@FindBy(xpath = "//div[@class='_4rR01T']"))
	List<WebElement> SearchedItem;
	public List<WebElement> getSearchedItem() {
		return SearchedItem;
	}


	public Pages(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver2, 60), this);

	}


}
