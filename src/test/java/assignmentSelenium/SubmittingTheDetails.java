package assignmentSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class SubmittingTheDetails extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		driver.manage().window().maximize();
		
	}

	@Test
	public void validateSubmittingDetails() {

		WebElement nameInput = driver.findElement(By.cssSelector("#input-name"));
		WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
		WebElement enquiryInput = driver.findElement(By.cssSelector("#input-enquiry"));
		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));

		nameInput.sendKeys("Vindhuja");
		emailInput.sendKeys("abc@gmail.com");
		enquiryInput.sendKeys(" What kind of computers and laptop available ?");

		submitBtn.submit();
		
	
		Assert.assertEquals(driver.getTitle(), "Contact Us");

		//tearDown();
	}

}
