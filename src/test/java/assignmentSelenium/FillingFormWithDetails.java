package assignmentSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class FillingFormWithDetails extends BaseClass {
	
	WebDriverWait wait;

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait = new WebDriverWait(driver, 10);

	}

	@Test
	public void validateFillingTheDetails() {

		driver.findElement(By.xpath("//button[text()='Accept All']")).click();

		WebElement emailInput = driver.findElement(By.xpath("//input[@name='billing.customer_email']"));
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='billing.first_name']"));
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='billing.last_name']"));
		WebElement addressInput = driver.findElement(By.xpath("//input[@name='billing.address_1']"));
		WebElement countrySelect = driver.findElement(By.xpath("//select[@name='billing.country']"));
		WebElement stateSelect = driver.findElement(By.xpath("//select[@name='billing.state']"));
		WebElement cityInput = driver.findElement(By.xpath("//input[@name='billing.city']"));
		WebElement postalCodeInput = driver.findElement(By.xpath("//input[@name='billing.postal_code']"));
	

		emailInput.sendKeys("vindhuja@gmail.com");
		firstNameInput.sendKeys("Vindhuja");
		lastNameInput.sendKeys("Venugopal");
		addressInput.sendKeys("123,skyline");

		selectFromDropDown(countrySelect, "Canada");
		selectFromDropDown(stateSelect, "Ontario");
		cityInput.sendKeys("Brampton");
		postalCodeInput.sendKeys("647B567");
		//WebElement clickBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='shipping_same_as_billing']")));
		//clickBtn.click();
		
		

		// tearDown();

	}

}
