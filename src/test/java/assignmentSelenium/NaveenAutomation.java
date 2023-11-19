package assignmentSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class NaveenAutomation extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void validatePurchaseOfProduct() {

		isElementPresent(By.cssSelector("input#input-email"), 5).sendKeys("vindhuja.rajeev@gmail.com");
		isElementPresent(By.cssSelector("input#input-password"), 5).sendKeys("Vindhuja@2023");
		isElementClickable(By.cssSelector("input[value='Login']"), 5).click();
		Assert.assertEquals(driver.getTitle(), "My Account", "Title is not as expected,login failed");

		// Clicking Laptops and Notebooks
		isElementDisplayed(By.cssSelector("nav>div:nth-of-type(2)>ul>li:nth-of-type(2)>a"), 5).click();
		isElementDisplayed(By.xpath("//a[text()='Show All Laptops & Notebooks']"), 5).click();

		// Selecting the product
		isElementDisplayed(By.xpath("//a[text()='HP LP3065']"), 5).click();

		// Adding the product to cart
		isElementDisplayed(By.cssSelector("button#button-cart"), 5).click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#cart-total")));
		String cartDisplayValue = isElementPresent(By.cssSelector("span#cart-total"), 5).getText();

		Assert.assertEquals(cartDisplayValue, "1 item(s) - $100.00", "The item in cart is not displayed as expected");

		// clicking the cart
		isElementDisplayed(By.cssSelector("span#cart-total"), 5).click();
		isElementPresent(By.cssSelector("p>a:nth-of-type(2)>strong"), 5).click();

		// Filling Billing details
		isElementClickable(By.cssSelector("input[value='new']"), 5).click();

		isElementDisplayed(By.cssSelector("input[name='firstname']"), 5).sendKeys("Vindhuja");
		isElementDisplayed(By.cssSelector("input[name='lastname']"), 5).sendKeys("Rajeev");
		isElementDisplayed(By.cssSelector("input[name='address_1']"), 5).sendKeys("123,Skyline");
		isElementDisplayed(By.cssSelector("input[name='city']"), 5).sendKeys("Toronto");
		isElementDisplayed(By.cssSelector("input[name='postcode']"), 5).sendKeys("2S3 4A6");

		selectFromDropDown(isElementDisplayed(By.cssSelector("select#input-payment-country"), 5), "Canada");
		sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select#input-payment-zone")));
		selectFromDropDown(isElementPresent(By.cssSelector("select#input-payment-zone"), 5), "Nunavut");

		isElementPresent(By.cssSelector("input#button-payment-address"), 5).click();

		sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='existing']")));
		// Validating billing address and shipping address as same
		Assert.assertTrue(isElementPresent(By.cssSelector("input[value='existing']"), 5).isSelected(),
				"Address for Billing is not selected as of existing Address.");
		// clicking continue
		isElementClickable(By.cssSelector("input#button-shipping-address"), 5).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='flat.flat")));

		Assert.assertTrue(isElementClickable(By.cssSelector("input[value='flat.flat']"), 5).isSelected(),
				"Flat rate radio button is not selected.");

		isElementDisplayed(By.cssSelector("textarea.form-control"), 5).sendKeys(
				"If any damage detected while arriving the product,then product will be returned immediately.");

		isElementClickable(By.cssSelector("input#button-shipping-method"), 5).click();

		Assert.assertTrue(isElementClickable(By.cssSelector("input[name='payment_method']"), 5).isSelected(),
				"COD is not selected as expected.");
		isElementClickable(By.cssSelector("input[name='agree']"), 5).click();
		isElementDisplayed(By.cssSelector("input#button-payment-method"), 5).click();

		Assert.assertEquals(isElementDisplayed(By.cssSelector("div>table>tbody>tr>td.text-left>a"), 5).getText(),
				"HP LP3065", "Displayed product name is different than expected.");
		Assert.assertEquals(
				isElementDisplayed(By.cssSelector("div>table>tbody>tr>td.text-right:nth-of-type(3)"), 5).getText(), "1",
				"Product quantity is not as of expected.");

		isElementDisplayed(By.cssSelector("input#button-confirm"), 5).click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sleep(5000);
		// Validating final message after placing order
		Assert.assertEquals(isElementDisplayed(By.cssSelector("div.col-sm-12>h1"), 5).getText(),
				"Your order has been placed!", "Message displayed as not expected,Purchasing the product failed.");
		
		
		//tearDown();

	}

}
