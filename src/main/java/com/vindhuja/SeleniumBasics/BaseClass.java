package com.vindhuja.SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;

	protected WebDriverWait wait;

	public void setup() {

		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\\\Chromedriver\\\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public void tearDown() {
		driver.close();
	}

	public static void sleep(long millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void selectFromDropDown(WebElement element, String visibleText) {

		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);

	}

	public WebElement isElementDisplayed(By by, int timeInSec) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeInSec))
				.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public WebElement isElementClickable(By by, int timeInSec) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeInSec))
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement isElementPresent(By by, int timeInSec) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeInSec))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
