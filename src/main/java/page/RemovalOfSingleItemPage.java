package page;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemovalOfSingleItemPage extends BasePage {
	WebDriver driver;
	int checksBeforeRemoval;
	int checksAfterRemoval;
	
	

	public RemovalOfSingleItemPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[name='data']")
	WebElement addElement;
	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement addButtonElement;
	
	@FindBy(how = How.XPATH, using = "//input[@name='todo[2]']")
	WebElement singleItemCheckbox;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")
	WebElement removeButton;
	
	public void addItem() {
		addNewIem(addElement, addButtonElement, "Item");
	}

	public void clickOnSingleItemCheckbox() {
		try {
			List<WebElement> checkboxesBefore = driver.findElements(By.xpath("//ul/li/input[@type='checkbox']"));
			Random rdn = new Random();
			checksBeforeRemoval = checkboxesBefore.size();
			System.out.println("Size of checkboxes before removing:" + checksBeforeRemoval);
			int singleCheck = rdn.nextInt(checksBeforeRemoval);
			if (!checkboxesBefore.get(singleCheck).isSelected()) {
				checkboxesBefore.get(singleCheck).click();
			}
		} catch (Exception e) {
			System.out.println("No checkboxes are available to click on");
		}
	}

	public void clickOnRemoveButton() {
		removeButton.click();
	}

	public void validationOfSingleItemRemoval() {

		List<WebElement> checkboxesAfter = driver.findElements(By.xpath("//ul/li/input[@type='checkbox']"));
		checksAfterRemoval = checkboxesAfter.size();
		System.out.println("Size of checkboxes after removing:" + checksAfterRemoval);
		for (int i = 0; i < checksAfterRemoval; i++) {
			System.out.println(i + " checkbox is displayed " + checkboxesAfter.get(i).isDisplayed());

		}
		int numberOfRemovedCheckedItem = (checksBeforeRemoval - checksAfterRemoval);
		Assert.assertEquals("Removed number of checks does not match: ", 1, numberOfRemovedCheckedItem);
	}
}
