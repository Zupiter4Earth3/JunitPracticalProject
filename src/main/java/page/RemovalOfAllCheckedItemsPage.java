package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemovalOfAllCheckedItemsPage extends BasePage {
	WebDriver driver;
	int numberOfItemWithCheckbox;
	
	public RemovalOfAllCheckedItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='data']")
	WebElement addElement;
	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement addButtonElement;
	
	public void addANewItem() {
		addNewIem(addElement, addButtonElement, "Item");
		
	}
	
	public void validationOfRemovalOfAllCheckedItems() {
		try {
			List<WebElement> checkboxes = driver.findElements(By.xpath("//ul/li/input[@type='checkbox']"));
			 numberOfItemWithCheckbox = checkboxes.size();
		for(int i=0; i<checkboxes.size(); i++){
            System.out.println(i+" checkbox is displayed "+checkboxes.get(i).isDisplayed());
            
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("Number of items with checkboxes:" + numberOfItemWithCheckbox);
		Assert.assertEquals("All checkboxes are not removed",0, numberOfItemWithCheckbox);
	}

}
