package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.ToggleCheckboxPage;
import util.BrowserFactory;

public class ToggleCheckboxTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToCheckAllWithToggleAllCheckBox() {
		 driver = BrowserFactory.init();
		 
		 ToggleCheckboxPage toggleCheckboxPage = PageFactory.initElements(driver, ToggleCheckboxPage.class);
		 toggleCheckboxPage.addItem();
		 toggleCheckboxPage.clickToggleAllCheckbox();
		 
		 toggleCheckboxPage.validateSelectionOfAllChekboxes();
		 
		
		 
	 BrowserFactory.tearDown();
		  
	}

}
