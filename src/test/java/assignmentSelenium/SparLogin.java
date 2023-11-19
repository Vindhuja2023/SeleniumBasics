package assignmentSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vindhuja.SeleniumBasics.BaseClass;

public class SparLogin extends BaseClass {

	@BeforeMethod
	public void intialize() {
		setup();
		driver.get("https://sparinc.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void validateClickingLoginsBtn() {
		driver.findElement(By.xpath("//a[text()='ACCEPT']")).click();
		driver.findElement(By.cssSelector("svg#svg-fancy_icon-204-18>use")).click();

		List<WebElement> navigationElements = driver.findElements(By.cssSelector("ul#menu-spar-menu-canvas>li>a>span"));
		for (int i = 0; i < navigationElements.size(); i++) {
			if (navigationElements.get(i).getText().equals("LOGINS")) {
				navigationElements.get(i).click();

			}

		}
		
		tearDown();
	}

}
