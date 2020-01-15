package utilities;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ReusableFunctions {
	
	
	public void switchToWindow(String windowTitle, WebDriver driver){
		String parentID=driver.getWindowHandle();
		Set windowIDs= driver.getWindowHandles();
		ArrayList<String> ids=new ArrayList<String>(windowIDs);
		for (int i = 0; i < ids.size(); i++) {
			String ActwinTitle=driver.switchTo().window(ids.get(i)).getTitle().trim();
			if(ActwinTitle.equalsIgnoreCase(windowTitle))
				break;
			else
				driver.switchTo().window(parentID);
		}
		
	}

}
