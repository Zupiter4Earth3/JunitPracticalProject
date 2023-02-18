package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ToggleCheckboxPage extends BasePage {
	WebDriver driver;
	
	public ToggleCheckboxPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "input[name='data']")WebElement addElement;
	@FindBy(how = How.CSS, using = "input[value='Add']")WebElement addButtonElement;
	@FindBy(how = How.CSS,using ="input[value = 'on']") WebElement toggleAllCheckbox;
	
	public void addItem() {
		addNewIem(addElement, addButtonElement, "Item");
	}

	public void clickToggleAllCheckbox() {
		toggleAllCheckbox.click();
	}
	
		
	public void validateSelectionOfAllChekboxes() {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//ul/li/input[@type='checkbox']"));
		
		
		int checkedCount=0, uncheckedCount=0;
        for(int i=0; i<checkboxes.size(); i++){
            System.out.println(i+" checkbox is selected "+checkboxes.get(i).isSelected());
            if(checkboxes.get(i).isSelected()){
                checkedCount++;
            }else{
                uncheckedCount++;
            }
        }
        System.out.println("number of selected checkbox: "+checkedCount);
        System.out.println("number of unselected checkbox: "+uncheckedCount);
        Assert.assertEquals("All checkboxes are not checked", 0, uncheckedCount);
    }

}


