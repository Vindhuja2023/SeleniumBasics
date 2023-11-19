package assignmentSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class CanadaSimRegistration extends BaseClass {
	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://www.canadasimregister.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void validateRegistration() {
		WebElement firstNameInput = driver.findElement(By.cssSelector("input#FirstName"));
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#LastName"));
		WebElement emailInput = driver.findElement(By.cssSelector("input#EmailID"));
		WebElement mobIndianNumInput = driver.findElement(By.cssSelector("input#Indianmobilenumber"));
		WebElement simReceivedCityInput = driver.findElement(By.cssSelector("select#CityReceived"));

		firstNameInput.sendKeys("Vindhuja");
		lastNameInput.sendKeys("Venugopal");
		emailInput.sendKeys("abc@gmail.com");
		mobIndianNumInput.sendKeys("9991122889");
		selectFromDropDown(simReceivedCityInput, "Bengaluru");
		driver.findElement(By.cssSelector("input#IsConsent")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// tearDown();
	}

	
}
