package seleniumLearningBasicsAssignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class AlertExample extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

	}
	
	@Test
	public void validateSimpleAlert() {

		WebElement alertBtn = isElementClickable(By.cssSelector("#alertButton"), 5);
		alertBtn.click();
		// switching the driver from current DOM to alert window and accepting the alert
		driver.switchTo().alert().accept();

	}

	@Test
	public void validateAlertWithTimeDelay() {

		WebElement alertBtn = isElementClickable(By.cssSelector("#timerAlertButton"), 5);
		alertBtn.click();
		// explicit wait for the time delay of 5s
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// switching the driver from current DOM to alert window and accepting the alert
		// driver.switchTo().alert().accept();
		alert.accept();

	}

	@Test
	public void validateConfirmActionAlert() {

		WebElement alertBtn = isElementClickable(By.cssSelector("#confirmButton"), 5);
		alertBtn.click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();

	}

	@Test
	public void validatePromptAlert() {

		WebElement promtAlertBtn = isElementClickable(By.cssSelector("button#promtButton"), 5);
		promtAlertBtn.click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Vindhuja");
		alert.accept();

	}

}
