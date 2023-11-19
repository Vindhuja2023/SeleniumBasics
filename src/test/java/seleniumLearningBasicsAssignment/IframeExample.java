package seleniumLearningBasicsAssignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class IframeExample extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();

	}

	@Test
	public void validateTextInFrame() {
		driver.switchTo().frame("frame1");
	
		Assert.assertEquals(isElementPresent(By.cssSelector("#sampleHeading"), 5).getText(), "This is a sample page");
		//switching to DOM
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");

		Assert.assertEquals(isElementPresent(By.cssSelector("#sampleHeading"), 5).getText(),"This is a sample page");

	}
}
