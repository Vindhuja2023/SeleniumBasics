package seleniumLearningBasicsAssignment;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class WindowExample extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();

	}

	@Test
	public void validateTextFromTabs() {

		WebElement newTabBtn = isElementClickable(By.cssSelector("#tabButton"), 5);
		String parentWindowHandle = driver.getWindowHandle();
		newTabBtn.click();

		Set<String> windowHandles = driver.getWindowHandles();
		String childWindowHandle = "";
		for (String handle : windowHandles) {
			if (!handle.equals(windowHandles)) {
				childWindowHandle = handle;
			}
		}
		driver.switchTo().window(childWindowHandle);
		Assert.assertEquals(isElementPresent(By.cssSelector("#sampleHeading"), 5).getText(), "This is a sample page",
				"New tab opening failed");

		driver.close();

		driver.switchTo().window(parentWindowHandle);

	}

	@Test
	public void validateTabWithTitleGiven() {

		WebElement newTabBtn = isElementClickable(By.cssSelector("#tabButton"), 5);
		String parentWindowHandle = driver.getWindowHandle();
		newTabBtn.click();

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> handleList = new ArrayList<String>(windowHandles);
		String titleOfthePage = "";

		for (String handle : handleList) {

			driver.switchTo().window(handle);
			if (driver.getTitle().equals(titleOfthePage)) {
				System.out.println(driver.getCurrentUrl());
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}

	@Test
	public void validateMultipleTabsOpened() {
		String parentWindowHandle = driver.getWindowHandle();
		String childWindowHandle = "";
		WebElement newTabBtn = isElementClickable(By.cssSelector("#tabButton"), 5);
		WebElement newWindowBtn = isElementClickable(By.cssSelector("#windowButton"), 5);
		WebElement newMsgWindowBtn = isElementClickable(By.cssSelector("#messageWindowButton"), 5);
		newTabBtn.click();
		newMsgWindowBtn.click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> handleList1 = new ArrayList<String>(windowHandles1);
		newWindowBtn.click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> handleList2 = new ArrayList<String>(windowHandles2);

		// gives common elements in both list
		handleList1.retainAll(handleList2);
		// removes additional elements
		handleList2.removeAll(handleList1);

		childWindowHandle = handleList2.get(0);
		driver.switchTo().window(childWindowHandle);

		Assert.assertEquals(isElementPresent(By.cssSelector("#sampleHeading"), 5).getText(), "This is a sample page",
				"New tab opening failed");
		driver.switchTo().window(parentWindowHandle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
