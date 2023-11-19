package seleniumLearningBasicsAssignment;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class ExplicitWaitExample extends BaseClass {

	WebDriverWait wait;

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://www.webroot.com/us/en/cart?key=9C8868A3-2846-4BC4-AAFC-C7B9B69AF60C");
		driver.manage().window().maximize();
		// wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void learnExplicitWait() {

		// WebElement cookieBtn =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept
		// All'][1]")));
		WebElement cookieBtn = isElementDisplayed(By.xpath("//button[text()='Accept All'][1]"), 5);
		cookieBtn.click();
	}

//	public WebElement isElementDisplayed(By by, int timeInSec) {
//		return new WebDriverWait(driver, timeInSec).until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

}
