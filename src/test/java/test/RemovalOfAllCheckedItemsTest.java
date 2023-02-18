package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.RemovalOfAllCheckedItemsPage;
import page.RemovalOfSingleItemPage;
import page.ToggleCheckboxPage;
import util.BrowserFactory;

public class RemovalOfAllCheckedItemsTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToRemoveSigleItem() {
		 driver = BrowserFactory.init();
		 
		 ToggleCheckboxPage toggleCheckboxPage = PageFactory.initElements(driver, ToggleCheckboxPage.class);
		 toggleCheckboxPage.clickToggleAllCheckbox();
		 
		 RemovalOfSingleItemPage removalOfSingleItemPage = PageFactory.initElements(driver, RemovalOfSingleItemPage.class);
		 removalOfSingleItemPage.clickOnRemoveButton();
		 
		 RemovalOfAllCheckedItemsPage removalOfAllCheckedItemsPage = PageFactory.initElements(driver, RemovalOfAllCheckedItemsPage.class);
		 removalOfAllCheckedItemsPage.validationOfRemovalOfAllCheckedItems();
		 
		 BrowserFactory.tearDown();
	}

}
