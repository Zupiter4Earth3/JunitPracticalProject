package page;

import java.util.Random;

import org.openqa.selenium.WebElement;

public class BasePage {
	
	public void addNewIem(WebElement ele1, WebElement ele2, String item) {
		Random rdn = new Random();
		int generatedNumber = rdn.nextInt(999);
		ele1.sendKeys(item + generatedNumber );
		ele2.click();
		
		
	}

	}
