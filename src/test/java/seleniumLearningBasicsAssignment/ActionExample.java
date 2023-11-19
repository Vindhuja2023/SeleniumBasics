package seleniumLearningBasicsAssignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class ActionExample extends BaseClass {

	Actions actions;

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		actions = new Actions(driver);
	}

	@Test
	public void validateMouseClickAction() {

		WebElement clickMeBtn = isElementClickable(By.xpath("//button[text()='Click Me']"), 5);

		// Perform a click
		actions.click(clickMeBtn).perform();
		WebElement msgElement = isElementDisplayed(By.cssSelector("#dynamicClickMessage"), 5);
		Assert.assertEquals(msgElement.getText(), "You have done a dynamic click");

	}

	@Test
	public void validateRightClickAction() {

		WebElement rightClickMeBtn = isElementClickable(By.cssSelector("#rightClickBtn"), 5);

		// Perform a right click
		actions.contextClick(rightClickMeBtn).perform();
		WebElement msgElement = isElementDisplayed(By.cssSelector("#rightClickMessage"), 5);
		Assert.assertEquals(msgElement.getText(), "You have done a right click");

	}

	@Test
	public void validateDoubleClickAction() {

		WebElement doubleClickMeBtn = isElementClickable(By.cssSelector("#doubleClickBtn"), 5);

		// Perform double click
		actions.doubleClick(doubleClickMeBtn).perform();
		WebElement msgElement = isElementDisplayed(By.cssSelector("#doubleClickMessage"), 5);
		Assert.assertEquals(msgElement.getText(), "You have done a double click");

	}

	@Test
	public void validateHoverMouseAction() {

		driver.navigate().to("https://demoqa.com/tool-tips");
		WebElement toolTipElement = isElementDisplayed(By.cssSelector("#toolTipButton"), 5);

		actions.moveToElement(toolTipElement).perform();
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("#toolTipButton"), "aria-describedby",
				"buttonToolTip"));

		Assert.assertEquals(toolTipElement.getAttribute("aria-describedby"), "buttonToolTip");

	}

}
