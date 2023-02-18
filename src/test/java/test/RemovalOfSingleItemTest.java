package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.RemovalOfSingleItemPage;
import util.BrowserFactory;

public class RemovalOfSingleItemTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToRemoveSigleItem() {
		 driver = BrowserFactory.init();
		 RemovalOfSingleItemPage removalOfSingleItemPage = PageFactory.initElements(driver, RemovalOfSingleItemPage.class);
		 removalOfSingleItemPage.addItem();
		 removalOfSingleItemPage.clickOnSingleItemCheckbox();
		 removalOfSingleItemPage.clickOnRemoveButton();
		 removalOfSingleItemPage.validationOfSingleItemRemoval();
		 BrowserFactory.tearDown();
	}
}
