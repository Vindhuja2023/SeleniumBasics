package assignmentSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;



public class CarboniteLogin extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://account.carbonite.com/account/logon");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	@Test
	public void valenidateAccountSignUp() {
	driver.navigate().to("https://www.carbonite.com/personal/trial/");
	isElementDisplayed(By.xpath("//button[@id='onetrust-accept-btn-handler']"), 5).click();

	
	isElementDisplayed(By.cssSelector("input#personal-trial-email"), 5).sendKeys("vin@gmail.com");
	isElementDisplayed(By.cssSelector("input#personal-trial-confirm-email"), 5).sendKeys("vin@gmail.com");
	isElementDisplayed(By.cssSelector("input#personal-trial-password"), 5).sendKeys("Vin123!123");
	isElementDisplayed(By.cssSelector("input#personal-trial-confirm-password"), 5).sendKeys("Vin123!123");
	
	
	// automate auto suggestion box
	
	 WebElement countryOfResidence =driver.findElement(By.cssSelector("button.css-br4uza"));
	 countryOfResidence.sendKeys("Canada");
	 countryOfResidence.sendKeys(Keys.ARROW_DOWN);
	 countryOfResidence.sendKeys(Keys.ENTER);
	    
	
//	isElementPresent(By.cssSelector("button.css-br4uza"), 10).sendKeys("Canada");
//	isElementPresent(By.cssSelector("button.css-br4uza"), 10).click();
	

	isElementDisplayed(By.cssSelector("button[type='submit']>p"), 5).submit();
	
	
	
	
	
	
	}

	@Test(enabled = false)
	public void valenidateAccountLogin() {
		// clicking Accept All
		isElementDisplayed(By.xpath("//button[@id='onetrust-accept-btn-handler']"), 5).click();

		isElementPresent(By.cssSelector("input#email"), 5).sendKeys("vindhuja.rajeev@gmail.com");
		isElementPresent(By.cssSelector("input#Password"), 5).sendKeys("Vindhuja@1994");
		driver.switchTo().frame(0);
		isElementClickable(By.cssSelector("div.recaptcha-checkbox-border"), 5).click();

		driver.switchTo().defaultContent();
		isElementPresent(By.cssSelector("button#vueloginButton"), 5).click();
		
		//tearDown();

	}
}
